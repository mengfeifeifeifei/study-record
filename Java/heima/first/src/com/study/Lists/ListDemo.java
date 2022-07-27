package com.study.Lists;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("Java");
        objects.add("Mysql");

        objects.add(1, "Vue");
        System.out.println(objects);

        System.out.println(objects.set(1, "React")); // Vue
        System.out.println(objects);

        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
        }

    }
}
