package com.study.ArrayLists;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Movie test = new Movie("<a>", 10, "test");

        ArrayList<Movie> objects = new ArrayList<>();
        objects.add(test);

        System.out.println(objects);

        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i).getName());
            System.out.println(objects.get(i).getActor());
            System.out.println(objects.get(i).getScore());
        }
    }
}
