package com.mffff.threadDemo;

import java.time.LocalTime;

/**
 * 守护线程
 * Java程序入口就是由JVM启动main线程，main线程又可以启动其他线程。当所有线程都运行结束时，JVM退出，进程结束。
 * 如果有一个线程没有退出，JVM进程就不会退出。所以，必须保证所有线程都能及时结束
 *
 * 守护线程是指为其他线程服务的线程。在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。
 * 因此，JVM退出时，不必关心守护线程是否已结束。
 * 如何创建守护线程呢？方法和普通线程一样，只是在调用start()方法前，调用setDaemon(true)把该线程标记为守护线程
 * ??: 在守护线程中，编写代码要注意：守护线程不能持有任何需要关闭的资源，例如打开文件等，因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失。
 */
public class CreateThread5 {
    public static void main(String[] args) {
        Thread t = new MyThread3();
        // 设置线程为守护线程 ，负责服务其他线程
        t.setDaemon(true);
        t.start();
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
