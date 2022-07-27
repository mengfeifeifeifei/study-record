package com.study.exception;

/**
 * 自定义异常使用
 */
public class ExceptionCustom {
    public static void main(String[] args) {
        try {
            checkAge(-34);
        } catch (ExceptionIlleagel e) {
            e.printStackTrace();
        }

        System.out.println("继续执行");
    }

    public static void checkAge(int age) throws ExceptionIlleagel {
        if (age < 0 || age > 200) {
            throw new ExceptionIlleagel("年龄传递错误");
        } else {
            System.out.println("年龄合法");
        }
    }
}
