package com.study.byte_stream;

import java.io.*;

public class Resource {
    // 简写版的CopyDemo
    public static void main(String[] args) {
        // 使用字节流完成文件的复制
        try (// 这里面只能放资源对象，用完会自动关闭，自动调用资源对象的close方法关闭资源（即使出现异常也会执行）
             // 定义一个输入流
             InputStream fileInputStream = new FileInputStream("/Users/zhaoheng/Desktop/数据/完美志愿/录取_专业_46_2021.csv");
             // 缓冲区，提升性能， 一次性从文件中读8k数据放入缓冲区
             InputStream fileInputStream1 = new BufferedInputStream(fileInputStream);
             // 定义输出流
             OutputStream fileOutputStream = new FileOutputStream("/Users/zhaoheng/Desktop/数据/完美志愿/export_test.csv");
             // 缓冲区，提升性能
             OutputStream fileOutputStream1 = new BufferedOutputStream(fileOutputStream)
        ) {
            // 定义一个字节数组来存
            byte[] bytes = new byte[1024];
            int len;
            // 从缓冲区中循环读取数据
            while ((len = fileInputStream1.read(bytes)) != -1) {
                fileOutputStream1.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
}
