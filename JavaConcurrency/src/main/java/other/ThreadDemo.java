package other;

/**
 * 2019年7月31日00:15:17
 * 这是获取堆栈信息的方法吗？
 */
public class ThreadDemo {
    public static void main(String[] args) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    }
}
