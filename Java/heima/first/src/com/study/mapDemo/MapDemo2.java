package com.study.mapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo2 {
    public static void main(String[] args) {
        // lambda表格式遍历
        // 遍历
        Map<String, String> map = new HashMap<>();
        map.put("aa", "bb");
        map.put("bb", "cc");
        map.put("cc", "dd");
        map.put("dd", "ee");
        // {aa=bb, bb=cc, cc=dd, dd=ee}
//        System.out.println(map);
//        map.forEach(new BiConsumer<String, String>() {
//            @Override
//            public void accept(String key, String val) {
//                System.out.println(key + "==>" + val);
//            }
//        });

        map.forEach((key, val) -> System.out.println(key + "==>" + val));
    }
}
