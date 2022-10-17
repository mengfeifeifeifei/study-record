package com.mffff.service.impl;

import com.mffff.mapper.BrandMapper;
import com.mffff.pojo.Brand;
import com.mffff.pojo.PageBean;
import com.mffff.service.BrandService;
import com.mffff.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    public PageBean<Brand> selectAll(int limit, int offset, Brand brand) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll(limit, offset, brand);
        Integer total = mapper.selectCount(brand);

        System.out.println("total:" + total);

        PageBean<Brand> objectPageBean = new PageBean<Brand>();
        objectPageBean.setTotalCount(total);
        objectPageBean.setData(brands);
        sqlSession.close();
        return objectPageBean;
    }

    public Integer addBrand(Brand brand) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer integer = mapper.addBrand(brand);
        sqlSession.commit();
        sqlSession.close();
        return integer;
    }

    public Integer updateBrand(Brand brand) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer integer = mapper.updateBrand(brand);
        sqlSession.commit();
        sqlSession.close();
        return integer;
    }

    public Integer delBrand(Integer id) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer integer = mapper.delBrand(id);
        sqlSession.commit();
        sqlSession.close();
        return integer;
    }

    public Integer batchDelete(List<Integer> ids) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer integer = mapper.batchDelete(ids);
        sqlSession.commit();
        sqlSession.close();
        return integer;
    }
}
