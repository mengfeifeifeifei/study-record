package com.mybatis.mapper;

import com.mybatis.demo.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectEmployee();

    Employee selectEmployeeById(int id);

    List<Employee> selectEmployeeCondition(Employee employee);
    List<Employee> selectEmployeeByIf(Employee employee);

    // 注解方式
    @Select("select * from employee where name like #{name}")
    List<Employee> selectAnnotationList(String name);

    List<Employee> selectBySingleCondition(Employee employee);

    Integer updateEmployee(@Param("employee") Employee employee, @Param("id") int id);
}
