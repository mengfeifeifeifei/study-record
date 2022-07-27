package com.study.first;

public class Binary {
    public static void main(String[] args) {
        // 十进制转二进制计算  除二取余法
        // 计算机中存储单位是字节 (Byte) 简称 B
        // 1字节(B) = 8bit(b)
        // 数据在计算机底层是按照二进制存储

        // 字符存储
        char ch = 'a'; // 按照ascii编码表   字符a 计算机中对应的是97  的二进制
        System.out.println(ch + 1);

        // 图片存储
        // 读像素点的数据  0～255*255*255 二进制

        // 声音存储
        // 声波 二进制数据存储

        int i = 0B01100001; // 二进制
        System.out.println(i);

        int i1 = 0141;  // 八进制
        int i2 = 0X61;  // 十六进制  // 97
    }
}
