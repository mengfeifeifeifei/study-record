package com.study.fanxing;

public interface Date<E> {
    void add(E s);
}



class Student implements Date<Student> {
    @Override
    public void add(Student s) {

    }
}

class Teacher {

}
