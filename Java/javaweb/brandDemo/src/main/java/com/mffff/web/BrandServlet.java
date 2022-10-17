package com.mffff.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mffff.pojo.Brand;
import com.mffff.pojo.PageBean;
import com.mffff.service.BrandService;
import com.mffff.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        String name = req.getParameter("name");
        String _status = req.getParameter("status");
        String company = req.getParameter("company");
        Brand brand = new Brand();
        if (name != null && !name.equals("")) {
            name = "%" + name + "%";
            brand.setName(name);
        }
        if (_status != null && !_status.equals("")) {
            Integer status = Integer.parseInt(_status);
            brand.setStatus(status);
        }
        if (company != null && !company.equals("")) {
            company = "%" + company + "%";
            brand.setCompany(company);
        }

        int limit1 = Integer.parseInt(limit);
        int offset = (Integer.parseInt(page)-1) * limit1;
        PageBean<Brand> brands = brandService.selectAll(limit1, offset, brand);
        String brandJson = JSON.toJSONString(brands);

        resp.setHeader("content-type", "application/json");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(brandJson);
    }

    public void addBrand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 这种方法也行
        // ServletInputStream inputStream = req.getInputStream();
        // String s1 = IOUtils.toString(inputStream);
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);
//        Brand brand = new Brand();
        Integer integer = brandService.addBrand(brand);
        System.out.println(integer);
        resp.getWriter().write(integer);
    }

    public void updateBrand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);
        Integer integer = brandService.updateBrand(brand);
        System.out.println(integer);
        resp.getWriter().write(integer);
    }

    public int delBrand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String _id = req.getParameter("id");
            int id = Integer.parseInt(_id);
            Integer integer = brandService.delBrand(id);
            resp.setContentType("text/html;charset=utf-8");
            return integer;
//            resp.getWriter().write(integer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void batchDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        // 接受到的s是json字符串
        String s = reader.readLine();
        JSONObject jsonObject = JSON.parseObject(s);
        List<Integer> ids = (List<Integer>) jsonObject.get("ids");
//        System.out.println(ids);
//        String _whereIds = "(";
//        for (int i = 0; i < ids.size(); i++) {
//            if (i != ids.size()-1) {
//                _whereIds += ids.get(i) + ",";
//            }
//            _whereIds += ids.get(i);
//        }
//        _whereIds += ")";
//        Integer integer = brandService.batchDelete(_whereIds);
        Integer integer = brandService.batchDelete(ids);
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "application/json");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("count", integer);
        resp.getWriter().write(JSON.toJSONString(jsonObject1));
    }

}
