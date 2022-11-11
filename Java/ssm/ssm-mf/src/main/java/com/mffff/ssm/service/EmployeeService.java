package com.mffff.ssm.service;

import com.mffff.ssm.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();
}
