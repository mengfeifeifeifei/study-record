package com.study.streamDemo;

import com.study.seven.Arr;

import java.util.*;
import java.util.stream.Stream;

public class streamDemo {
    /**
     * stream流 入门
     * 找到以张开头的姓名
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("张");
        names.add("飞");
        names.add("梦");
        names.add("张张张");
        System.out.println(names);
//
//        ArrayList<String> zhangList = new ArrayList<>();
//        for (String name : names) {
//            if (name.startsWith("张")) {
//                zhangList.add(name);
//            }
//        }
//        System.out.println(zhangList);

        // stream方法
        names.stream().filter(s -> s.startsWith("张") && s.length() == 3).forEach(System.out::println);
    }

    public static void streamTest() {
        Collection<String> lists = new ArrayList<>();
        // 集合拿数据流
        Stream<String> stream = lists.stream();

        // ---------------------------
        HashMap<String, Integer> maps = new HashMap<>();
        // 键的流
        Stream<String> keyStream = maps.keySet().stream();
        Stream<Integer> valStream = maps.values().stream();
        // 键值 流
        Stream<Map.Entry<String, Integer>> keyAndValStream = maps.entrySet().stream();
        keyAndValStream.forEach(s -> s.getKey());
        
        // 数组流
        String[] names = {"a", "b"};
        Stream<String> stream1 = Arrays.stream(names);
        // Stream.of(names)
    }
}

class StreamApi{
    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();
        objects.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
        long len = objects.stream().filter(s -> s.startsWith("张")).count();

//        objects.stream().filter(s -> s.startsWith("张")).limit(2).forEach(s -> System.out.println(s));
        // 简化版
        objects.stream().filter(s -> s.startsWith("张")).limit(2).forEach(System.out::println);
        // 跳过两条
        objects.stream().filter(s -> s.startsWith("张")).skip(2).forEach(System.out::println);

        // 加工函数map
        objects.stream().map(s -> "黑马的: " + s);
        // 加工成一个学生对象
//        objects.stream().map(s -> new Student(s)).forEach(System.out::println);
        // 简化
        objects.stream().map(Student::new).forEach(System.out::println);

        // 合并流
        Stream<String> name = objects.stream().filter(s -> s.startsWith("张"));
        Stream<String> name1 = Stream.of("php", "java", "python");
        Stream<Object> s3 = Stream.concat(name, name);
    }
}
