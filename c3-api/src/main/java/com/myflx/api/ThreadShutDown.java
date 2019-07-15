package com.myflx.api;

import java.util.concurrent.TimeUnit;

/**
 * 线程正常生命周期结束就会退出
 * 发生RuntimeException也会导致退出
 */
public class ThreadShutDown {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (!isInterrupted()){
                    System.out.println(Thread.currentThread().getName() +" : i am running");
                }
                System.out.println(Thread.currentThread().getName() +" : shut down!");
            }
        };
        thread.start();
        TimeUnit.SECONDS.sleep(10L);
        thread.interrupt();
    }
}
