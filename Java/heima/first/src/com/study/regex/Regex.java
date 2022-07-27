package com.study.regex;

import com.sun.deploy.util.StringUtils;

import java.util.concurrent.TransferQueue;

public class Regex {
    public static void main(String[] args) {
        // 正则表达式 6-20位数的手机号
        boolean flag = checkQqRegex("231321222q");
        System.out.println(flag);
    }

    public static boolean checkQqRegex(String qq) {
        return qq != null && qq.matches("\\d{6,20}");
    }

    public static boolean checkQq(String qq) {
        // 判断号码长度
        if (qq == null || qq.length() < 6 || qq.length() > 20) return false;
        // 判断qq中是否全是数字
        for (int i = 0; i < qq.length(); i++) {
            char c = qq.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
