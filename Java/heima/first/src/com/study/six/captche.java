package com.study.six;

import java.util.Random;

public class captche {

    public static void main(String[] args) {
        String code = code(5);
        System.out.println(code);
    }

    public static String code(int n) {
        //
        Random random = new Random();
        String code = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(3);
            switch (num) {
                case 0:
                    char ch = (char) (random.nextInt(26) + 65);
                    stringBuilder.append(ch);
//                    code += ch;
                    break;
                case 1:
                    char ch1 = (char) (random.nextInt(26) + 97);
                    stringBuilder.append(ch1);
//                    code += ch1;
                    break;
                case 2:
                    int c = random.nextInt(10);
                    stringBuilder.append(c);
//                    code += c;
                    break;
            }
        }
        return stringBuilder.toString();
    }
}
