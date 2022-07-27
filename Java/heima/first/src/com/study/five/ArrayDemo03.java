package com.study.five;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayDemo03 {
    public static void main(String[] args) {
        int[] ints = new int[5];
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(20 + 1);
        }
        Scanner scanner = new Scanner(System.in);
        OUT:
        while (true) {
            System.out.println("请输入一个1-20的数字:");
            int i = scanner.nextInt();
            for (int i1 = 0; i1 < ints.length; i1++) {
                if (ints[i1] == i) {
                    System.out.println("下标:" + i1);
                    break OUT;
                }
            }
            System.out.println("当10前猜测的数字不存在 重新猜测");
        }
        System.out.println(Arrays.toString(ints));
    }
}
