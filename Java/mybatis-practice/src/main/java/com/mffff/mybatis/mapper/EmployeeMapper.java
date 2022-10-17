package com.mffff.mybatis.mapper;

import com.mffff.mybatis.utils.Employee;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> selectList(int id);
}
