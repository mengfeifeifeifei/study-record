package com.mffff.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * 主程序类
 * SpringBootApplication 这是一个springboot应用
 * 默认扫描当前类所在的目录下的所有的包文件
 */
@SpringBootApplication
//@ConfigurationPropertiesScan
public class MainApplication {
    public static void main(String[] args) {
        // 获取的IOC容器，包含所有加载进来的bean
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (int i = 0; i < beanDefinitionNames.length; i++) {
//            System.out.println(beanDefinitionNames[i]);
//        }
//        List<String> strings = Arrays.asList(beanDefinitionNames);
//        strings.forEach(System.out::println);
    }
}
