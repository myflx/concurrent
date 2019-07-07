package com.myflx.concurrent.thread;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for(;;){
                System.out.println("running....");
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}
