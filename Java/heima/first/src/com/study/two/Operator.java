package com.study.two;

public class Operator {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        System.out.println(a / b);  // 3  因为根据最高类型返回结果，因为最高类型是int 所以返回3
        System.out.println(3 / (2 * 1.0));  // 1.5
        System.out.println(3 * 1.0 / 2);  // 1.5

        int num = 345;
        System.out.println(num / 100); // 百位数 3
        System.out.println(num % 10);  // 个人 5
        System.out.println(num / 10 % 10); // 十位 4
    }
}
