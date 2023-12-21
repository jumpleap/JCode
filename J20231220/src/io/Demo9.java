package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

// InputStream的使用
public class Demo9 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("d:/test.txt")) {
            Scanner scanner = new Scanner(inputStream);
            while (true) {
                // 用来读数据的数组
                /*byte[] bytes = new byte[5];
                int n = inputStream.read(bytes);

                if (n == -1) {
                    // 读完了
                    break;
                }

                // 打印
                for (int i = 0; i < n; i++) {
                    System.out.println(bytes[i]);
                }*/

                // 可以把读到的二进制转为字符
                String s = scanner.next();
                System.out.println(s);
                break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
