package com.mffff.service;

import com.mffff.pojo.Brand;
import com.mffff.pojo.PageBean;

import java.util.List;

public interface BrandService {

    PageBean<Brand> selectAll(int limit, int offset, Brand brand);

    Integer addBrand(Brand brand);

    Integer updateBrand(Brand brand);

    Integer delBrand(Integer id);

    Integer batchDelete(List<Integer> ids);
}
