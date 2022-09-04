package com.mffff.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = "/rep1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
//        resp.setHeader("Content-type", "text/html");
        // 设置相应头为text/html格式的 如果不设置字符集为utf-8那么返回去的是乱码
        // text/html可以解析返回的html标签内容
        resp.setContentType("text/html;charset=utf-8");
//        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("测试测试");
        writer.write("<a href=\"www.baidu.com\">测试</a>");
        // 重定向
        resp.sendRedirect("https://www.baidu.com");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream outputStream = resp.getOutputStream();
        InputStream fileInputStream = new FileInputStream("/Users/zhaoheng/Pictures/19e994330c0211a94f2ca73ce40c0572.png");
        // 方式1
        IOUtils.copy(fileInputStream, outputStream);

        // 方式2
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] byte1 = new byte[1024];
        int a;
//        while ((a = fileInputStream.read(byte1)) != -1) {
        while ((a = bufferedInputStream.read(byte1)) != -1) {
            outputStream.write(byte1, 0, a);
        }

        fileInputStream.close();
    }
}
