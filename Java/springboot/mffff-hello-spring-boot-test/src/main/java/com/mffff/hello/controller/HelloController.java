package com.mffff.hello.controller;

import com.mffff.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    public String sayHello() {
        String HelloService = helloService.sayHello("张梦飞");
        return HelloService;
    }
}
