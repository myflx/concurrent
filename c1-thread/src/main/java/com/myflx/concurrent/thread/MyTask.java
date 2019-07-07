package com.myflx.concurrent.thread;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {
    public void run() {
        try {
            for(;;){
                System.out.println("task is running....");
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new MyTask()).start();
    }
}
