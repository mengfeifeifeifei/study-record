package com.mffff.threadDemo;

/**
 * �ж��߳�(���ñ�־λ)
 * �̼߳�Ĺ������
 *
 * ע�⵽HelloThread�ı�־λboolean running��һ���̼߳乲��ı������̼߳乲�������Ҫʹ��volatile�ؼ��ֱ�ǣ�ȷ��ÿ���̶߳��ܶ�ȡ�����º�ı���ֵ
 * volatile�ؼ��ֽ���˹���������̼߳�Ŀɼ�������
 */
public class CreateThread4 {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        Thread.sleep(1);
        // ���λ��Ϊfalse
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
