##### 线程生命周期

###### 线程生命周期主要分为5个阶段：

- NEW 

- RUNNABLE

- RUNNING

- BLOCKED

- TERMINATED

###### 线程的NEW 状态

    调用关键字new 创建一个线程对象的时候阶段可以理解为NEW 的状态。此时仅仅是一个普通对象，只有调用start()方法时候才会进入RUNNABLE 状态。

###### 线程的RUNNALBLE状态

    线程对象调用start()的时候才能进入RUNABLE状态。此时才真正的在JVM进程中创建了一个线程。此时的线程只是一个就绪状态，具备了执行资格，并没有真正的运行。此时线程在等待CPU的调度。



###### 线程的RUNNING状态

    一旦CPU通过 轮询或者其他方式从任务列表转给你选中了线程，那么此时它才进入运行的状态执行业务逻辑。RUNNING状态也是RUNNABLE的状态。反之不成立。
    
    该状态下的状态切换。
    
    进入TERMINATED状态。调用stop方法或者某个逻辑标识（JDK已经不推荐使用）
    
    进入BLOCKED状态。调用了sleep，或者wait方法然后进入waitSet中。
    
    获取某个锁资源，从而加入该锁的阻塞队列中而进入BLOCKED状态。
    
    CPU轮询放弃执行该线程，进入RUNNABLE状态。
    
    线程主动调用yield方法，放弃CPU执行权，进入RUNNABLE状态。

###### 线程的BLOCKED状态

    线程进入阻塞状态的状态切换。
    
    进入TERMINATED状态。调用stop方法（JDK已经不推荐使用）或者意外死亡（JVM Crash）
    
    线程得到了资源（获得锁）进入RUNNABLE状态。
    
    完成休眠进入RUNNABLE状态。
    
    wait中的线程被其他线程notify/notifyAll唤醒，进入RUNNABLE状态。
    
    线程在阻塞过程中被打断，比如其他线程调用了interrupt方法，进入RUNNABLE状态。

###### 线程的TERMINATED状态

    TERMINATED状态是线程的一个最终的一个死亡状态。不会切换到其他状态。
    
    进入死亡状态。
    
    线程运行正常结束，结束生命周期。
    
    线程运行出错意外结束。
    
    JVM Crash ，导致所有的线程都结束。



##### 线程中的设计模式

​	在创建线程时使用**模板和策略模式**使核心代码与业务代码分离。Runnable为业务代码接口。Thread实现Runnable接口作为模板，提供run()的空实现。不同的业务类实现Runnable可看成不同的策略，传入Thread供线程执行。

```java
@FunctionalInterface
public interface Runnable {
    public abstract void run();
}
```

```java
public class Thread implements Runnable {
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
}

```

