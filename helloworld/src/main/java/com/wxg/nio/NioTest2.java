package com.wxg.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * From : <a href="https://www.bilibili.com/video/av33707223/?p=33">
 *     https://www.bilibili.com/video/av33707223/?p=33
 *     </a>
 * <p>
 * java.io中的核心概念是流（stream），java.io是面向流的编程
 * <p>
 * java.nio中的核心概念有 Selector, Channel, Buffer。
 * java.nio是面向块（block）或缓冲区（buffer）编程的。
 * <p>
 * Buffer 本身是一块内存，底层实际上是一个数组。java.nio中数据的读、写都是通过Buffer来实现的。
 * 所有数据的读写都是通过Buffer来实现的，永远不会出现直接向Channel写入数据或读取数据的情况。
 * <p>
 * 可以向Channel写入数据或者从中读取数据，它类似java.io中的Stream。
 * 与Stream不同的是，Channel是双向的，Channel打开后可以进行读取、写入或是读写。
 * 由于Channel是双向的，因此它能更好地反映出底层操作系统的真实情况；在Linux系统中，底层操作系统的通道就是双向的。
 * <p>
 *
 */
public class NioTest2 {
    public static void main(String[] args) throws Exception{
        String filepath = NioTest2.class.getClassLoader().getResource("NioTest2.txt").getPath();
        FileInputStream fileInputStream = new FileInputStream(filepath);
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            System.out.println("Character: " + (char)b);
        }

        fileInputStream.close();
    }
}
