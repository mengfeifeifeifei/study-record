package com.mffff.spring;

import com.mffff.autowire.Emp;
import com.mffff.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mffff.annotation.User;

public class TestSpring {

    /**
     * 无参构造器注入
     */
//    @Test
//    public void testUser() {
//        // classpath 类路径 src下
//        // 加载spring配置文件
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
//
//        // 获取配置创建的对象 ”User“为xml中配置的id名
//        User user = (User)context.getBean("user");
//        System.out.println(user);
//        user.add();
//    }
//
//    /**
//     * 有参构造器注入
//     */
//    @Test
//    public void testOrder() {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean1.xml");
//        OrderImpl order = classPathXmlApplicationContext.getBean("order", OrderImpl.class);
//        System.out.println(order);
//    }
//
//    @Test
//    public void testDept() {
//        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean2.xml");
//        Emp emp = classPathXmlApplicationContext.getBean("emp", Emp.class);
//        System.out.println(emp);
//    }

    @Test
    public void testAuto() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = context.getBean("user", User.class);
        user.add();
    }
}
