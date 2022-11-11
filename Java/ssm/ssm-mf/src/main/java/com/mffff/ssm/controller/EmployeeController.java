package com.mffff.ssm.controller;

import com.mffff.ssm.pojo.Employee;
import com.mffff.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(name = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    @ResponseBody
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = employeeService.getEmployeeList();
        System.out.println(employeeList);
        return employeeList;
    }
}
