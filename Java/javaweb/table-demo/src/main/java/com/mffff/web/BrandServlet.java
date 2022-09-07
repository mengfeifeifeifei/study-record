package com.mffff.web;

import com.alibaba.fastjson.JSON;
import com.mffff.pojo.Brand;
import com.mffff.service.BrandService;
import com.mffff.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/brands")
public class BrandServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();
        String brandJson = JSON.toJSONString(brands);
        resp.getWriter().write(brandJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}/**/
