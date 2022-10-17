package com.mffff.threadDemo;

import javax.sound.midi.Track;

/**
 * �ж��߳�
 * ���������ļ������У��½���һ���߳����������ļ����ļ��ܴ��û����ȡ������Ҫȥ�ж������߳�
 * ִ�У���Ҫ�������߳��ж�Ŀ���̵߳���interrupt����������Ŀ���߳���Ҫ�����������״̬�Ƿ���interrupt״̬������ǣ���������������
 */
public class CreateThread2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(15000);
        // �ж��߳�
        myThread.interrupt();
        // �ȴ�myThread�߳̽���
        myThread.join();
        System.out.println("���߳�!");
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
