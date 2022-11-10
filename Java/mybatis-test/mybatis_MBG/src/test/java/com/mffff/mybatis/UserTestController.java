package com.mffff.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mffff.mybatis.mapper.UserMapper;
import com.mffff.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class UserTestController {
    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        Page<Object> objects = PageHelper.startPage(1, 2);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();

//        List<Object> result = objects.getResult();
        users.forEach(System.out::println);
//        result.forEach(System.out::println);
        System.out.println(objects);
//        System.out.println(objects);
//        System.out.println(result);

    }
}
