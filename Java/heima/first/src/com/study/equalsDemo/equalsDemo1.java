package com.study.equalsDemo;

public class equalsDemo1 {
    public static void main(String[] args) {
        String a = new String("aaa");
        System.out.println(a.hashCode());
        String b = new String("aaa");
        System.out.println(b.hashCode());
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}
