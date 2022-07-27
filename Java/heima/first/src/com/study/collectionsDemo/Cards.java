package com.study.collectionsDemo;

public class Cards {
    private String size;
    private String color;
    private int index;

    public Cards(String size, String color, int index) {
        this.size = size;
        this.color = color;
        this.index = index;
    }

    public Cards() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
//        return "Cards{" +
//                "size='" + size + '\'' +
//                ", color='" + color + '\'' +
//                '}';
        return size + color;
    }
}
