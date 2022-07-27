package com.study.three;

public class IfElse {
    public static void main(String[] args) {
        int heartBeat = 30;
        if (heartBeat < 60 || heartBeat > 100)
            System.out.println("检查");

        System.out.println("结束");

        int money = 100;
        if (money > 100) {}

        int week = 5;
        switch (week) {
            case 5:
                System.out.println("马上周末了休息！");
                break;
            case 4:
                System.out.println("努力");
                break;
            default:
                System.out.println("aaa");
        }
    }
}
