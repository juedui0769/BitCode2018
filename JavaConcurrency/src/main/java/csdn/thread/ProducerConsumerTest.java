package csdn.thread;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 2019年7月29日07:19:22
 * https://blog.csdn.net/zheng199172/article/details/88800275
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        final Queue<Integer> sharedQueue = new ArrayBlockingQueue<Integer>(105);
        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();
    }

    static class Producer extends Thread {

        private static final int MAX_QUEUE_SIZE = 5;

        private final Queue sharedQueue;

        public Producer(Queue sharedQueue) {
            super();
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (sharedQueue) {
                    while (sharedQueue.size() >= MAX_QUEUE_SIZE) {
                        System.out.println("队列满了，等待消费");
                        try {
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    sharedQueue.add(i);
                    System.out.println("进行生产 : " + i);
                    sharedQueue.notify();
                }
            }
        }
    }

    static class Consumer extends Thread {
        private final Queue sharedQueue;

        public Consumer(Queue sharedQueue) {
            super();
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (sharedQueue) {
                    while (sharedQueue.size() == 0) {
                        try {
                            System.out.println("队列空了，等待生产");
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int number = (int) sharedQueue.poll();
                    System.out.println("进行消费 : " + number);
                    sharedQueue.notify();
                }
            }
        }
    }

}
