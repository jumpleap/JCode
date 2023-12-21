package io;

import java.io.File;
import java.io.IOException;

// File类相关API的使用
public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/test.txt");

        // 判断当前file是不是文件
        System.out.println(file.isFile());
        // 判断当前file对应的文件是否存在
        System.out.println(file.exists());
        // 判断当前file是不是目录
        System.out.println(file.isDirectory());

        // 创建文件
        boolean ret = file.createNewFile();
        System.out.println(ret);

        // 判断当前file是不是文件
        System.out.println(file.isFile());
        // 判断当前file对应的文件是否存在
        System.out.println(file.exists());
        // 判断当前file是不是目录
        System.out.println(file.isDirectory());
    }
}