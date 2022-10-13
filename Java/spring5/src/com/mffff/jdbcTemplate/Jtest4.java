package com.mffff.jdbcTemplate;

import com.mffff.jdbcTemplate.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 整合junit4 测试
@RunWith(SpringJUnit4ClassRunner.class) // 单元测试文件
@ContextConfiguration("classpath:bean4jdbc.xml")
public class Jtest4 {

    @Autowired
    private BrandService brandService;

    @Test
    public void test() {
        System.out.println(brandService);
        System.out.println(1111);
    }
}
