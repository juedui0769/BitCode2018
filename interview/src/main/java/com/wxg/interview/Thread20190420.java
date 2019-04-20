package com.wxg.interview;

/**
 * create at 2019年4月20日22:57:11
 * <p>
 * 平安金融中心，笔试
 * </p>
 * <p>
 * 这道题是我根据回忆编写的(不知有没有复制正确)。
 * </p>
 * <p>
 * 这种题目是'陷阱'题考查对 {@code Thread} 的理解。
 * </p>
 */
public class Thread20190420 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");
    }

    private static void pong() {
        System.out.print("pong");
    }
}
