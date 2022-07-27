package com.study.collectionmap;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class setDemo {
    public static void main(String[] args) {
        // 无序  不重复  无索引，  只是第一次无序，后边都是有顺序的， 底层用hash表存储的数据结构
        // hash表是数组+链表+红黑树 存储的
        Set<String> sets = new HashSet<>();
//        System.out.println(sets.hashCode());
        // 有序  不重复  无索引(对外没有提供索引的api，但底层还是数组类型，其实还是有索引)，因为无序，所以索引没意义
//        Set<String> sets = new LinkedHashSet<>();
//        sets.add("Mysql");
//        sets.add("Mysql");
//        sets.add("Mysql");
//        sets.add("Vue");
//        sets.add("React");
//        sets.add("Ant Design");
//        System.out.println(sets);
    }
}
