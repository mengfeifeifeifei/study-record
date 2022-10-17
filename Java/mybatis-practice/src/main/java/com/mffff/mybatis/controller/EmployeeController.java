package com.mffff.mybatis.controller;

import com.mffff.mybatis.mapper.EmployeeMapper;
import com.mffff.mybatis.service.EmployeeService;
import com.mffff.mybatis.utils.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EmployeeController {

    private static final EmployeeService employeeService = new EmployeeService();

    private static SqlSession sqlSession;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = build.openSession();
    }

    @Test
    public void selectList() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectList(5);
        if (employees!=null && !employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("空集合");
        }
//        System.out.println(employees.get(0));
    }
}
