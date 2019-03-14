package book01.ch09;

import java.util.concurrent.*;

/**
 * 2019年2月26日19:20:28
 * 程序清单9-7 支持取消，完成通知以及进度通知的后台任务类
 *
 * @param <V>
 */
abstract class BackgroundTask<V> implements Runnable, Future<V> {

    private final FutureTask<V> computation = new Computation();

    private class Computation extends FutureTask<V> {
        public Computation() {
            super(new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return BackgroundTask.this.compute();
                }
            });
        }
        protected final void done() {
            GuiExecutor.instance().execute(new Runnable() {
                @Override
                public void run() {
                    V value = null;
                    Throwable thrown = null;
                    boolean cancelled = false;
                    try {
                        value = get();
                    } catch (ExecutionException e) {
                        thrown = e.getCause();
                    } catch (CancellationException e) {
                        cancelled = true;
                    } catch (InterruptedException consumed) {
                    } finally {
                        onCompletion(value, thrown, cancelled);
                    }
                }
            });
        }
    }

    protected void setProgress(final int current, final int max) {
        GuiExecutor.instance().execute(new Runnable() {
            @Override
            public void run() {
                onProgress(current, max);
            }
        });
    }

    protected abstract V compute() throws Exception;

    protected void onCompletion(V result, Throwable exception,
                                boolean cancelled) {}

    protected void onProgress(int current, int max) {}
}
