package com.mffff.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/servletcookie")
public class ServletCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "张梦飞";
        // cookie默认不支持中午，转为url编码返回， 获取的时候解码
        String s = URLEncoder.encode(name, "utf-8");
        // 在游览器响应头中存在set-cookie字段为设置的值
        Cookie cookie = new Cookie("username", s);
        // 设置cookie有效期七天， 会存储在浏览器的硬盘中，到期自动删除
        cookie.setMaxAge(60*60*24*7);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
