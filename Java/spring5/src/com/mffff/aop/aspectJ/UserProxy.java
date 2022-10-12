package com.mffff.aop.aspectJ;

import org.springframework.stereotype.Component;

/**
 * 增强类
 */
@Component
//@Aspect
public class UserProxy {
    // 前置通知
    public void before() {
        System.out.println("before....");
    }
}
