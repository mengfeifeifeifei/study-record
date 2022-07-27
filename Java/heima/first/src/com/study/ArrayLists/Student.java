package com.study.ArrayLists;

public class Student {
    private String number;
    private String name;
    private int age;
    private String className;

    public Student(String number, String name, int age, String className) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public Student() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
