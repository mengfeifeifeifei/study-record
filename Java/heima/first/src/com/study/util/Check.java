package com.study.util;

import java.util.Random;

public class Check {
    public static void main(String[] args) {
        // 开发验证码
        String code = "";
        String data = "12345";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(data.length());
            System.out.println(index);
            code += data.charAt(index);
        }
        System.out.println(code);
    }
}
