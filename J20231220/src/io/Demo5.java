package io;

import java.io.File;

// File类相关API的使用
public class Demo5 {
    public static void main(String[] args) {
        File file = new File("d:/aaa/bbb/ccc");
        // mkdir只能创建一个目录, 不能进行多级目录的创建
        System.out.println(file.mkdir());

        // 想要创建多级目录需要使用mkdirs
        System.out.println(file.mkdirs());

        System.out.println(file.delete());
    }
}