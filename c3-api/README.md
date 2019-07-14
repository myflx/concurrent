###### 线程constructors

###### 线程名称

​	默认命名：Thread-自增数字组合。

```java
public Thread(Runnable target) {
    init(null, target, "Thread-" + nextThreadNum(), 0);
}
```
​	名称修改：非NEW状态不可修改

```java
public final synchronized void setName(String name) {
    checkAccess();
    this.name = name.toCharArray();
    if (threadStatus != 0) {
        setNativeName(name);
    }
}
```

##### 父线程

一个线程的创建肯定是另外的线程创建

被创建线程的父线程是创建它的线程。

父线程不可外部设置。

##### 线程组（ThreadGroup）

主线程所在的ThreadGroup 名称为main

未指定线程组线程的ThreadGroup和父线程为同一个



##### 线程与stackSize 

构造线程可以指定栈内存的大小，但是会影响线程的创建数量，通常不自行设置线程栈内存（默认0）。

线程和内存之间关系大概估算： 堆内存 + 线程数量*栈内存

过大的栈内存数量会影响线程的创建数量。

比较精确的计算：

线程数量 = 最大地址空间（MaxProcessMemory）- JVM堆内存 - ReservedOsMemory/ThreadStackSize(XSS)

Linux系统下的配置也可以决定线程数量的大小

/proc/sys/kernel/threads-max

/proc/sys/kernel/pid_max

/proc/sys/kernel/max_map_count



##### 守护线程

守护线程具备自动结束生命周期的特性。

守护线程经常用于执行后台任务。

不设置是否守护线程，父线程为正常线程子线程也是守护线程，父线程为守护子也为守护线程。