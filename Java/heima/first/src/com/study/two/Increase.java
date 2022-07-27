package com.study.two;

public class Increase {
    public static void main(String[] args) {
        int a = 10;
        a++;
        ++a;

        int m = 10;
        int n = m++;  // ++时先把m赋值给n 之后再把m进行++
        System.out.println(m);  // 11
        System.out.println(n);  // 10

        // 赋值运算符  自带强制类型转换
        // a += b 相当于 a = (a的数据类型)(a+b)
        int c = 10;
        int d = 10;
        c+=d;   // c = (int)(c+d)
        System.out.println(c);


        int a1 = 10;
        byte a2  = 10;
        boolean a3 = a1 == a2;
        System.out.println(a3);

    }
}
