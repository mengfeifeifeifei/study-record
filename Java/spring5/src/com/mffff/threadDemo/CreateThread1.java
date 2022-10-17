package com.mffff.threadDemo;

import org.junit.Test;

/**
 * Java�̶߳���Thread��״̬������New��Runnable��Blocked��Waiting��Timed Waiting��Terminated��
 * New���´������̣߳���δִ�У�
 * Runnable�������е��̣߳�����ִ��run()������Java���룻
 * Blocked�������е��̣߳���ΪĳЩ����������������
 * Waiting�������е��̣߳���ΪĳЩ�����ڵȴ��У�
 * Timed Waiting�������е��̣߳���Ϊִ��sleep()�������ڼ�ʱ�ȴ���
 * Terminated���߳�����ֹ����Ϊrun()����ִ�����
 *
 * ͨ������һ���̶߳������join()�������Եȴ���ִ�н�����
 * ����ָ���ȴ�ʱ�䣬�����ȴ�ʱ���߳���Ȼû�н����Ͳ��ٵȴ���
 * ���Ѿ����н������̵߳���join()���������̷���
 */
public class CreateThread1 {
    // ����һ���߳� ʲô������ �ͽ���
    @Test
    public void first() {
        Thread thread = new Thread();
        thread.start();
    }

    @Test
    public void second() {
        SecondThread secondThread = new SecondThread();
        secondThread.start();
        System.out.println("���߳�");
    }

    @Test
    public void thrid() throws InterruptedException {
        new Thread(new ThridThread()).start();
        Thread.sleep(8000);
        System.out.println("���̴߳�ӡ!!");
    }
}

class SecondThread extends Thread {
    @Override
    public void run() {
        System.out.println("�̴߳�����!!!");
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
        System.out.println("�̴߳�����!!!");
    }
}
