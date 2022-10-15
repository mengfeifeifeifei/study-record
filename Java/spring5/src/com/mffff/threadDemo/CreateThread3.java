package com.mffff.threadDemo;

/**
 * �ж��߳�
 *
 */
public class CreateThread3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread1();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // �ж�t�߳�
        t.join(); // �ȴ�t�߳̽���
        System.out.println("end");
    }
}

class MyThread1 extends Thread {
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // ����hello�߳�
        try {
            hello.join(); // �ȴ�hello�߳̽���
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("hello interrupted ");
                break;
            }
        }
    }
}
