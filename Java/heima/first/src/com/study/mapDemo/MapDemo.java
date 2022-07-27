package com.study.mapDemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<Object, Object> objectObjectMap = new HashMap<>();
        objectObjectMap.put("a", "1");
        objectObjectMap.put("b", "2");
        objectObjectMap.put("c", "2");
        objectObjectMap.put(null, null);

        // {null=null, a=1, b=2}
        System.out.println(objectObjectMap);

//        objectObjectMap.clear(); // 清空

        System.out.println(objectObjectMap.isEmpty());

        System.out.println(objectObjectMap.get("a")); // 取不到就为null

        System.out.println(objectObjectMap.remove("a"));  // 返回删除的键的值

        System.out.println(objectObjectMap.containsKey("a"));

        Set<Object> objects = objectObjectMap.keySet();
        System.out.println(objects);

        Collection<Object> values = objectObjectMap.values();
        System.out.println(values);

        System.out.println(objectObjectMap.size());

        Map<String, String> map1 = new HashMap<>();
        map1.put("name", "zhang");
        map1.put("size", "18");
        Map<String, String> map2 = new HashMap<>();
        map1.put("name1", "menf");
        map1.put("size1", "20");
        map1.putAll(map2);
        System.out.println(map1);
    }
}
