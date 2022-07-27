package com.study.byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class IODemo {
    public static void main(String[] args) throws Exception {
        // 创建文件字节输入流 读数据
        InputStream fileInputStream = new FileInputStream("first/src/1.txt");
//        int read = fileInputStream.read();
        // read此时为字节码
        // 读取没有的再读返回-1
//        System.out.println((char)read);

        // 循环
        int b;
        while ((b = fileInputStream.read()) != -1) {
            System.out.println((char) b);
        }
    }
}
