package com.study.five;

public class ArrayDemo02 {
    public static void main(String[] args) {
        /**
         *  求数组元素最大值
         */
        int[] ints = new int[]{15, 9000, 55,3,243,566};
        // 建议使用第一个元素作为参照
        int max = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
        }
        System.out.println(max);
    }
}
