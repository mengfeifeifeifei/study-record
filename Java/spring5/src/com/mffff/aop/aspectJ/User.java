package com.mffff.aop.aspectJ;

import org.springframework.stereotype.Component;

/**
 * aop 被增强的类
 */
//@Component
public class User {
    public void add() {
        System.out.println("add....");
    }
}
