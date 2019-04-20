package com.wxg.interview;

/**
 * create at 2019年4月20日23:33:06，
 * <p>平安金融中心，笔试题</p>
 */
public class NumericalResults20190420 {
    public static void main(String[] args) {
        int num = 17;
        while (num > 0) {
            System.out.print(num++%5 + "\t");
            num /= 5;
        }
    }
}
