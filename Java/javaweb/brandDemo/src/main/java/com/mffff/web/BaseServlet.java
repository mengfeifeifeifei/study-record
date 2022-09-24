package com.mffff.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的路径实现
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        int i = requestURI.lastIndexOf('/');
        // 截取最后斜线后的字符 （方法名）
        String substring = requestURI.substring(i + 1);

        // 获取字节码文件  class文件
        Class<? extends BaseServlet> aClass = this.getClass();

        Method method = null;
        try {
            // 获取方法
            method = aClass.getMethod(substring, HttpServletRequest.class, HttpServletResponse.class);
            // 反射到对应方法下
            Object invoke = method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
