package com.wxg.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadShutdownHook {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println(">>> shutdown ");
            }
        };
        Runtime.getRuntime().addShutdownHook(t);

        System.out.println("test ...");
        System.out.println("...");

        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("> singleThread test....");
            }
        });
        singleThread.shutdown();
    }
}
