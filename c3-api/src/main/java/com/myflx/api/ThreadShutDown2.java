package com.myflx.api;

import java.util.concurrent.TimeUnit;

public class ThreadShutDown2 {

    public static void main(String[] args) throws InterruptedException {
        MyTask thread = new MyTask();
        thread.start();
        TimeUnit.SECONDS.sleep(5L);
//        thread.EXP = true;
        thread.CLOSED = true;
    }
}

class MyTask extends Thread{

    public static volatile Boolean CLOSED = false;
    public static volatile Boolean EXP = false;
    @Override
    public void run() {
        while (!CLOSED && !isInterrupted()){
            System.out.println(Thread.currentThread().getName() +" : i am running");
            if (EXP){
                throw new IllegalStateException("发生RuntimeException时异常也会导致。。。");
            }
        }
        System.out.println(Thread.currentThread().getName() +" : shut down!");
    }
}
