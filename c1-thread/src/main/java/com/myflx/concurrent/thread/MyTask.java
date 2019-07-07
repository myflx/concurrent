package com.myflx.concurrent.thread;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {
    public void run() {
        doRun();
    }

    public static void doRun() {
        System.out.println("task is running....");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Thread(new MyTask()).start();
        new Thread(MyTask::doRun).start();
    }
}
