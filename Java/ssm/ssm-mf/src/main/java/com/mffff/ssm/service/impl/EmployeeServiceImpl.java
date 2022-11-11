package com.mffff.ssm.service.impl;

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
}
