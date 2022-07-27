package com.study.collectionmap;

//import com.sun.org.apache.xpath.internal.operations.String;
import java.lang.String;

public class SetDemo1 {
    public static void main(String[] args) {
        // 获取对象的hashcode值
        test();
        String string = new String();
        System.out.println(string.hashCode());
    }

    public static void test() {
        String a = new String("a");
        System.out.println(a.hashCode());
        String a1 = new String("a");
        System.out.println(a1.hashCode());

        System.out.println(a.equals(a1));
        System.out.println(a==a1);

    }
}
