package com.mffff.jdbcTemplate;

import com.mffff.jdbcTemplate.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// ����junit4 ����
@RunWith(SpringJUnit4ClassRunner.class) // ��Ԫ�����ļ�
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
