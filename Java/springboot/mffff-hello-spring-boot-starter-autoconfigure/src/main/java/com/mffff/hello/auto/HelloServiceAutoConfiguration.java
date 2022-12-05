package com.mffff.hello.auto;

import com.mffff.hello.bean.HelloProperties;
import com.mffff.hello.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(HelloService.class)
@EnableConfigurationProperties(HelloProperties.class) // 默认HelloProperties放在容器中 作用参考https://blog.csdn.net/AlbenXie/article/details/105709976
public class HelloServiceAutoConfiguration {

    @Bean
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        return helloService;
    }
}
