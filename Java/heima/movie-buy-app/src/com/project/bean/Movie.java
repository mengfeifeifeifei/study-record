package com.project.bean;

import java.util.Date;

public class Movie {
    private String name;
    private String actor;
    private double score;
    private double time;
    private double price;
    private int number;
    private Date startTime;

    public Movie(String name, String actor, double score, double time, double price, int number, Date startTime) {
        this.name = name;
        this.actor = actor;
        this.score = score;
        this.time = time;
        this.price = price;
        this.number = number;
        this.startTime = startTime;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public String getActor() {
        return actor;
    }

    public double getScore() {
        return score;
    }

    public double getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
