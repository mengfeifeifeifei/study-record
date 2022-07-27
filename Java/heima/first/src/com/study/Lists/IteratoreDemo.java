package com.study.Lists;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratoreDemo {
    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("Java");
        objects.add("Java");
        objects.add("Java");
        objects.add("Vue");
        objects.add("PYTHON");
//        Iterator<String> iterator = objects.iterator();
//        if (iterator.hasNext()) {
//            String next = iterator.next();
//            if (next.equals("Java")) {
//                // 不可以使用objects.remove 因为删除了元素后索引位置错误，迭代器删除的位置不对
//                // 用迭代器的remove方法
//                iterator.remove();
//            }
//        }

        for (int i = 0; i < objects.size(); i++) {
            String n = objects.get(i);
            if(n.equals("Java")) {
                objects.remove("Java");
                i--;
                System.out.println(objects);
            }
            System.out.println(i);
        }
        System.out.println(objects);
    }
}
