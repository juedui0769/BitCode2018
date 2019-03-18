package com.wxg.executor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/**
 * 2019年3月18日16:25:29
 * <p></p>
 * {@link java.util.concurrent.Executor}
 */
public class ExecutorTest {

    /**
     * {@link java.util.concurrent.Executor} 注释中描绘的一个例子
     * <p></p>
     * 这个样例有点像Netty采用的策略：boosGroup, workerGroup
     */
    class SerialExecutor implements Executor {
        final Queue<Runnable> tasks = new ArrayDeque<>();
        final Executor executor;
        Runnable active;

        SerialExecutor(Executor executor) {
            this.executor = executor;
        }

        @Override
        public synchronized void execute(final Runnable r) {
            tasks.offer(new Runnable() {
                @Override
                public void run() {
                    try {
                        r.run();
                    } finally {
                        scheduleNext();
                    }
                }
            });
            if (active == null) {
                scheduleNext();
            }
        }

        protected synchronized void scheduleNext() {
            if ((active = tasks.poll()) != null) {
                executor.execute(active);
            }
        }
    }

}
