package com.wxg.study.nio;

import com.wxg.study.util.JavaNIOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileExample {
    public static void main(String[] args) throws IOException {
        String path = JavaNIOUtils.getResourcePath("nio-data.txt");
        RandomAccessFile aFile = new RandomAccessFile(path, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.println((char)buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }

        aFile.close();
    }
}
