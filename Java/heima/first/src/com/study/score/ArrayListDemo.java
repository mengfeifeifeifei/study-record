package com.study.score;

import java.util.ArrayList;

public class ArrayListDemo {
    /**
     * arraylist中删除小于80的数据
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(55);
        objects.add(80);
        objects.add(70);
        objects.add(60);
        objects.add(85);
        objects.add(40);

//        for (int i = 0; i < objects.size(); i++) {
//            int score = objects.get(i);
//            if (score < 80) {
//                objects.remove(i);
//                i--;
//            }
//        }

        // 从最后开始判断
        for (int i = objects.size()-1; i >= 0; i--) {
            int score = objects.get(i);
            System.out.println(objects);
            System.out.println(i);
            if (score < 80) {
                objects.remove(i);
            }
        }

        System.out.println(objects);
    }
}
