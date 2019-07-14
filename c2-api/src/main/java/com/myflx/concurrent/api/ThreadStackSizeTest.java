package com.myflx.concurrent.api;

/**
 * 使用命令 ：
 * java -Xmx512m -Xms62m ThreadStackSizeTest 1
 * java -Xmx512m -Xms62m ThreadStackSizeTest 10
 * java -Xmx512m -Xms62m ThreadStackSizeTest 100
 * java -Xmx512m -Xms62m ThreadStackSizeTest 1000
 * java -Xmx512m -Xms62m ThreadStackSizeTest 10000
 * 查看递归的深度 （编译前去掉包名）
 */
public class ThreadStackSizeTest {
    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.out.println("please enter the stack size");
            System.exit(1);
        }
        ThreadGroup threadGroup = new ThreadGroup("testGroup");
        Runnable runnable = new Runnable() {
            final Integer MAX = Integer.MAX_VALUE;

            @Override
            public void run() {
                recurse(0);
            }

            public void recurse(int i) {
                System.out.println(i);
                if (i < MAX) {
                    recurse(i + 1);
                }
            }
        };
        new Thread(threadGroup, runnable, "test", Integer.parseInt(args[0])).start();
    }
}
