package com.study.stream_input_or_out;

import java.io.*;

public class Input {
    /**
     * 读取字符乱码问题解决，自定义读取字符的编码
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        InputStream fileInputStream = new FileInputStream("first/src/3.txt");
        Reader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
        Reader n = new BufferedReader(inputStreamReader);
        char[] b = new char[1024];
        int a;
        while ((a = n.read(b)) != -1) {
            String s = new String(b, 0, a);
            System.out.print(s);

        }
//        System.out.println(fileInputStream);
    }

}
