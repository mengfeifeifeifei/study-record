package com.mffff.threadDemo;

/**
 * �߳�ͬ��
 * ������߳�ͬʱ����ʱ���̵߳ĵ����ɲ���ϵͳ�������������޷���������ˣ��κ�һ���̶߳��п������κ�ָ�������ϵͳ��ͣ��Ȼ����ĳ��ʱ��κ����ִ�С�
 * ���ʱ���и����߳�ģ���²����ڵ���������ˣ��������߳�ͬʱ��д�����������������ݲ�һ�µ�����
 * ���߳�ģ���£�Ҫ��֤�߼���ȷ���Թ���������ж�дʱ�����뱣֤һ��ָ����ԭ�ӷ�ʽִ�У���ĳһ���߳�ִ��ʱ�������̱߳���ȴ�
 * ͨ�������ͽ����Ĳ��������ܱ�ָ֤��������һ���߳�ִ���ڼ䣬�����������̻߳�����ָ�����䡣��ʹ��ִ�����̱߳�����ϵͳ�ж�ִ�У������߳�Ҳ����Ϊ�޷�����������޷������ָ�����䡣ֻ��ִ���߳̽����ͷź������̲߳��л���������ִ�С����ּ����ͽ���֮��Ĵ�������ǳ�֮Ϊ�ٽ�����Critical Section�����κ�ʱ���ٽ������ֻ��һ���߳���ִ��
 * ��֤һ�δ����ԭ���Ծ���ͨ�������ͽ���ʵ�ֵġ�Java����ʹ��synchronized�ؼ��ֶ�һ��������м���
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
    // ��������������
    public static final Object lock = new Object();
    //
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            // ����
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
