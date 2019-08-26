package com.wxg.study.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class SelectionKeyExample {

    @Test
    public void test01() throws IOException {
        int opAccept = SelectionKey.OP_ACCEPT;
        int opConnect = SelectionKey.OP_CONNECT;
        int opRead = SelectionKey.OP_READ;
        int opWrite = SelectionKey.OP_WRITE;
        int all = opAccept | opConnect | opRead | opWrite;
        System.out.printf("opAccept: %d , opConnect: %d, opRead: %d, opWrite: %d\n",
                opAccept, opConnect, opRead, opWrite);
        System.out.printf("opAccept: %d\n", opAccept);
        System.out.printf("all: %d\n", all);
        System.out.println((opAccept & opConnect));
        System.out.println((opAccept & all));

//        Selector selector = Selector.open();
//        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//        serverSocketChannel.configureBlocking(false);
//        SelectionKey register = serverSocketChannel.register(selector, SelectionKey.OP_READ);
//
//        System.out.println(register.interestOps());
//
////        serverSocketChannel.close();
////        selector.close();
    }
}
