package com.study.two;

public class ExpressDataType {
    // 表达式中最终结果数据类型是由最高类型决定的
    // byte short char是自动转成int类型进行计算的
    public static void main(String[] args) {
        byte a = 10;
        int b = 20;
        double c = 1.0;
        double d = a + b + c;  // 用double类型接
        System.out.println(d);

        byte aa = 10;
        byte bb = 20;
        int k = aa + bb; // 用byte  chort 接都会报错


    }

}
