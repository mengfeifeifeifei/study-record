package com.mffff.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.mffff.jdbcTemplate")
@EnableTransactionManagement // 开启事务
public class JdbcTemplateConfig {
    // 连接池
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://rm-2zeff536j939032fb0o.mysql.rds.aliyuncs.com:3306/sql-project?useSSL=false&useServerPrepStmts=true");
        dataSource.setUsername("root");
        dataSource.setPassword("Baby980915");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        dataSource.setMaxWait(3000);
        return dataSource;
    }

    // jdbc
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    // 事务
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
