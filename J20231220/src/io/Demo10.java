package io;

import java.io.*;

// OutputStream的使用
public class Demo10 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("d:/test.txt")) {

            // 1. 把写的数据转为二进制传送
            // String s = "今天天气真好!";
            // outputStream.write(s.getBytes());

            // 2.使用包裹输出流, 这样就是以字符流输出
            PrintWriter printWriter = new PrintWriter(outputStream);
            // printWriter.write("hello");
            printWriter.println("hello world");
            printWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}