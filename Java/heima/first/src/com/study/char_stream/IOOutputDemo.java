package com.study.char_stream;

import java.io.FileWriter;

public class IOOutputDemo {
    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("first/src/1.txt", true);
        fileWriter.write("aaa");
        fileWriter.write("张");
        fileWriter.write("123");
        fileWriter.write(87);
        fileWriter.flush();
        fileWriter.close();
    }
}
