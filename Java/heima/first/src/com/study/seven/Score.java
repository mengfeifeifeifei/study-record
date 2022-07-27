package com.study.seven;

import java.util.Scanner;

public class Score {

    public static void main(String[] args) {
        // 六位评委打分， 去掉最高分 最低分 求其余的平均值为最终分数
        System.out.println(avg());
    }

    public static double avg() {
        int[] ints = new int[6];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("请输入第" + (i+1) + "位评委的分数");
            int score = scanner.nextInt();
            ints[i] = score;
        }

        int max = ints[0], min = ints[0];
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
            if (ints[i] < min) {
                min = ints[i];
            }
            sum += ints[i];
        }

        double s = (sum - max - min) * 1.0 / (ints.length - 2);
        return s;
    }
}
