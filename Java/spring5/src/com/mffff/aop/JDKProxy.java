package com.mffff.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    /**
     * JDK方式实现代理AOP
     *
     * @param args
     */
    public static void main(String[] args) {
        Class[] intefaces = {UserDao.class};
        // 创建接口代理实现对象
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), intefaces, new UserDaoProxy(new UserDaoImpl()));
        System.out.println("11111");
        int add = dao.add(1, 2);
        System.out.println(add);
    }
}

class UserDaoProxy implements InvocationHandler {

    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * 增强的逻辑
     * 创建的是谁的代理对象，就把谁传过来
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前执行" + method.getName());
        System.out.println("参数" + Arrays.toString(args));

        Object invoke = method.invoke(obj, args);

        System.out.println("方法之后执行" + obj);

        System.out.println("invoke:" + invoke);
        return invoke;
    }
}
