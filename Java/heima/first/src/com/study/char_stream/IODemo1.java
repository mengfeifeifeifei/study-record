package com.study.char_stream;

import java.io.FileReader;
import java.io.Reader;

public class IODemo1 {
    public static void main(String[] args) throws Exception {
//        FileReader fileReader = null;
        Reader fileReader = new FileReader("first/src/1.txt");

        char[] chars = new char[5];
//        int n = fileReader.read();
//        System.out.println((char)n);
        int len;

        while ((len = fileReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
//            System.out.println((char) chars);
        }
    }
}
