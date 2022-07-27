package com.study.Object;

public class Student {
    private int age;

    public void setAge(int age) {
        if (age >= 0 && age < 200) {
            this.age = age;
        } else {
            System.out.println("年龄不对的呀!");
        }
    }

    public int getAge() {
        return this.age;
    }
}
