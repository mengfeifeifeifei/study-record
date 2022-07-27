package com.study.ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("199999", "zhang", 20, "first"));
        studentList.add(new Student("22222", "zhang", 20, "first"));
        System.out.println("遍号\t\t名称\t\t年龄\t\t班级");
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            System.out.print(student.getNumber());
            System.out.print(student.getName());
            System.out.print(student.getAge());
            System.out.println(student.getClassName());
        }
        Scanner scanner = new Scanner(System.in);
        String studentNumber = scanner.next();
        Student list = getStudentById(studentList, studentNumber);
        if (list == null) {
            System.out.println("null");
        } else {
            System.out.println(list.getNumber() + list.getName() + list.getAge());
        }
    }

    public static Student getStudentById(ArrayList<Student> studentList, String number) {
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getNumber().equals(number)) {
                return student;
            }
        }
        return null;
    }
}
