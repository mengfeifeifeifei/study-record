package com.mffff.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewController {

    @RequestMapping("/success")
    public String success(Model model) {
        model.addAttribute("test", "111");
        return "success";
    }
}
