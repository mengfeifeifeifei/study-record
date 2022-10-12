package com.mffff.jdbcTemplate.service;

import com.mffff.jdbcTemplate.dao.BrandDao;
import com.mffff.jdbcTemplate.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private final BrandDao brandDao;

    public BrandService(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    public int updateBrand() {
        Brand brand = new Brand();
        brand.setCompany("testing");
        brand.setName("mffff");
        brand.setId(6);
        int i = brandDao.updateBrand(brand);
        return i;
    }

    public Brand selectById() {
        int id = 7;
        Brand brand = brandDao.selectById(id);
        return brand;
    }
}
