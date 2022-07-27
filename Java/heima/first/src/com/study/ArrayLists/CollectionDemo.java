package com.study.ArrayLists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        System.out.println(objects);

        Collection<String> list = new HashSet<>();
        list.add("zhang");
        list.add("meng");
        list.add("fei");
        System.out.println(list.add("fei"));
//        list.clear();
//        System.out.println(list);
        System.out.println(list.isEmpty());

        System.out.println(list.size());  // 3

        System.out.println(list.contains("zhang"));  // true

        System.out.println(list.remove("zhang")); // true  当有多个相同时 默认删除第一个元素
        System.out.println(list);

        Object[] objects1 = list.toArray();
        System.out.println(objects1);

        ArrayList<String> objects2 = new ArrayList<>();
        objects2.add("1");
        objects2.add("2");
        ArrayList<String> objects3 = new ArrayList<>();
        objects3.add("3");
        objects3.add("4");
        objects2.addAll(objects3);
        System.out.println(objects2);
        // 迭代器
//        Iterator<String> iterator = objects2.iterator();
        // true false
//        while(iterator.hasNext()) {
//            String next = iterator.next();
//            System.out.println(next);
//        }

        // 相当于foreach
        for (String index: objects2) {
            System.out.println(index);
        }

//        objects2.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//
//            }
//        });

        objects2.forEach(s -> {
            System.out.println(s);
        });

        objects2.forEach(System.out::println);
    }
}
