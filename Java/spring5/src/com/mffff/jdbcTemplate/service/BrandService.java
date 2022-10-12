package com.mffff.jdbcTemplate.service;

import com.mffff.jdbcTemplate.dao.BrandDao;
import com.mffff.jdbcTemplate.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;

    public int updateBrand() {
        Brand brand = new Brand();
        brand.setCompany("testing");
        brand.setName("mffff");
        brand.setId(6);
        int i = brandDao.updateBrand(brand);
        return i;
    }
}
