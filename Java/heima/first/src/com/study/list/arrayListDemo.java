package com.study.list;

import java.util.ArrayList;

public class arrayListDemo {
    public static void main(String[] args) {
        // <>代表泛型类，在编译阶段约束集合对象只能操作某种数据类型
        // object 代表一切类型
        ArrayList<Object> objects = new ArrayList<>();
//        ArrayList<String> objectss = new ArrayList<String>();
        ArrayList<String> objectss = new ArrayList<>(); // jdk 1.7 后面的<>声明可以不写
        objects.add("Java");
        objects.add("Java1");
        objects.add("Java2");
        objects.add(1, 1);
        System.out.println(objects);
    }
}
