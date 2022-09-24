package com.mffff.spring;

import java.util.List;

public class User {
    private String name;

    private List<String> tag;
    public void add() {
        System.out.println("add....");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", tag=" + tag +
                '}';
    }
}
