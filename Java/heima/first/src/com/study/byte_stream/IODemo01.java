package com.study.byte_stream;


import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.String;

public class IODemo01 {
    public static void main(String[] args) throws Exception {
        // 创建文件字节输入流 读数据
        InputStream fileInputStream = new FileInputStream("first/src/1.txt");
        byte[] b = new byte[3]; // 3个字节
//        int read = fileInputStream.read(b);
//        System.out.println(read);
//        System.out.println(new String(b));
        int len;
        while ((len = fileInputStream.read(b)) != -1) {
            System.out.print(new String(b, 0, len));
        }
    }
}
