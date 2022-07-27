package com.study.ArrayLists;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        ArrayList<Account> objects = new ArrayList<>();
        while (true) {
            System.out.println("====================欢迎进入梦飞飞飞飞ATM系统====================");
            System.out.println("1. 登录账户" );
            System.out.println("2. 注册账户" );
            Scanner scanner = new Scanner(System.in);
            System.out.println("请选择要执行的操作:" );
            int operate = scanner.nextInt();
            switch (operate) {
                case 1:
                    loginAccount(objects, scanner);
                    break;
                case 2:
                    registerAccount(objects, scanner);
                    break;
            }
        }
    }

    public static boolean loginAccount(ArrayList<Account> objects, Scanner scanner) {
        boolean flag = false;
        String password = "";
        while (true) {
            System.out.println("请输入要登录的账号:");
            String account = scanner.next();
            for (int i = 0; i < objects.size(); i++) {
                Account accountInfo = objects.get(i);
                if (accountInfo.getAccount().equals(account)) {
                    password = accountInfo.getPassword();
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            System.out.println("输入的账号不存在 请重新输入");
        }

        System.out.println("请输入密码：");
        while (true) {
            String inputPassword = scanner.next();
            if (password.equals(inputPassword)) {
                System.out.println("登录成功");
                break;
            }
            System.out.println("密码输入错误，请重新输入: ");
        }
        return true;
    }

    public static void registerAccount(ArrayList<Account> objects, Scanner scanner) {
        System.out.println("请输入要注册的账号:");
        boolean flag = true;
        String account;
        while (true) {
            account = scanner.next();
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getAccount().equals(account)) {
                    flag = false;
                    System.out.println("该账号已存在， 请重新输入");
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        String inputPassword;
        double limitMoney;
        while (true) {
            System.out.println("请输入注册的密码:");
            inputPassword = scanner.next();
            System.out.println("请重新输入注册的密码:");
            String inputPasswordRepeat = scanner.next();
            if (inputPassword.equals(inputPasswordRepeat)) {
                break;
            }
            System.out.println("两次密码不一致，请重新输入");
        }
        System.out.println("请重新单笔限制金额:");
        limitMoney = scanner.nextDouble();

        String cardId = getRandomCardId(objects);

        System.out.println("您的卡号是: " + cardId);
        objects.add(new Account(account, inputPassword, 0, limitMoney, cardId));
        System.out.println("注册成功");
    }


    private static String getRandomCardId(ArrayList<Account> objects) {
        String cardId = "";
        Random random = new Random();
        while (true) {
            for (int i = 0; i < 10; i++) {
                cardId += random.nextInt(10);
            }
            Account accountByCardId = getAccountByCardId(cardId, objects);
            if (accountByCardId == null) {
                return cardId;
            }
        }
    }

    private static Account getAccountByCardId(String cardId, ArrayList<Account> objects) {
        for (int i = 0; i < objects.size(); i++) {
            Account account = objects.get(i);
            if (account.getCardId().equals(cardId)) {
                return account;
            }
        }
        return null;
    }
}
