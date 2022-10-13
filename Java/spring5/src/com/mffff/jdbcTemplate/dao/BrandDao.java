package com.mffff.jdbcTemplate.dao;

import com.mffff.jdbcTemplate.entity.Brand;
import org.springframework.stereotype.Component;

public interface BrandDao {

    int updateBrand(Brand brand);

    Brand selectById(int id);

    int updateEmployee();
}
