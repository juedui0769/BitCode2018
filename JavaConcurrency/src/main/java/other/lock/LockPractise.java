package other.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2019年7月26日18:07:09
 * https://www.cnblogs.com/hustzzl/p/9343797.html
 * 复习Java中的锁
 */
public class LockPractise {
    private final Logger logger = LoggerFactory.getLogger(LockPractise.class);

    public static void main(String[] args) {
        LockPractise lockPractise = new LockPractise();
        lockPractise.test01();

    }

    public void test01() {
        try {
            setA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized void setA() throws Exception {
//        System.out.println("begin : setA");
        logger.info("begin : setA");
        Thread.sleep(1000);
        setB();
//        System.out.println("end : setA");
        logger.info("end : setA");
    }

    private void setB() throws InterruptedException {
//        System.out.println("===begin : setB===");
        logger.info("===begin : setB===");
        Thread.sleep(1000);
//        System.out.println("===end : setB===");
        logger.info("===end : setB===");
    }
}
