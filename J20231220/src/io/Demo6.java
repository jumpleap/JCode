package io;

import java.io.File;
import java.io.IOException;

// File类相关API的使用
public class Demo6 {
    public static void main(String[] args) throws IOException {
        /*File f1 = new File("d:/src.txt");
        File f2 = new File("d:/dest.txt");

        // 创建文件
        // System.out.println(f1.createNewFile());
        // System.out.println(f2.createNewFile());

        // 把test1.txt改名为test2.txt;
        boolean ret = f1.renameTo(f2);
        System.out.println(ret);*/

        // src 就是 "源", dest 就是 "目标"
        File srcFile = new File("d:/test.txt");
        File destFile = new File("d:/test2.txt");
        boolean ret = srcFile.renameTo(destFile);
        System.out.println("ret = " + ret);
    }
}
