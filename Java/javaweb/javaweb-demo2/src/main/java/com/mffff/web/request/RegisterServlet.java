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

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String resource = "mybatis-config.xml";
//        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (user != null) {
            writer.write("账号已存在，请重新填写");
        } else {
            Integer add = mapper.add(username, password);
            sqlSession.commit();
            sqlSession.close();
            writer.write("注册成功");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
