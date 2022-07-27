package com.study.five;

public class ArrayDemo {
    public static void main(String[] args) {
        /**
         * 数据类型 默认值
         */
        int[] arr = new int[]{1,2,3,4};
        System.out.println(arr[0]);
        System.out.println(arr[3]);

        int arr1[] = new int[4];
        System.out.println(arr1[0]);  // 0

        char[] c = new char[4];
        System.out.println((int)c[0]);
        System.out.println((int)c[3]);   // 0

        char a = 'A';
//        String b = "A";
        System.out.println((int)a);

        float[] f = new float[10];
        System.out.println(f[0]);
        System.out.println(f[9]);   // 0.0

        boolean[] bool = new boolean[10];
        System.out.println(bool[0]);   // false
    }
}
