import com.mybatis.demo.Employee;
import com.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestEmployee {
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

    public static void main(String[] args) throws Exception {
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        List<Employee> employees = mapper.selectEmployee();
//        System.out.println(employees);
//        selectById();
//        selectCondition();
//        selectByIf();
//        selectAnnotationList();
//        selectBySingleCondition();
//        updateEmployee();
        DeleteById();
    }

    @Test
    public static void selectById() {
        int id = 2;
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeById(id);
        System.out.println(employee);
    }

    @Test
    public static void selectCondition() {
        String name = "zhang";
        int departmentId = 1;
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartmentId(departmentId);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectEmployeeCondition(employee);
        System.out.println(employees);
    }

    @Test
    public static void selectByIf() {
        String name = "zhang";
//        int departmentId = 1;
        Employee employee = new Employee();
        employee.setName(name);
//        employee.setDepartmentId(departmentId);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectEmployeeByIf(employee);
        System.out.println(employees);
    }

    @Test
    public static void selectAnnotationList() {
        String name = "%zhang%";
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectAnnotationList(name);
        System.out.println(employees);
    }

    @Test
    public static void selectBySingleCondition() {
//        String name = "zhang";
        int salary = 90000;
        Employee employee = new Employee();
        // 当有多个的时候 选择sql语句中靠前的条件来执行，其他不执行，相当于break
//        employee.setName(name);
        employee.setSalary(salary);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectBySingleCondition(employee);
        System.out.println(employees);
    }

    @Test
    public static void updateEmployee() {
        String name = "梦飞飞飞飞";
        int id = 2;
        Employee employee = new Employee();
        // 当有多个的时候 选择sql语句中靠前的条件来执行，其他不执行，相当于break
        employee.setName(name);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int updateCount = mapper.updateEmployee(employee, id);
        // setAutoCommit 为true
        sqlSession.commit();
        sqlSession.close();
        System.out.println(updateCount);
    }

    @Test
    public static void DeleteById() {
        int id = 3;
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int deleteCount = mapper.DeleteById(id);
        // setAutoCommit 为true
        sqlSession.commit();
        sqlSession.close();
        System.out.println(deleteCount);
    }

}
