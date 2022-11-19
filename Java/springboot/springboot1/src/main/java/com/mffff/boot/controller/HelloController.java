package com.mffff.boot.controller;

import com.mffff.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Person person;
    @RequestMapping("/hello")
    public String handle() {
        return "hello, springboot 2";
    }

    @RequestMapping("/person")
    public Person person() {
        return person;
    }
}
