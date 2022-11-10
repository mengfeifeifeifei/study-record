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
import java.util.Arrays;
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

    /**
     * 测试一级缓存 + 条件查询
     * @throws IOException
     */
    @Test
    public void selectUserByCondition() throws IOException {
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
        user.setUsername("mf");
        user.setPassword("123456");
        // 一级缓存，默认的，同一个sqlSession对应的同一个操作默认是走一级缓存的。 执行日志可以看到sql只查询了一遍，但是调用了两遍查询语句 所以是走的一级缓存
        // 造成一级缓存失效的方式：
        // 1. 两次查询之间 存在对这条数据的增删改，那么一级缓存失效
        // 2. sqlSession.clearcache() 同一个sqlsession把缓存清空了 那一级缓存失效
        List<User> users = mapper.selectUserByCondition(user);
        List<User> userss = mapper.selectUserByCondition(user);
        users.forEach(System.out::println);
        userss.forEach(System.out::println);
//        System.out.println(user.getId());
    }

    /**
     * 测试二级缓存
     * 实体类继承序列化接口  xml映射文件写<cache />
     * 失效的方式：查询结果之间对数据进行了增删改
     * @throws IOException
     */
    @Test
    public void testTwoCache() throws IOException {
        // 字节流方法读取
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 构建工厂build
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlsession工厂
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        // 获取sqlsession（java和sql交互） 如果设置参数true代表开启自动提交事务
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        User user = new User();
        user.setUsername("mf");
        user.setPassword("123456");
        // 获取mapper
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        List<User> users1 = mapper1.selectUserByCondition(user);
        // 使用二级缓存，当close后缓存存储到sqlSessionFactory中，所以下面sqlsession2查询结果的时候走的是二级缓存 没有执行sql查询
        sqlSession1.close();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        List<User> users2 = mapper2.selectUserByCondition(user);
        sqlSession2.close();
        users1.forEach(System.out::println);
        users2.forEach(System.out::println);
//        System.out.println(user.getId());
    }
}
