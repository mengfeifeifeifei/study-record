package com.study.stringDemo;

import java.util.Arrays;

public class NewString {
    public static void main(String[] args) {
        String a = new String("heima");
        String b = a;
        a = "test";
        System.out.println(a.equals(b));
        System.out.println(b);

        int[] arr = new int[]{1,2,3};
        int[] arr1 = arr;

        arr[0] = 3;

        System.out.println(Arrays.toString(arr1));
    }
}
