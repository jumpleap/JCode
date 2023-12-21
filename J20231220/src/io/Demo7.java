package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// Reader和Writer是针对字符流的读写
// Reader的相关使用
public class Demo7 {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("d:/test.txt")) {
            while (true) {
                // 这个数组用于读数据
                char[] cbuf = new char[3];
                int n = reader.read(cbuf);

                if (n == -1) {
                    // 读完了
                    break;
                }

                // 读取到的数据进行打印输出
                for (int i = 0; i < n; i++) {
                    System.out.println(cbuf[i]);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}