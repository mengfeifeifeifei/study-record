package com.study.five;

import java.util.Arrays;

public class MaoPao {

    public static void main(String[] args) {
        int[] arr = {1,4,65,3,5,2,5,78,34,6,786,323,776,453};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
