package com.mffff.annotation;

import org.springframework.stereotype.Component;

// �൱����xml�ļ��������˵�ǰ���<bean>
@Component(value = "user")
public class User {
    public void add() {
        System.out.println("user add");
    }
}
