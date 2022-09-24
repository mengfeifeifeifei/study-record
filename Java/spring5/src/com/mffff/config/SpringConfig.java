package com.mffff.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 作为配置类，替换xml配置文件
@Configuration
@ComponentScan(basePackages = {"com.mffff"})
public class SpringConfig {

}
