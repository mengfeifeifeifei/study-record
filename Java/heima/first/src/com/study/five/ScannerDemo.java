package com.study.five;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("shuru:");
//        if (scanner.hasNextInt()) {
//            int n = scanner.nextInt();
//            System.out.println(n);
//        }

        while (true) {
            if (scanner.hasNextInt()) {
//                int n = scanner.nextInt();
                System.out.println(1);
            }
        }
    }
}
