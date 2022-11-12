package com.mffff.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mffff.ssm.mapper.EmployeeMapper;
import com.mffff.ssm.pojo.Employee;
import com.mffff.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = employeeMapper.getEmployeeList();
        return employeeList;
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Employee> employeeList = employeeMapper.getEmployeeList();
        PageInfo<Employee> page = new PageInfo<>(employeeList, 5);
        return page;
    }
}
