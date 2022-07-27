package com.study.stream_input_or_out;

import java.io.*;

public class OutPut {
    /**
     * 写入字符乱码问题解决， 写入自定义编码的字符
     * @param args
     */
    public static void main(String[] args) {
        try (
                OutputStream fileOutputStream = new FileOutputStream("first/src/3.txt");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");
                Writer bufferedWriter = new BufferedWriter(outputStreamWriter);
                ) {
            bufferedWriter.write("测试");
            bufferedWriter.write("战斗法师");
            bufferedWriter.write("辅导费");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
