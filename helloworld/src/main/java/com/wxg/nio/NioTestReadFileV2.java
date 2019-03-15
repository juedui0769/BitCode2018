package com.wxg.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 2019年3月15日17:55:06
 * <p>
 * 本代码是 {@link NioTestReadFile} 的变种，用来测试 {@link Buffer#clear()}
 * <p>
 * 当把代码中的 `buffer.clear()` 注释掉后，`int read` 永远不会等于 `-1` ，就不会触发`break`
 */
public class NioTestReadFileV2 {
    private static final int TRY_NUM = 5;

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
            ByteBuffer buffer = ByteBuffer.allocate(512);

            int numI = 1;

            while (true) {
                if (numI == TRY_NUM) {
                    break;
                }

//                buffer.clear();

                int read = inputStreamChannel.read(buffer);

                System.out.println("read : " + read);

                if (read == -1) {
                    break;
                }

                buffer.flip();

                outputStreamChannel.write(buffer);
                numI++;
            }

        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
