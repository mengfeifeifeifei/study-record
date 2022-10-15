package com.mffff.threadDemo;

/**
 * 线程同步
 * 当多个线程同时运行时，线程的调度由操作系统决定，程序本身无法决定。因此，任何一个线程都有可能在任何指令处被操作系统暂停，然后在某个时间段后继续执行。
 * 这个时候，有个单线程模型下不存在的问题就来了：如果多个线程同时读写共享变量，会出现数据不一致的问题
 * 多线程模型下，要保证逻辑正确，对共享变量进行读写时，必须保证一组指令以原子方式执行：即某一个线程执行时，其他线程必须等待
 * 通过加锁和解锁的操作，就能保证指令总是在一个线程执行期间，不会有其他线程会进入此指令区间。即使在执行期线程被操作系统中断执行，其他线程也会因为无法获得锁导致无法进入此指令区间。只有执行线程将锁释放后，其他线程才有机会获得锁并执行。这种加锁和解锁之间的代码块我们称之为临界区（Critical Section），任何时候临界区最多只有一个线程能执行
 * 保证一段代码的原子性就是通过加锁和解锁实现的。Java程序使用synchronized关键字对一个对象进行加锁
 * synchronized(lock) {
 * n = n + 1;
 * }
 */
public class CreateThread6 {
    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        DecThread decThread = new DecThread();
        decThread.start();
        addThread.start();
        addThread.join();
        decThread.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    // 锁对象，用来加锁
    public static final Object lock = new Object();
    //
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            // 加锁
            synchronized (Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count -= 1;
            }
        }
    }
}
