package com.study.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutPutStreamDemo {
    public static void main(String[] args) throws Exception {
        Student student = new Student("张", "nv", 20);

        ObjectOutputStream objectOutputStream =  new ObjectOutputStream(new FileOutputStream("first/src/4.txt"));

        objectOutputStream.writeObject(student);

        objectOutputStream.close();
    }
}
