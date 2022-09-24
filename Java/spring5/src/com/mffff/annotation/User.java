package com.mffff.annotation;

import org.springframework.stereotype.Component;

// 相当于在xml文件中配置了当前类的<bean>
@Component(value = "user")
public class User {
    public void add() {
        System.out.println("user add");
    }
}
