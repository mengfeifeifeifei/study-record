package com.mffff.jdbcTemplate.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// ����junit5 ����
@ExtendWith(SpringExtension.class) // ��Ԫ�����ļ�
@ContextConfiguration("classpath:bean4jdbc.xml")
public class Jtest5 {

    @Autowired
    private BrandService brandService;

    @Test
    public void test() {
        System.out.println(brandService);
        System.out.println(1111);
    }
}
