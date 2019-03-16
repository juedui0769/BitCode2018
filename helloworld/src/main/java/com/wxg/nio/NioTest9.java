package com.wxg.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 2019年3月15日23:30:16
 * <p>
 * 注意： "target/classes/NioTest9.txt"是发生了变化的!
 */
public class NioTest9 {
    public static void main(String[] args) throws Exception{
        String path = NioTest9.class.getClassLoader().getResource("NioTest9.txt").getPath();
        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte)'a');
        mappedByteBuffer.put(3, (byte)'b');

        randomAccessFile.close();

    }
}
