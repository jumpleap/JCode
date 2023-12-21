package io;

import java.io.File;

// File类相关API的使用
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        File file = new File("d:/test.txt");

        // 删掉文件, 直接删掉
        // System.out.println(file.delete());

        // 当进程结束后删掉
        file.deleteOnExit();
        Thread.sleep(5000);
    }
}