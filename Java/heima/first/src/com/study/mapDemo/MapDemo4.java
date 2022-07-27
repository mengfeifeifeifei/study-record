package com.study.mapDemo;

import java.util.*;

public class MapDemo4 {
    public static void main(String[] args) {
        Map<String, List<String>> data = new HashMap<>();
        List<String> objects = new ArrayList<>();
        Collections.addAll(objects, "A", "B", "C");
        data.put("张1", objects);

        System.out.println(data);

        HashMap<String, Integer> infos = new HashMap<>();

        Collection<List<String>> values = data.values();
        for (List<String> value : values) {
            for (String s : value) {
                if (infos.containsKey(s)) {
                    infos.put(s, infos.get(s) + 1);
                } else {
                    infos.put(s, 1);
                }
            }
        }

        System.out.println(infos);
    }
}
