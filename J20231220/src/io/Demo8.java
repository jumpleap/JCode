package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// Writer的使用
public class Demo8 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("d:/test.txt")) {
            // 进行写数据, 追加的话再filename后面加一个true
            String s = "封果是一个超级大帅逼!";
            writer.write(s);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
