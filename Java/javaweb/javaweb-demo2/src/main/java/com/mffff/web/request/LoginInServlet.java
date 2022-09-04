package com.mffff.web.request;


import com.mffff.mapper.UserMapper;
import com.mffff.pojo.User;
import com.mffff.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * 模拟用户登录
 */
@WebServlet(urlPatterns = "/login")
public class LoginInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 接受用户名密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 调用mybatis来使用
        // 获取sqlsessionfactory对象
//        String resource = "mybatis-config.xml";
//        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        // 调用方法
        User select = usermapper.select(username, password);
        sqlSession.close();
        System.out.println(select);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (select != null) {
            writer.write("登录成功");
        } else {
            writer.write("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
