package book01.ch09;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.*;

/**
 * 2019年2月26日18:34:58
 * 程序清单9-1 使用 Executor 来实现 SwingUtilies
 */
public class SwingUtilities {

    private static final ExecutorService exec =
            Executors.newSingleThreadExecutor(new SwingThreadFactory());

    private static volatile Thread swingThread;

    private static class SwingThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            swingThread = new Thread();
            return swingThread;
        }
    }

    public static boolean isEventDispatchThread() {
        return Thread.currentThread() == swingThread;
    }

    public static void invokeLater(Runnable task) {
        exec.execute(task);
    }

    public static void invokeAndWait(Runnable task)
            throws InterruptedException, InvocationTargetException {
        Future<?> f = exec.submit(task);

        try {
            f.get();
        } catch (ExecutionException e) {
            throw new InvocationTargetException(e);
        }
    }
}
