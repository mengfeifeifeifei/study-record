package com.study.byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class IODemo02 {
    public static void main(String[] args) throws Exception {
        File f = new File("first/src/1.txt");
        // 创建文件字节输入流 读数据
        InputStream fileInputStream = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()]; // 3个字节
        int read = fileInputStream.read(b);
        System.out.println(read);
//        System.out.println(read);
        System.out.println(new String(b));
    }
}
