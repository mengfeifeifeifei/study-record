package com.study.seven;

import java.util.Arrays;
import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        //数字加密  每位数字加5 取余 反转
        System.out.println(111);
        number();
    }

    public static void number() {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[4];
        for (int i = 0; i < ints.length; i++) {
            System.out.println("请输入第" + (i+1) + "位要加密的数字");
            ints[i] = scanner.nextInt();
        }

        for (int i = 0; i < ints.length; i++) {
            ints[i] = (ints[i] + 5) % 10;
        }

        for (int i = 0,j = ints.length - 1; i < j; i++,j--) {
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
        }
        System.out.println(Arrays.toString(ints));
    }
}
