package com.mffff.aop.aspectJ;

import org.springframework.stereotype.Component;

/**
 * ��ǿ��
 */
@Component
//@Aspect
public class UserProxy {
    // ǰ��֪ͨ
    public void before() {
        System.out.println("before....");
    }
}
