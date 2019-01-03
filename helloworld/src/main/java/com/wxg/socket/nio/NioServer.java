package com.wxg.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * 2019年1月3日15:22:48
 * from 《看透Spring MVC: 源代码分析与实践》， 4.2
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        // 创建`ServerSocketChannel`，监听`8080`端口
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8008));
        // 设置为非阻塞模式
        ssc.configureBlocking(false);
        // 为`ServerSocketChannel`注册选择器
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        // 创建处理器
        Handler handler = new Handler(1024);

        while (true) {
            // 等待请求，每次等待阻塞3s，超过3s后线程继续向下执行，如果传入0或者不传参数将一直阻塞
            if (selector.select(3000) == 0) {
                System.out.println("等待请求超时……");
                continue;
            }
            System.out.println("处理请求……");
            // 获取待处理的`SelectionKey`
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                try {
                    if (key.isAcceptable()) {
                        handler.handleAccept(key);
                    }
                    if (key.isReadable()) {
                        handler.handleRead(key);
                    }
                } catch (Exception ex) {
                    keyIterator.remove();
                    continue;
                }
                // 处理完后，从待处理的`SelectionKey`迭代器中移除当前所使用的`key`
                keyIterator.remove();
            }
        }
    }

    private static class Handler {
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";
        public Handler() {}
        public Handler(int bufferSize) {
            this(bufferSize, null);
        }
        public Handler(String localCharset) {
            this(-1, localCharset);
        }
        public Handler(int bufferSize, String localCharset) {
            if (bufferSize > 0) {
                this.bufferSize = bufferSize;
            }
            if (localCharset != null) {
                this.localCharset = localCharset;
            }
        }

        public void handleAccept(SelectionKey key) throws IOException {
            SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
            sc.configureBlocking(false);
            sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        public void handleRead(SelectionKey key) throws IOException {
            SocketChannel sc = (SocketChannel) key.channel();
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            buffer.clear();
            if (sc.read(buffer) == -1) {
                sc.close();
            } else {
                buffer.flip();
                // 将`buffer`中接收到的值以`localCharset`格式编码后保存到`receivedString`中。
                String receivedString = Charset.forName(localCharset)
                        .newDecoder().decode(buffer).toString();
                System.out.println("received from client : " + receivedString);

                //
                String sendString = "received data : " + receivedString;
                ByteBuffer wrap = ByteBuffer.wrap(sendString.getBytes(localCharset));
                sc.write(wrap);
                sc.close();
            }
        }
    }
}
