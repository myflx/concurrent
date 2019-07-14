package com.myflx.concurrent.api;

public class ThreadGroupTest {
    public static void main(String[] args) {
        Thread current = Thread.currentThread();
        System.out.println("current thread is:"+current.getThreadGroup().getName());
        Thread t1 = new Thread("t1");
        System.out.println("t1线程和创建线程组相同："+t1.getThreadGroup().equals(current.getThreadGroup()));
        ThreadGroup t2ThreadGroup = new ThreadGroup("t2-group");
        Thread t2 = new Thread(t2ThreadGroup,"t2");
    }
}
