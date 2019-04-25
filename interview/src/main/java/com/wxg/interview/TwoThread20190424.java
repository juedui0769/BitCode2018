package com.wxg.interview;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * create at 2019年4月26日07:06:51，
 * <p>
 * 两个线程按顺序输出1到100，一个输出奇数，一个输出偶数
 * </p>
 */
public class TwoThread20190424 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
        for (int i = 1; i <= 100; i++) {
            queue.put(i);
        }

//        while (!queue.isEmpty()) {
//            System.out.println(queue.take());
//        }

        Thread A = new Thread() {
            @Override
            public void run() {
                try {
                    while (!queue.isEmpty()) {
                        if (queue.peek() != null && queue.peek() % 2 == 1) {
                            System.out.println(queue.take());
                            Thread.yield();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread B = new Thread() {
            @Override
            public void run() {
                try {
                    while (!queue.isEmpty()) {
                        if (queue.peek() != null && queue.peek() % 2 == 0) {
                            System.out.println(queue.take());
                            Thread.yield();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        A.start();
        B.start();
    }


    @Test
    public void test01() {
        for (int i = 1; i < 10; i ++) {
            System.out.println(i % 2);
        }
    }
}
