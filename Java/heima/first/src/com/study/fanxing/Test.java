package com.study.fanxing;

import java.util.ArrayList;
import java.util.Arrays;

public class Test<E> {

    private ArrayList a = new ArrayList();
    public static void main(String[] args) {
    }

    public void run(E e) {

    }

    public void remove(E e) {

    }
}



class ArrayListDemo {
    public static void main(String[] args) {
        Test<String> objectTest = new Test<>();
        objectTest.run("10");

        Integer[] a1 = {3,4,5,56,7};
        String[] a2 = {"string", "vue"};
        Integer[] a3 = new Integer[3];
//        int[] a4 = new int[]{};
//        printArray(a1);
//        printArray(a2);
        printArray(a3);
    }

    public static <T> void printArray(T[] arr) {
        if (arr != null) {
            StringBuilder stringBuilder = new StringBuilder("[");
            for (int i = 0; i < arr.length; i++) {
                stringBuilder.append(arr[i]).append(i == arr.length - 1 ? "]" : ",");
            }
            System.out.println(stringBuilder);
        } else {
            System.out.println(Arrays.toString((Object[]) null));
        }
    }
}
