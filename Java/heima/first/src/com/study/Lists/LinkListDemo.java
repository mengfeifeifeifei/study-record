package com.study.Lists;

import java.util.LinkedList;

public class LinkListDemo {
    public static void main(String[] args) {
        // 栈  链表结构 首尾操作快
        LinkedList<Object> objects = new LinkedList<>();
        // 入栈
        objects.addFirst("1");
        // 可以写成push
//        objects.push("1");
        objects.addFirst("2");
        objects.addFirst("3");
        objects.addFirst("4");
        System.out.println(objects); // [4, 3, 2, 1]
//        Object first = objects.getFirst();
//        System.out.println(first); // 4

        // 出栈
//        Object o = objects.removeFirst();
        Object o = objects.pop();
        System.out.println(objects); // [3, 2, 1]

        // 用队列同样 把addFirst换成addLast， removeFirst
    }
}
