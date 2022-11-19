package com.mffff.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能, 所以要加Component
 */
@Component
@ConfigurationProperties(prefix = "person")
@ToString
@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private Integer sex;
}
