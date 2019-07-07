package com.myflx.concurrent.thread;

import java.util.concurrent.TimeUnit;

public class StartDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("running....");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        /*
        thread.start();
        TimeUnit.SECONDS.sleep(4);
        thread.start();
        //会抛出IllegalThreadStateException异常（threadStatus = 5 线程已经终结）
        */

        /*
        thread.start();
        //会抛出IllegalThreadStateException异常（threadStatus = 1 线程已经启动无法再次启动）
        thread.start();*/
    };
}
