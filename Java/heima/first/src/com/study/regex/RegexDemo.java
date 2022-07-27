package com.study.regex;

import java.util.Scanner;

public class RegexDemo {
    // 正则校验手机号码 邮箱
    public static void main(String[] args) {
        checkPhone();
    }

    public static void checkPhone() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入手机号");
            String phone = scanner.next();
            if (phone.matches("1[3-9]\\d{9}")) {
                System.out.println("手机号格式正确");
                break;
            }
            System.out.println("手机号错误");
        }
    }

    public static void checkEmail() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入邮箱号");
            String phone = scanner.next();
            if (phone.matches("\\w{1,30}@\\w{2,10}\\.")) {
                System.out.println("邮箱格式正确");
                break;
            }
            System.out.println("邮箱错误");
        }
    }
}
