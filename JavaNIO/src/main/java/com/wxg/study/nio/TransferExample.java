package com.wxg.study.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferExample {

    private static final String fromFilepath = "D:\\temp\\fromFile.txt";
    private static final String toFilepath = "D:\\temp\\toFile.txt";

    public static void main(String[] args) throws IOException {
//        transferFrom();
        transferTo();
    }

    private static void transferTo() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile(fromFilepath, "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile(toFilepath, "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        fromChannel.transferTo(position, count, toChannel);
    }

    private static void transferFrom() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile(fromFilepath, "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile(toFilepath, "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        toChannel.transferFrom(fromChannel, position, count);
    }
}
