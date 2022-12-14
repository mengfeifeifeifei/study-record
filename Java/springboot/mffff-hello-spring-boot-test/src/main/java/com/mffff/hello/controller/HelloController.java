package com.mffff.hello.controller;

import com.mffff.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/")
    public String sayHello(HelloService helloService) {
        String HelloService = helloService.sayHello("mffff");
        return HelloService;
    }
}
