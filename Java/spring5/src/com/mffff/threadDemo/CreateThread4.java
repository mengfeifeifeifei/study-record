package com.mffff.threadDemo;

/**
 * 中断线程(设置标志位)
 * 线程间的共享变量
 *
 * 注意到HelloThread的标志位boolean running是一个线程间共享的变量。线程间共享变量需要使用volatile关键字标记，确保每个线程都能读取到更新后的变量值
 * volatile关键字解决了共享变量在线程间的可见性问题
 */
public class CreateThread4 {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        Thread.sleep(1);
        // 标记位置为false
        myThread2.running = false;
    }
}

class MyThread2 extends Thread {
    public volatile boolean running = true;
//    public boolean running = true;
    @Override
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + "hello! ");
        }
        System.out.println("end!!");
    }
}
