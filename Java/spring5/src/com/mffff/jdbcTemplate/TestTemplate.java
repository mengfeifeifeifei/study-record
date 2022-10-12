package com.mffff.jdbcTemplate;

import com.mffff.jdbcTemplate.entity.Brand;
import com.mffff.jdbcTemplate.service.BrandService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTemplate {

    @Test
    public void updateBrand() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean4jdbc.xml");
        BrandService brandService = classPathXmlApplicationContext.getBean("brandService", BrandService.class);
        int i = brandService.updateBrand();
//        System.out.println(i);
    }

    @Test
    public void selectByIdBrand() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean4jdbc.xml");
        BrandService brandService = classPathXmlApplicationContext.getBean("brandService", BrandService.class);
        Brand brand = brandService.selectById();
        System.out.println(brand);
    }
}
