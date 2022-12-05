package com.mffff.hello.service;

import com.mffff.hello.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 不要放在容器中
 */
public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String username) {
        return helloProperties.getPrefix() + ": " + username + helloProperties.getSuffix();
    }
}
