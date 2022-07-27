package com.study.five;

import java.util.Arrays;

public class ArrayDemo05 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        // 指向了堆内存中的地址  所以下面修改数组中的值 arr1也会随之改变
        int[] arr1 = arr;

        System.out.println(arr); // [I@1540e19d   (地址)
        System.out.println(Arrays.toString(arr));  // [1, 2, 3, 4]
        System.out.println(arr1);// [I@1540e19d  把地址赋值给arr1了
        System.out.println(Arrays.toString(arr1));  // [1, 2, 3, 4]

        arr[0] = 10;
        System.out.println(arr); // [I@1540e19d
        System.out.println(Arrays.toString(arr));  // [10, 2, 3, 4]
        System.out.println(arr1); // [I@1540e19d
        System.out.println(Arrays.toString(arr1));  // [10, 2, 3, 4]
    }
}
