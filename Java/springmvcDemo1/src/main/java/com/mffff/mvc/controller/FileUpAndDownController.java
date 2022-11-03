package com.mffff.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class FileUpAndDownController {

    @RequestMapping("testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        // 获取servletContext对象
        ServletContext servletContext = session.getServletContext();
        // 获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/img.png");
        // 创建字节数组
        InputStream is = new FileInputStream(realPath);
        // 创建字节数组  ，获取文件对应的字节数的所有长度
        byte[] bytes = new byte[is.available()];
        // 将文件流读取到字节数组中
        is.read(bytes);

        MultiValueMap<String, String> httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=img.png");
        HttpStatus status = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, httpHeaders, status);
        is.close();
        return responseEntity;
    }

    /**
     * 1. 添加依赖 maven commons-fileupload
     * 2. springmvc中配置文件上传解析器， 将上传的对象封装成MultipartFile对象 (配置bean的id)
     * @return
     * MultipartFile 封装的上传文件对象
     */
    @RequestMapping("testUp")
    public String testUp(MultipartFile fileup, HttpSession session) throws IOException {
        // 获取表单中设置的name值
//        System.out.println(fileup.getName());
        // 获取文件名称
        String originalFilename = fileup.getOriginalFilename();
        ServletContext servletContext = session.getServletContext();
        String imgUp = servletContext.getRealPath("imgUp");
        File file = new File(imgUp);
        if (!file.exists()) {
            file.mkdir();
        }

        // File.separator 分隔符
        String finalPath = imgUp + File.separator + originalFilename;
        System.out.println(imgUp);
        // 转移
        fileup.transferTo(new File(finalPath));
        return "index";
    }
}
