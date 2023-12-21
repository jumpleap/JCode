package io;

import java.io.File;
import java.util.Scanner;

// 扫描目录, 找到特定的文件
public class Demo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要搜索的目录路径: ");
        String path = scanner.next();

        File root = new File(path);
        // 判断是不是目录, 不是目录提示出错
        if (!root.isDirectory()) {
            System.out.println("你输入的路径有误, 请稍后重试!");
            return;
        }

        // 是目录, 进行递归查找要查找的文件
        System.out.println("请输入你要查找文件的关键字: ");
        String key = scanner.next();

        scanDir(root, key);
    }

    // 这个方法用于扫描整个目录
    private static void scanDir(File root, String key) {
        // 获取整个目录下的文件
        File[] files = root.listFiles();

        // 判空
        if (files == null) {
            return;
        }

        // 遍历
        for (File file : files) {
            // 日志, 方便知道当前到那个位置了
            System.out.println("你当前扫描的文件是: " + file.getAbsolutePath());
            // 是文件
            if (file.isFile()) {
                checkKey(file, key);
            } else {
                // 是目录, 继续递归扫描
                scanDir(file, key);
            }
        }

    }

    private static void checkKey(File file, String key) {
        // 当前文件名不包含关键字
        if (file.getName().contains(key)) {
            return;
        }
        // 文件名包含关键字
        System.out.println("当前文件为: " + file.getAbsolutePath() + ", 是否需要删除?(y/n): ");
        Scanner scanner = new Scanner(System.in);
        String ret = scanner.next();

        // 是y/Y则删除
        if (ret.equals("y") || ret.equals("Y")) {
            file.delete();
        } else {
            // 不删除
            System.out.println("取消删除!");
        }
    }
}