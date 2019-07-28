package mashibing.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Main1 {
    static int m = 0;
    static Lock lock = new MyLock();
    static CountDownLatch latch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    lock.lock();
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
                } finally {
                    lock.unlock();
                }

                latch.countDown();
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        latch.await();

        System.out.println(m);
    }
}
