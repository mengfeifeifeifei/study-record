package com.study.files;

import java.io.File;
import java.util.Arrays;

public class FileDemo {
    public static void main(String[] args) {
        File f = new File("/Users/zhaoheng/working");
        searchFile(f, "Vue.md");
    }

    public static void searchFile(File dir, String fileName) {
        // 如果文件夹不存在返回null
        // 如果文件夹存在但是文件夹中是空的 那么返回 []
        if (dir != null && dir.isDirectory()) {
//            File f = new File(dir);
            File[] fileList = dir.listFiles();
            if (fileList != null && fileList.length > 0) {
                for (File file : fileList) {
                    if (file != null && file.isFile()) {
                        if (file.getName().contains(fileName)) {
                            System.out.println("文件路径:" + file.getAbsoluteFile());
                            return;
                        }
                    } else {
                        searchFile(file, fileName);
                    }
                }
            }
        } else {
            System.out.println("文件操作有误，不支持!");
        }
    }
}
