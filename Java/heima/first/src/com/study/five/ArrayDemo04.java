package com.study.five;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayDemo04 {
    public static void main(String[] args) {
        int[] codes = new int[5];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < codes.length; i++) {
            // 正式录入工号
            System.out.println("请输入第" + (i+1)+ "员工工号");
            int code = scanner.nextInt();
            codes[i] = code;
        }
        System.out.println(Arrays.toString(codes));

        // 打乱数组里面元素
        for (int i = 0; i < codes.length; i++) {
            Random random = new Random();
            int index = random.nextInt(codes.length);
            int n = codes[i];
            codes[i] = codes[index];
            codes[index] = n;
        }

        System.out.println(Arrays.toString(codes));
    }
}
