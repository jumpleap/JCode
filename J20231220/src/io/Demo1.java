package io;

import java.io.File;
import java.io.IOException;

// File类相关API的使用
public class Demo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("./test.txt");
        // 获取父路径
        System.out.println(file.getParent());
        // 获取文件名, 包含后缀名
        System.out.println(file.getName());
        // 获取文件的路径
        System.out.println(file.getPath());
        // 获取文件的绝对路径
        System.out.println(file.getAbsolutePath());
        // 获取文件的绝对路径, 不包含./
        System.out.println(file.getCanonicalFile());
    }
}
