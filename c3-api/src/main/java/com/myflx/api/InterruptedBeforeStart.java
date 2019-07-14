package com.myflx.api;

import java.util.concurrent.TimeUnit;

public class InterruptedBeforeStart {
    public static void main(String[] args) {
        // 判断当前线程是否被打断
        System.out.println("Main thread is interrupted? "+Thread.interrupted());

        //中断当前线程
        Thread.currentThread().interrupt();

        // 判断当前线程是否被打断(调用才设置中断标志)
        System.out.println("Main thread is interrupted? "+Thread.currentThread().isInterrupted());

        try {
            //调用可中断方法发现线程是已中断的标记会立即抛出中断异常
            TimeUnit.MINUTES.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            //捕获异常
            System.out.println(" I will be interrupted still");
        }
    }
}
