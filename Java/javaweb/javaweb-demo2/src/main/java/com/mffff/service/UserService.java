package com.mffff.service;

import com.mffff.mapper.UserMapper;
import com.mffff.pojo.User;
import com.mffff.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        User user;
        try {
            SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            user = mapper.select(username, password);
            sqlSession.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
