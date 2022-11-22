package com.mffff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootProjectApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        List<String> strings = Arrays.asList(beanDefinitionNames);
        strings.forEach(System.out::println);
    }

}
