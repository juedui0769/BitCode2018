package com.wxg.nio;

import java.nio.ByteBuffer;

/**
 * 2019年3月15日22:22:39
 * <p>
 * <ul>
 *     <li>class java.nio.HeapByteBuffer</li>
 *     <li>class java.nio.HeapByteBufferR</li>
 * </ul>
 */
public class NioTest7ReadonlyBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());

        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte)i);
        }

        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readOnlyBuffer.getClass());

    }
}
