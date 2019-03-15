package com.wxg.nio;

import io.netty.buffer.ByteBuf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 2019年3月15日17:29:32
 * <p>
 * `output.txt` 会生成在 `target/classes/` 目录下面
 */
public class NioTestReadFile {

    public static void main(String[] args) throws Exception{
        String rootpath = NioTestReadFile.class.getClassLoader().getResource("").getPath();
        File inputFile = new File(rootpath, "input.txt");
        File outputFile = new File(rootpath, "output.txt");

        FileInputStream fileInputStream = new FileInputStream(inputFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

        try {
            FileChannel inputStreamChannel = fileInputStream.getChannel();
            FileChannel outputStreamChannel = fileOutputStream.getChannel();

            // 512, 1024
            ByteBuffer buffer = ByteBuffer.allocate(32);

            while (true) {
                buffer.clear();

                int read = inputStreamChannel.read(buffer);

                System.out.println("read : " + read);

                if (read == -1) {
                    break;
                }

                buffer.flip();

                outputStreamChannel.write(buffer);
            }

        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
