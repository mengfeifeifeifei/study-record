package com.study.ArrayLists;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Movie1> objects = new ArrayList<Movie1>();
        objects.add(new Movie1("第一步电影", 9.9, "张"));
        objects.add(new Movie1("第二步电影", 9.8, "梦"));
        objects.add(new Movie1("第三步电影", 9.7, "飞"));
        for (Movie1 object : objects) {
            String movieName = object.getName();
            double movieScore = object.getScore();
            String movieActor = object.getActor();
            System.out.println("片名" + movieName);
            System.out.println("分数" + movieScore);
            System.out.println("作者" + movieActor);
        }

    }
}

class Movie1 {
    private String name;
    private double score;
    private String actor;

    public Movie1() {

    }

    public Movie1(String name, double score, String actor) {
        this.name = name;
        this.score = score;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
