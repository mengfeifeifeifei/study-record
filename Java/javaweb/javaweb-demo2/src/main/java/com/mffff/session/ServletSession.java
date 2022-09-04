package com.mffff.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session的实现是基于cookie的
 * session.setAttribute时候 服务器会在响应头返回一个set-cookie:jsessionid 返回到游览器
 * 游览器会存储到cookie中，之后请求就会携带jsessionid来请求服务器
 * 服务器此时req.getSession的时候会先找jsessionid是否存在，如果存在就直接获取，之后设置值或获取值
 * 不存在会去创建
 */
@WebServlet(urlPatterns = "/session")
public class ServletSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
//        HttpSession session = req.getSession();
//        session.setAttribute("username", "zmf");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
