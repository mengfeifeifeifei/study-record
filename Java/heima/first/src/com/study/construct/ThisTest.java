package com.study.construct;

public class ThisTest {
    String name;
    public ThisTest() {
        System.out.println("无残构造器中的this： " + this);
    }

    public void run() {
        System.out.println("方法中的this： " + this);
    }

    public void run1(String name) {
        this.name = name;
        System.out.println(name);
        System.out.println(this.name);
    }
}
