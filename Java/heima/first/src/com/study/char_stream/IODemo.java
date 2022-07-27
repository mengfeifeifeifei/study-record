package com.study.char_stream;

import java.io.FileReader;
import java.io.Reader;

public class IODemo {
    public static void main(String[] args) throws Exception {
//        FileReader fileReader = null;
        Reader fileReader = new FileReader("first/src/1.txt");
//        int n = fileReader.read();
//        System.out.println((char)n);
        int code;

        while ((code = fileReader.read()) != -1) {
            System.out.println((char) code);
        }
    }
}
