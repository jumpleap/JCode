package io;

import java.io.File;
import java.util.Arrays;

// File类相关API的使用
public class Demo4 {
    public static void main(String[] args) {
        File file = new File("d:/");

        // 转化为字符串数组
        String[] files = file.list();
        System.out.println(Arrays.toString(files));

        // 转化为File数组
        File[] f = file.listFiles();
    }
}
