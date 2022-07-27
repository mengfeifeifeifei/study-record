package com.study.two;

public class DataTypeTo {
    // 数据类型转换
    // P23
    public static void main(String[] args) {
        // 小的数据类型可以赋值给大的数据类型
        byte a = 20;
        int b = a;


        // char类型的变量可以赋值给int类型
        // 因为char类型的底层还是二进制 ， 二进制对应的也是一个数字  ，所以可以直接转为int
        // char类型占两个字节 所以可以赋值给int（4个字节）
        int age = 23;
        double age1 = age;   // 23.0

        System.out.println(age1);

        char ch = 'a';  // 在ascii编码中 97 对应 a  所以底层存储的是97的二进制码
        int ch1 = ch;   // 这里就想当于把97的二进制转成int类型  所以为97
//        short ch2 = ch;  error   同样占两个字节的不能转换  short和char都是两字节
        System.out.println(ch1);  // 97
    }
}
