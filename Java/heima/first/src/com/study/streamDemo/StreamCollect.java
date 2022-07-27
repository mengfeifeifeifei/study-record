package com.study.streamDemo;

import com.study.seven.Arr;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {
    public static void main(String[] args) {
        // 收集stream流
        List<String> lists = new ArrayList<>();
        Collections.addAll(lists, "php", "java", "python");
        System.out.println(lists);
        Stream<String> list = lists.stream().filter(s -> s.startsWith("java"));
//        List<String> javaList = list.collect(Collectors.toList());
//        Set<String> javaSet = list.collect(Collectors.toSet());
//        System.out.println(javaList);
//        System.out.println(javaSet);

        // 转字符串数组
//        String[] arr = list.toArray(s -> new String[s]);
        String[] arr = list.toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }
}
