package com.wxg.nio;

import java.nio.ByteBuffer;

/**
 * 2019年3月15日22:09:10
 * https://www.bilibili.com/video/av33707223?t=82&p=37
 */
public class NioTest5BasicType {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(15);
        buffer.putLong(500000000L);
        buffer.putDouble(14.123456);
        buffer.putChar('你');
        buffer.putShort((short)2);
        buffer.putChar('好');

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getChar());
    }
}
