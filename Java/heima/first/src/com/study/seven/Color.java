package com.study.seven;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Color {
    public static void main(String[] args) {
        int[] rand = randNumber();
        System.out.println(Arrays.toString(rand));
        int[] input = inputNumber();
        System.out.println(Arrays.toString(input));
        boolean status = checkNumber(input, rand);
        System.out.println( status ? "您中奖了" : "很遗憾，下次努力");
    }

    public static int[] inputNumber() {
        int[] ints = new int[7];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < ints.length - 1; i++) {
            System.out.println("请输入第" + (i + 1) + "位双色球号码");
            ints[i] = scanner.nextInt();
        }

        System.out.println("请输入第" + (ints.length) + "位双色球号码");
        ints[ints.length - 1] = scanner.nextInt();
        return ints;
    }

    public static int[] randNumber() {
        int[] ints = new int[7];
        Random random = new Random();
        for (int i = 0; i < ints.length - 1; i++) {
            while (true) {
                boolean flag = true;
                int data = random.nextInt(33) + 1;
                for (int j = 0; j < i; j++) {
                    if (ints[j] == data) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    ints[i] = data;
                    break;
                }
            }
        }
        ints[ints.length - 1] = random.nextInt(10) + 1;
        return ints;
    }

    public static boolean checkNumber(int[] inputNumber, int[] randNumber) {
        boolean flag = true;
        for (int i = 0; i < randNumber.length; i++) {
            if (inputNumber[i] != randNumber[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
