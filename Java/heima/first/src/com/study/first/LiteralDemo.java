package com.study.first;

public class LiteralDemo {
    public static void main(String[] args) {
        // 字符可以用单引号  字符长度只能有一个
        System.out.println('a');
        System.out.println(' ');
//        System.out.println('');  error

        // 特殊字符
        // \n 换行  \t 代表tab
        System.out.println("-----");
        System.out.println('\n');
        System.out.println("-----");

        // 字符串 必须用双引号
        System.out.println("abc111");
        System.out.println("");

        // 布尔值  true false
        System.out.println(false);
        System.out.println(true);
    }
}
