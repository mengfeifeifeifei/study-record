package com.study.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class ObjectInPutStreamDemo {
    public static void main(String[] args) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("first/src/4.txt"));

        // 反序列化
        Student a = (Student) objectInputStream.readObject();

        System.out.println(a);

        objectInputStream.close();
    }
}
