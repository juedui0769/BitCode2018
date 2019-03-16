package com.wxg.nio;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 2019-3-16 16:04:36
 * <p>
 * 视频中老师在Mac系统下运行良好，我在windows的`telnet`下运行的不是很好，
 * <ul>
 *     <li>不能输入多个字符，输入`hello`，服务端接受的字符是一个一个的</li>
 * </ul>
 *
 */
public class NioTest13Server {
    private static final int PORT = 8899;
    public static void main(String[] args) throws IOException {

        Map<String, SocketChannel> clientMap = new HashMap<>();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(PORT));

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            try {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                selectionKeys.forEach(selectionKey -> {
                    final SocketChannel client;
                    try {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel serverChannel = (ServerSocketChannel)selectionKey.channel();
                            client = serverChannel.accept();
                            client.configureBlocking(false);

                            client.register(selector, SelectionKey.OP_READ);

                            String key = "[" + UUID.randomUUID().toString() + "]";
                            clientMap.put(key, client);
                        } else if (selectionKey.isReadable()) {
                            // SocketChannel clientChannel = (SocketChannel)selectionKey.channel();
                            client = (SocketChannel)selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                            int count = client.read(readBuffer);

                            if (count > 0) {
                                readBuffer.flip();

                                Charset charset = Charset.forName("utf-8");
                                String receiveMessage = String.valueOf(charset.decode(readBuffer).array());

                                System.out.println(client + ": " + receiveMessage);

                                String senderKey = null;
                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    if (client == entry.getValue()) {
                                        senderKey = entry.getKey();
                                        break;
                                    }
                                }

                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    SocketChannel clientChannel = entry.getValue();

                                     if (clientChannel != client) {
                                         ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                         writeBuffer.put((senderKey + ": " + receiveMessage).getBytes());
                                         writeBuffer.flip();

                                         clientChannel.write(writeBuffer);
                                     }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                selectionKeys.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
