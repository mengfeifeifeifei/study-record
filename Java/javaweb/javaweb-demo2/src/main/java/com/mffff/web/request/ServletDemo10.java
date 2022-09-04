package com.mffff.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 *
 */
@WebServlet(urlPatterns = "/servlet10")
public class ServletDemo10 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 针对get方式的请求乱码问题
        String queryString = req.getQueryString();
        String s = new String(queryString.getBytes(), StandardCharsets.UTF_8);
        System.out.println(s);
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String k : parameterMap.keySet() ) {
            System.out.print(k + ":");
            String[] strings = parameterMap.get(k);
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        System.out.println(queryString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 防止传参中文乱码问题 
        // 只针对post方式的解决办法
        // tomcat 8.0 以上的不存在乱码问题，因为tomcat内部会自动转为utf-8编码
//        String a1 = req.getParameter("a1");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println(s);
//        System.out.println(a1);
    }
}
