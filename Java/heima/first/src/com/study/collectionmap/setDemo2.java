package com.study.collectionmap;

import java.util.Set;
import java.util.TreeSet;

public class setDemo2 {
    public static void main(String[] args) {
        Set<Integer> sets = new TreeSet<>();
        sets.add(10);
        sets.add(20);
        sets.add(545);
        sets.add(53);
        sets.add(5);
        //[5, 10, 20, 53, 545]
        System.out.println(sets);

        Set<String> objects = new TreeSet<>();
        objects.add("ui");
        objects.add("string");
    }
}
