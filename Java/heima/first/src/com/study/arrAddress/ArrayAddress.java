package com.study.arrAddress;

public class ArrayAddress {
    public static void main(String[] args) {
        int[][] a1 = {
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {10, 11, 12, 13}
        };

        int[] a2 = a1[0];

        System.out.println(a1[0]);
        System.out.println(a2);
    }
}
