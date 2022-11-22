package com.mffff.controller;

import com.mffff.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping({"/", "/login"})
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        if (StringUtils.hasLength(user.getUserName()) && user.getPassword().equals("123456")) {
            session.setAttribute("loginUser", user);
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    /**
     * 拦截器实现登录验证
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String indexPage(HttpSession session, Model model) {
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null) {
//            return "index";
//        } else {
//            model.addAttribute("msg", "请重新登录");
//            return "login";
//        }
        return "index";
    }
}
