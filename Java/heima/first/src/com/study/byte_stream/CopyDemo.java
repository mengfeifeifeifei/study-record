package com.study.byte_stream;

import java.io.*;

public class CopyDemo {
    public static void main(String[] args) {
        InputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        // 使用字节流完成文件的复制
        try {
            // 定义一个输入流
            fileInputStream = new FileInputStream("/Users/zhaoheng/Desktop/数据/完美志愿/录取_专业_46_2021.csv");
            // 定义输出流
            fileOutputStream = new FileOutputStream("/Users/zhaoheng/Desktop/数据/完美志愿/export_test.csv");
            // 定义一个字节数组来存
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
//            fileOutputStream.close();
//            fileInputStream.close();
//            File file = new File("/Users/zhaoheng/Desktop/数据/完美志愿/录取_专业_46_2021.csv");
//            long length = file.length();
//            System.out.println(length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 无论代码是否正常结束，都会执行, 一般做资源释放
            try {
                if (fileOutputStream != null)fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fileInputStream != null)fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
