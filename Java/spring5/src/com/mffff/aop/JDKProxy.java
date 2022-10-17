package com.mffff.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    /**
     * JDK��ʽʵ�ִ���AOP
     *
     * @param args
     */
    public static void main(String[] args) {
        Class[] intefaces = {UserDao.class};
        // �����ӿڴ���ʵ�ֶ���
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
     * ��ǿ���߼�
     * ��������˭�Ĵ�����󣬾Ͱ�˭������
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("����֮ǰִ��" + method.getName());
        System.out.println("����" + Arrays.toString(args));

        Object invoke = method.invoke(obj, args);

        System.out.println("����֮��ִ��" + obj);

        System.out.println("invoke:" + invoke);
        return invoke;
    }
}
