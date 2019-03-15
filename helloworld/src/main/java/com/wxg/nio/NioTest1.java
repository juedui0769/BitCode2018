package com.wxg.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * From : <a href="https://www.bilibili.com/video/av33707223/?p=33">
 *  *     https://www.bilibili.com/video/av33707223/?p=33
 *  *     </a>
 *  * <p>
 */
public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); ++i) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
