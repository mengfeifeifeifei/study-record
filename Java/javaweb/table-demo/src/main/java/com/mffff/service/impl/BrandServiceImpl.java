package com.mffff.service.impl;

import com.mffff.mapper.BrandMapper;
import com.mffff.pojo.Brand;
import com.mffff.service.BrandService;
import com.mffff.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    public List<Brand> selectAll() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return mapper.selectAll();
    }
}
