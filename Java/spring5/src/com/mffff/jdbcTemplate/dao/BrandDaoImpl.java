package com.mffff.jdbcTemplate.dao;

import com.mffff.jdbcTemplate.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BrandDaoImpl implements BrandDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int updateBrand(Brand brand) {
        String sql = "update brand set name = ?, company = ? where id =?";
        Object[] args = {brand.getName(), brand.getCompany(), brand.getId()};
//        Object[] args1 = {brand.getName(), brand.getCompany()};
//        Object[] args2 = {brand.getName(), brand.getCompany()};
        int updateRow = jdbcTemplate.update(sql, args);
        return updateRow;
    }
}
