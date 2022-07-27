package com.study.string;

public class StringDemo {

    public static void main(String[] args) {
        String name = "zzz";   //  当常量池中存在相同的值的时候，不会新创建 而是指向常量池中这个值的位置
        String zzz = new String("zzz");  // 相当于在堆内存中创建了两个对象   "zzz" 创建在堆内存字符串常量池中， new String 创建堆内存对象，之后把"zzz"填充到刚刚创建的堆内存中

        System.out.println(name.equals(zzz));  // True
        System.out.println(name == zzz);       // False
    }
}
