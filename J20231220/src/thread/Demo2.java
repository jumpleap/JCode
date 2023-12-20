package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 线程池API的使用
public class Demo2 {
    public static void main(String[] args) {
        // 动态的创建线程
        ExecutorService service = Executors.newCachedThreadPool();

        // 创建固定的线程数量
        ExecutorService service1 = Executors.newFixedThreadPool(5);

        // 只能创建一个线程
        ExecutorService service2 = Executors.newSingleThreadExecutor();

        // 使用submit方法进行使用
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
    }
}
