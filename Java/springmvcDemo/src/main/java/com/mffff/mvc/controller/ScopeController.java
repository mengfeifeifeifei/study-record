package com.mffff.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ScopeController {
    @RequestMapping("/testRequestByServletApi")
    public String testRequestByServletApi(HttpServletRequest request) {
        request.setAttribute("test", "hello,servletapi");
        return "success";
    }

    @RequestMapping("/textModelAndView")
    public ModelAndView textModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("test", "hello, ModelAndView");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("test", "hello, session");
        return "success";
    }
}
