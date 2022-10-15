package com.mffff.threadDemo;

import org.junit.Test;

/**
 * Java线程对象Thread的状态包括：New、Runnable、Blocked、Waiting、Timed Waiting和Terminated；
 * New：新创建的线程，尚未执行；
 * Runnable：运行中的线程，正在执行run()方法的Java代码；
 * Blocked：运行中的线程，因为某些操作被阻塞而挂起；
 * Waiting：运行中的线程，因为某些操作在等待中；
 * Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
 * Terminated：线程已终止，因为run()方法执行完毕
 *
 * 通过对另一个线程对象调用join()方法可以等待其执行结束；
 * 可以指定等待时间，超过等待时间线程仍然没有结束就不再等待；
 * 对已经运行结束的线程调用join()方法会立刻返回
 */
public class CreateThread1 {
    // 创建一个线程 什么都不做 就结束
    @Test
    public void first() {
        Thread thread = new Thread();
        thread.start();
    }

    @Test
    public void second() {
        SecondThread secondThread = new SecondThread();
        secondThread.start();
        System.out.println("主线程");
    }

    @Test
    public void thrid() throws InterruptedException {
        new Thread(new ThridThread()).start();
        Thread.sleep(8000);
        System.out.println("主线程打印!!");
    }
}

class SecondThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程创建了!!!");
    }
}

class ThridThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程创建了!!!");
    }
}
