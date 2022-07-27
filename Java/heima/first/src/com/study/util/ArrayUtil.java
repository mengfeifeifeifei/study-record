package com.study.util;

import java.util.Arrays;

public class ArrayUtil {
    /**
     * 完成数组工具类
     */
    private ArrayUtil() {}

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        System.out.println(Arrays.toString(a));
//        int[] b = {3,4,5};
        String s = toString(new int[]{1, 2, 3});
        System.out.println(s);
    }

    public static String toString(int[] arr) {
        if (arr == null) {
            return null;
        }
        // 拼接并返回
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += (i == arr.length-1 ? arr[i] : arr[i] + ", ");
        }
        result += "]";
        return result;
    }
}
