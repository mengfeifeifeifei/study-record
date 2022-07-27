package com.study.exception;

public class ExceptionDemo1 {
    public static void main(String[] args) {

        // 数字操作异常
        try {
            int c = 10 / 0;
            System.out.println(c);
        } catch (Exception e) {
            System.out.println("小心点吧！");
            e.printStackTrace();
        }
    }
}
