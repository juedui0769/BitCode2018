package com.wxg.nio;

import sun.nio.ch.DefaultSelectorProvider;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

/**
 * 2019年3月16日03:51:18
 * <p>
 * https://www.bilibili.com/video/av33707223?p=40
 * <p>
 * http://tool.oschina.net/uploads/apidocs/jdk-zh/java/nio/channels/Selector.html
 * <p>
 * （1）代码有问题，运行后，windows上`telnet localhost 5000` 发现输入一个字符就被抓取到了
 * <ul>
 *     <li>我怀疑是因为没有边界符号的缘故，必然“回车”</li>
 * </ul>
 * （2）另一个问题是 `telnet` 关闭后，服务端一直不停地输出内容。
 */
public class NioTest12Selector {
    public static void main(String[] args) throws Exception {
        int[] ports = new int[]{5000, 5001, 5002, 5003, 5004};

        Selector selector = Selector.open();

//        System.out.println(SelectorProvider.provider().getClass());
//        System.out.println(DefaultSelectorProvider.create().getClass());

        for (int i = 0; i < ports.length; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress(ports[i]));

            //
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口： " + ports[i]);
        }

        while (true) {
            int numbers = selector.select();
            System.out.println("numbers : " + numbers);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys : " + selectionKeys);

            Iterator<SelectionKey> iter = selectionKeys.iterator();
            while (iter.hasNext()) {
                SelectionKey nextSelKey = iter.next();
                if (nextSelKey.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel)nextSelKey.channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);

                    socketChannel.register(selector, SelectionKey.OP_READ);

                    iter.remove();

                    System.out.println("获得客户端连接： " + socketChannel);
                } else if (nextSelKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) nextSelKey.channel();

                    int bytesRead = 0;

                    ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                    while (true) {
                        byteBuffer.clear();
                        int read = channel.read(byteBuffer);
                        if (read <= 0) {
                            break;
                        }

                        byteBuffer.flip();

                        channel.write(byteBuffer);

                        bytesRead += read;
                    }

                    System.out.println("读取到的字节： " + bytesRead + ", 来自于: " + channel);

                    iter.remove();
                }
            }
        }
    }
}
