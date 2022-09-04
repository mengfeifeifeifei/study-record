import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * JDBC操作数据库
 */
public class Javaweb {
    private static Connection connection = null;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://rm-2zeff536j939032fb0o.mysql.rds.aliyuncs.com:3306/sql-project", "root", "Baby980915");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
//        int line = autoJdbc();
//        System.out.println(line);
//        selectJdbc();
//        druidJdbc();
//        insertJdbc();
        updateJdbc();
    }

    public static void selectJdbc() throws Exception
    {
        // 注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://rm-2zeff536j939032fb0o.mysql.rds.aliyuncs.com:3306/sql-project", "root", "Baby980915");
        String sql = "select * from employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("id: " + resultSet.getInt("id"));
            System.out.println("name: " + resultSet.getString("name"));
            System.out.println("salary: " + resultSet.getString("salary"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    /**
     * 修改操作，也可执行表的操作
     * 可以执行DDL语句和DML语句  DML数据操作语句 DDL表操作语句 DQL查询语句
     * 下面是开启事务的执行
     * @return
     * @throws Exception
     */
    public static int autoJdbc() throws Exception
    {
        Statement statement = null;
        try {
            String sql = "update employee set name=\"测试jdbc\" where id = 11";
            statement = connection.createStatement();
            // 开启事务
            connection.setAutoCommit(false);
            int i = statement.executeUpdate(sql);
            // 执行事务
            connection.commit();
            return i;
        } catch (SQLException e) {
            // 回滚事务
            connection.rollback();
            throw new RuntimeException(e);
        } finally {
            connection.close();
            statement.close();
        }
    }

    /**
     * Druid数据库连接池简单使用
     * https://github.com/alibaba/druid
     */
    public static void druidJdbc() throws Exception
    {
        // 添加druid jar包

        // 加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("javaweb-demo1/druid.properties"));
        // 创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取数据库连接
        Connection connection1 = dataSource.getConnection();

        String sql = "select * from employee where id = ?";
        PreparedStatement statement = connection1.prepareStatement(sql);
        // 预处理设置字段和值
        statement.setInt(1, 10);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
        }
        System.out.println(resultSet);
        // 用户当前的路径
//        System.out.println(System.getProperty("user.dir"));
    }

    /**
     * 插入数据
     */
    public static void insertJdbc() throws Exception
    {
        Properties properties = new Properties();
        properties.load(new FileInputStream("javaweb-demo1/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection1 = dataSource.getConnection();
        String sql = "insert into employee (name, salary, departmentId, remark) values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection1.prepareStatement(sql);
        preparedStatement.setString(1, "Druid插入");
        preparedStatement.setInt(2, 100);
        preparedStatement.setInt(3, 2);
        preparedStatement.setString(4, "Druid插入备注");
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0);
    }

    /**
     * 修改数据
     * 普通jdbc连接
     * @throws Exception
     */
    public static void updateJdbc() throws Exception
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://rm-2zeff536j939032fb0o.mysql.rds.aliyuncs.com:3306/sql-project", "root", "Baby980915");
        String sql = "update employee set name = \"mengfei\" where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 2);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }
}
