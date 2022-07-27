package com.study.mapDemo;

import java.util.HashMap;
import java.util.Random;

public class MapDemo3 {
    public static void main(String[] args) {
        // 小案例  统计投票人数
        String[] select = {"a", "b", "c", "d"};
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 80; i++) {
            stringBuilder.append(select[random.nextInt(select.length)]);
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < stringBuilder.length(); i++) {
            char c = stringBuilder.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        System.out.println(hashMap);
    }
}
