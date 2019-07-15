package com.myflx.api;

import java.util.concurrent.TimeUnit;

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
