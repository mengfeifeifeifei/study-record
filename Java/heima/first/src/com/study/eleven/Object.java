package com.study.eleven;

public class Object {
    public static void main(String[] args) {
        Student student = new Student();
        student.age = 19;
        student.name = "zhang";

        System.out.println(student.age);

        Student student1 = new Student();
        System.out.println(student);
        student1.age = 20;
        System.out.println(student1.age);
        System.out.println(student.age);
    }
}
