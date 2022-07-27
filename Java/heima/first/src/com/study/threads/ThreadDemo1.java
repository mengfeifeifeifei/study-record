package com.study.threads;

public class ThreadDemo1 {
    /**
     * 多线程创建方式2
     */
    public static void main(String[] args) {
        // 任务对象
        Runnable myRunnable = new MyRunnable();
        // 把任务对象交给thread处理
        Thread t = new Thread(myRunnable);
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程" + i);
        }
    }
}


/**
 * 定义一个线程类
 * 只实现了接口 可以继续继承其他类
 */

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            System.out.println("子线程" + i);
        }
    }
}