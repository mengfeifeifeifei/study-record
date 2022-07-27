package com.study.exception;

public class ExceptionDemo {
    // 运行时异常
    public static void main(String[] args) throws Exception {
        // 数组长度异常
//        int[] arr = {10, 20, 30, 40};
//        System.out.println(arr[4]);
//
//        // 空指针异常
//        String name = null;
//        System.out.println(name.length());
//
//        // 类型转换异常
//        Object a = 23;
//        String s = (String) a;
//        System.out.println(s);
//
        // 数字操作异常
        int c = 10 / 0;
        System.out.println(c);

        // 数字转换异常
//        String number = "23aa";
//        Integer i = Integer.valueOf(number);
//        System.out.println(i);
    }
}
