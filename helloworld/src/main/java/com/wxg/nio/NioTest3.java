package com.wxg.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 2019年3月14日
 * From : <a href="https://www.bilibili.com/video/av33707223/?p=33">
 *  *     https://www.bilibili.com/video/av33707223/?p=33
 *  *     </a>
 *  * <p>
 */
public class NioTest3 {
    public static void main(String[] args) throws Exception{
        String rootpath = NioTest3.class.getClassLoader().getResource("").getPath();
        System.out.println(rootpath);
        FileOutputStream fileOutputStream = new FileOutputStream(rootpath + "NioTest3.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        byte[] message = "hello world welcome, nihao".getBytes();

        for (int i = 0; i < message.length; i++) {
            byteBuffer.put(message[i]);
        }

        byteBuffer.flip();

        channel.write(byteBuffer);

        fileOutputStream.close();
    }
}
