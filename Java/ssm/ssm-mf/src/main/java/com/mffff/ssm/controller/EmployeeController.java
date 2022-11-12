package com.mffff.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mffff.ssm.pojo.Employee;
import com.mffff.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(name = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    @ResponseBody
    public String getEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.getEmployeeList();
        model.addAttribute("list", employeeList);
        return "employee_list";
//        System.out.println(employeeList);
//        return employeeList;
    }

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model) {
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        model.addAttribute("page", page);
        List<Employee> list = page.getList();
        list.forEach(System.out::println);
//        System.out.println(page.getList());
        return "employee_list";
    }
}
