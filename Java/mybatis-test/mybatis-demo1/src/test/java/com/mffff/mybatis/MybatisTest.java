package com.mffff.mybatis;

import com.mffff.mybatis.mapper.UserMapper;
import com.mffff.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    @Test
    public void insertUser() throws IOException {
        // 字节流方法读取
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建工厂build
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlsession工厂
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 获取sqlsession（java和sql交互）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.insertUser();
        sqlSession.commit();
        System.out.println(i);
    }

    @Test
    public void selectUsers() throws IOException {
        // 字节流方法读取
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建工厂build
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlsession工厂
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 获取sqlsession（java和sql交互） 如果设置参数true代表开启自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUsers();
        // lambda表达式 (参数) -> {方法体}
        users.forEach(System.out::println);
    }

    @Test
    public void selectUsersByName() throws IOException {
        // 字节流方法读取
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建工厂build
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlsession工厂
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 获取sqlsession（java和sql交互） 如果设置参数true代表开启自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username = "f";
        Map<String, Object> stringObjectMap = mapper.selectUsersByName(username);
        System.out.println(stringObjectMap);
    }

    @Test
    public void insertUserGetId() throws IOException {
        // 字节流方法读取
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建工厂build
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlsession工厂
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 获取sqlsession（java和sql交互） 如果设置参数true代表开启自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("ssss");
        user.setPassword("123456");
        int i = mapper.insertUserGetId(user);
        System.out.println(user.getId());
    }
}
