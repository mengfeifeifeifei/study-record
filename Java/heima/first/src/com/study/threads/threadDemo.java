package com.study.threads;
// 无法继承其他类
public class threadDemo extends Thread {
    /**
     * 初始线程
     * @param args
     */
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程" + i);
        }
    }

}

class MyThread extends Thread {
    /**
     * 重写run
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
//            System.out.println("子线程" + i);
        }
    }
}
