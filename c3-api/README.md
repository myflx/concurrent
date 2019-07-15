##### 线程API

###### 线程sleep

- ​	sleep是静态方法，当前线程进入指定的毫秒级休眠。

- ​	休眠有一个重要特性就是不会放弃monitor锁的所有权。线程调用了sleep进入BLOCKED状态

- ​	JDK1.5之后引入 TimeUnit枚举类优雅的处理休眠。


```java
public static native void sleep(long millis) throws InterruptedException;
public static void sleep(long millis, int nanos)throws InterruptedException；

//引入用于优雅的休眠，可读性也比较高
TimeUnit.HOURS.sleep(1L);
TimeUnit.MINUTES.sleep(20L);
TimeUnit.SECONDS.sleep(30L);
TimeUnit.MILLISECONDS.sleep(100L);
```

###### 线程yield

- yield to :向某某让步。。

- 线程调用该方法即向cpu发送指令，表示当前我占有的CPU资源可以让步。并不代表CPU会立即将资源分配给其他线程，资源充足时就会被忽略。

- sleep会导致当前线程暂定指定的时间，没有CPU时间片的消耗

- yield只是给CPU一个提示，如果没有被忽略会导致线程上下文的切换。

- sleep会导致线程的短暂的阻塞，会在给定的时间被释放CPU资源。

- yield 线程会从RUNNING状态进入RUNNABLE状态（如果指定没被忽略）

- sleep一定会生效，yield不一定会生效。

- 一个线程的yield不会捕获到interrupt信号，sleep可以捕获中断信号。


###### 线程优先级

- 优先级范围为：1-10 超范围会出错。

- 线程的由优先级不会超过组的优先级。未设置的同父线程5

- 优先级只是一种优先分配的权重，并不是调度的权重，一般线程不设置也不依赖优先级。


###### 线程上下文类加载器

- 获取线程上下文类加载器（未修同父）：``java.lang.Thread#getContextClassLoader``

- 设置（java类加载器的后门，打破父委托机制）``java.lang.Thread#setContextClassLoader``


###### 线程interrupt

​	调用线程的interrupt方法，线程就会被打断抛出打断异常，有些方法会捕获到异常（打断信号），有的则不会。

- `java.lang.Thread#interrupt` ：打断线程

- `java.lang.Thread#interrupted` ：调用返回是否被打断同时清除被打断标记

- `java.lang.Thread#isInterrupted()` ：判断线程是否被打断，如果打断信号被捕获会清除打断标记如调用sleep方法。




###### 线程join

- 阻塞当前线程，等待join 的线程生命周期结束开始执行。
- 可捕获到被打断信号。

###### 关闭线程

- 通过打断标志关闭线程
- 通过volatile开关控制