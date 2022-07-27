package com.study.array;

import com.study.seven.Arr;

import java.util.*;

public class ArrayApi {
    public static void main(String[] args) {
        int[] i = {20, 4, 56, 33, 7, 29};
        // 升序排序
        Arrays.sort(i);
//        System.out.println(Arrays.toString(i));
        // 找不到的时候 为这个数字应该在数据中插入的位置 （ -应该插入的位置-1）
//        int i1 = Arrays.binarySearch(i, 57);
//        System.out.println(i1);

        // 自定义比较器，只能用引用类型
        Integer[] i1 = {20, 4, 56, 33, 7, 29};
        // 降序
//        Arrays.sort(i1, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
        Arrays.sort(i1, (Integer o1, Integer o2) -> o2-o1);
        // 降序
        Arrays.sort(i1, (o1, o2) -> o2-o1);

        System.out.println(Arrays.toString(i1));

        List<Integer> objects = new ArrayList<>();
        objects.add(10);
        objects.add(20);
        objects.add(30);
//        Collections.sort(objects, ((o1, o2) -> o2-o1));
        objects.sort((o1, o2) -> o2-o1);
        System.out.println(objects);

    }
}
