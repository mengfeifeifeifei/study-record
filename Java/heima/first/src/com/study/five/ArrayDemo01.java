package com.study.five;

public class ArrayDemo01 {
    public static void main(String[] args) {
        // 静态数组
        int[] ints = new int[]{10,82,34,599};
        int length = ints.length;

        int n = 0;
        for (int i = 0; i < length; i++) {
            n += ints[i];
        }

        System.out.println("数组和:" + n);
    }
}
