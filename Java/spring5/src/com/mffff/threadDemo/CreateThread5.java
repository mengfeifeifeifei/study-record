package com.mffff.threadDemo;

import java.time.LocalTime;

/**
 * �ػ��߳�
 * Java������ھ�����JVM����main�̣߳�main�߳��ֿ������������̡߳��������̶߳����н���ʱ��JVM�˳������̽�����
 * �����һ���߳�û���˳���JVM���̾Ͳ����˳������ԣ����뱣֤�����̶߳��ܼ�ʱ����
 *
 * �ػ��߳���ָΪ�����̷߳�����̡߳���JVM�У����з��ػ��̶߳�ִ����Ϻ�������û���ػ��̣߳�����������Զ��˳���
 * ��ˣ�JVM�˳�ʱ�����ع����ػ��߳��Ƿ��ѽ�����
 * ��δ����ػ��߳��أ���������ͨ�߳�һ����ֻ���ڵ���start()����ǰ������setDaemon(true)�Ѹ��̱߳��Ϊ�ػ��߳�
 * ??: ���ػ��߳��У���д����Ҫע�⣺�ػ��̲߳��ܳ����κ���Ҫ�رյ���Դ��������ļ��ȣ���Ϊ������˳�ʱ���ػ��߳�û���κλ������ر��ļ�����ᵼ�����ݶ�ʧ��
 */
public class CreateThread5 {
    public static void main(String[] args) {
        Thread t = new MyThread3();
        // �����߳�Ϊ�ػ��߳� ��������������߳�
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
