package com.mffff.spring;

public class User {
    private String name;
    public void add() {
        System.out.println("add....");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
