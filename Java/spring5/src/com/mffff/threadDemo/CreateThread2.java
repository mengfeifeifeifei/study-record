package com.mffff.threadDemo;

import javax.sound.midi.Track;

/**
 * 中断线程
 * 假如下载文件过程中，新建了一个线程用来下载文件，文件很大，用户点击取消后，需要去中断下载线程
 * 执行：需要在其他线程中对目标线程调用interrupt（）方法，目标线程需要反复检测自身状态是否是interrupt状态，如果是，就立即结束运行
 */
public class CreateThread2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(15000);
        // 中断线程
        myThread.interrupt();
        // 等待myThread线程结束
        myThread.join();
        System.out.println("主线程!");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            n++;
            System.out.println(n + "hello ");
        }
    }
}
