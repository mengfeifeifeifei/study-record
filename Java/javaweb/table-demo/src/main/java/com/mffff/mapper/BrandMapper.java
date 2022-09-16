package com.mffff.mapper;

import com.mffff.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有数据
     * @return
     */
    List<Brand> selectAll(@Param("limit") int limit, @Param("offset") int offset, @Param("brand") Brand brand);

    /**
     * 添加数据
     * @return
     */
    Integer addBrand(Brand brand);

    Integer selectCount();
}
