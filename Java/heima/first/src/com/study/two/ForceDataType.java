package com.study.two;

public class ForceDataType {
    public static void main(String[] args) {
        // 转换过程：
        // int占4个字节 一共32bit  强转成byte时， 因为byte占1字节，所以取最后8位
        // 最后8位中 第一位为0是正数 第一位为1是负数，负数的话就反码 补码 计算出来的值就是最后的结果
        int a = 200;
        // byte b = a;  报错
        byte b = (byte) a;
        System.out.println(b);  // -56

        // 浮点数转整形 丢掉小数部分
        double score = 99.5;
        int it = (int) score;
        System.out.println(it);  // 99
    }
}
