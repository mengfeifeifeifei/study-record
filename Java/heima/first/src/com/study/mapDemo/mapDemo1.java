package com.study.mapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mapDemo1 {
    public static void main(String[] args) {
        // 遍历
        Map<Object, Object> map = new HashMap<>();
        map.put("aa", "bb");
        map.put("bb", "cc");
        map.put("cc", "dd");

        // 遍历方式1
//        Set<Object> mapSet = map.keySet();
//        for (Object o : mapSet) {
//            Object val = map.get(o);
//            System.out.println(o + "===>" + val);
//        }


        // 遍历方式2
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        // [aa=bb, bb=cc, cc=dd]
        System.out.println(entries);

        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + "===>" + entry.getValue());
        }
        


    }
}
