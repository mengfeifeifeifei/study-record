package com.mffff.web;

import com.mffff.pojo.User;
import com.mffff.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 注册登录 cookie小案例
 */
@WebServlet(urlPatterns = "/logintest")
public class LoginInServlet extends HttpServlet {
    private final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        User user = userService.login(username, password);
        if (user != null) {
            // 登录成功
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // 用户勾选了记住我
            if ("1".equals(remember)) {
                // 创建cookie对象
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);

                c_username.setMaxAge( 60 * 60 * 24 * 7);
                c_password.setMaxAge( 60 * 60 * 24 * 7);

                resp.addCookie(c_username);
                resp.addCookie(c_password);
            }
        } else {
            // 登录失败
            req.setAttribute("login_msg", "登录失败");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
