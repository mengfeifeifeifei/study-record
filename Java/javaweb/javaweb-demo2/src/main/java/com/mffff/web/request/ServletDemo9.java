package com.mffff.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 *
 */
@WebServlet(urlPatterns = "/servlet9")
public class ServletDemo9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        Map<String, String[]> parameterMap = req.getParameterMap();
        Enumeration<String> parameterNames = req.getParameterNames();
        String testing = req.getParameter("testing");
        String[] parameterValues = req.getParameterValues("testing");
        BufferedReader reader = req.getReader();

        String queryString = req.getQueryString();
        System.out.println(queryString);
//        System.out.println(parameterMap);
        System.out.println(testing);
        System.out.println(Arrays.toString(parameterValues));
//        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5500");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        System.out.println("doget......");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();


    }
}
