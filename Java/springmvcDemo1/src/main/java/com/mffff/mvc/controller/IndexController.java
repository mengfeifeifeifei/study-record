package com.mffff.mvc.controller;

import com.mffff.mvc.entity.TestResponseJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    /**
     * 跳转到页面test.html
     * @param modelAndView
     * @return
     */
    @RequestMapping("test")
    public ModelAndView returnString(ModelAndView modelAndView) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("test", "111");
        mav.setViewName("test");
        return mav;
    }

    /**
     * 页面返回字符串testResponse
     * @return
     */
    @RequestMapping("testResponse")
    @ResponseBody
    public String returnRespoonse() {
        return "testResponse";
    }

    /**
     * 测试@ResponseBody返回前端json格式
     * 注意： 这里实体类TestResponseJson 没有设置get方法就没办法return 返回值 报错406
     */
    @RequestMapping(value = "testResponseJson")
    @ResponseBody
    public TestResponseJson returnResponseJson() {
        return new TestResponseJson(1, "mf", 18, "185");
//        return testResponseJson;
    }
}
