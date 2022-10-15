package com.mffff.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {

    /**
     * 测试控制器行参来获取请求参数
     * 参数名相当 会自动赋值给行参
     * 多选框可以用数组形式接受，也可以用字符串类型接受，字符串类型接受的值为 多个逗号分开
     * @RequestParam用来映射字段名称
     */
    @RequestMapping("/testparam")
    public String testparam(@RequestParam("user_name") String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return "index";
    }
}
