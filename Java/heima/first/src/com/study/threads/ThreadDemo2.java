package com.study.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo2 {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> stringFutureTask = new FutureTask<>(new MyThread1());
        Thread thread = new Thread(stringFutureTask, "线程1");
        thread.start();
        int a = 0;
        for (int i = 0; i < 1000; i++) {
            a += i;
        }

//        System.out.println("sum" + stringFutureTask.get());
        System.out.println(Thread.currentThread().getName() + ":" + a);
    }
}


class MyThread1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + ":" +sum);
        return sum;
    }
}
