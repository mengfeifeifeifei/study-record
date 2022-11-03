package com.mffff.mybatis;

import com.mffff.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
}
