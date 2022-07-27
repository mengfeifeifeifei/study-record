package com.study.byte_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class IOOutputDemo {
    public static void main(String[] args) throws Exception {
//        OutputStream fileOutputStream = new FileOutputStream("first/src/1.txt");
        // 如果要追加就在后面加上参数true， 默认会清空
        OutputStream fileOutputStream = new FileOutputStream("first/src/1.txt", true);
        fileOutputStream.write('嘘'); // 3个字节但存进去1个字节所以会乱码
//        fileOutputStream.flush();
//        fileOutputStream.close(); // 关闭包含flush

        byte[] buffer = "我是中国人".getBytes();
        fileOutputStream.write(buffer);
        fileOutputStream.write("189".getBytes());
        System.out.println(Arrays.toString(buffer));
    }
}
