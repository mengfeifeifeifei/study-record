package com.study.string;

import java.util.Scanner;

public class StringScanner {
    private final static String name = "zhang";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String name = "zhang";   // 位置在堆内存中字符串常量池
        String next = scanner.next();  // 位置在堆内存中
        System.out.println(name == next);   // false
        StringScanner stringScanner = new StringScanner();
        System.out.println(stringScanner.equals(next));  // true
    }


    @Override
    public boolean equals(Object anObject) {
        if (name == anObject) {
            return true;
        }
        return false;
    }
}
