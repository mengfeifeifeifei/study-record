package com.mffff.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {
    @Autowired
    private HandlerInterceptor intercepterConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> strings = new ArrayList<>();
        strings.add("/");
//        strings.add("/index");
        strings.add("/login");
        strings.add("/js/**");
        strings.add("/css/**");
        strings.add("/fonts/**");
        strings.add("/images/**");
        registry.addInterceptor(intercepterConfig).excludePathPatterns(strings);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
