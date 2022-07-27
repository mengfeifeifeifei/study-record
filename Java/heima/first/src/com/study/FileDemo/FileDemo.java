package com.study.FileDemo;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        // 创建file对象
        File file = new File("/Users/zhaoheng/Desktop/ELK.md");
        String name = file.getName();
        // ELK.md
        System.out.println(name);
        long length = file.length();
        // 字节大小 504
        System.out.println(length);

        // File创建对象 可以使用绝对路径 也可以使用相对路径(定位模块中的文件),相对路径相对到工程下
        File file1 = new File("first/src/1.txt");
        System.out.println(file1.length());

        // file创建对象，可以是文件， 也可以是文件夹

    }
}
