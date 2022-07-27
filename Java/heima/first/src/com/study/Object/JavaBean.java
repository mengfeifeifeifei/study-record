package com.study.Object;

public class JavaBean {
    private String name;
    private int age;
    private double salary;

    public JavaBean(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public JavaBean() {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
