package com.mffff.annotation;

import com.mffff.spring.Order;
import com.mffff.spring.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 相当于在xml文件中配置了当前类的<bean>
@Component
public class User {
    // 这里在order实现类上面加上Component注解自动装配成功的原因是： 可以把下面的代码看作
    // private Order order = new Order的实现类();
    // 所以这里相当于去着了order的实现类，就装配成功了
    @Autowired
    private Order order;
    public void add() {
        System.out.println("user add");
        System.out.println(order);
    }
}
