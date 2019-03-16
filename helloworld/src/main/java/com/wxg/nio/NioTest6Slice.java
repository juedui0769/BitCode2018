package com.wxg.nio;

import java.nio.ByteBuffer;

/**
 * 2019年3月15日22:18:46
 * <p>
 * Slice Buffer 相当于是原Buffer的快照，相互影响。
 * <p>
 * Slice Buffer与原有Buffer共享相同的底层数组。
 */
public class NioTest6Slice {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte)i);
        }

        buffer.position(2);
        buffer.limit(6);

        ByteBuffer slice = buffer.slice();

        for (int i = 0; i < slice.capacity(); ++i) {
            byte b = slice.get(i);
            b *= 2;
            slice.put(i, b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
