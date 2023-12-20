package thread;

// 线程池的实现

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class MyThreadPool {
    // 创建阻塞对类
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);

    // 把任务添加到阻塞队列中
    public void submit(Runnable runnable) throws InterruptedException {
        // 当阻塞队列满了之后, 进行阻塞等待
        queue.put(runnable);
    }

    // 传入要创建线程的数目
    public MyThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                try {
                    // 获取要执行的任务
                    Runnable runnable = queue.take();
                    // 运行
                    runnable.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }

    }
}

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            int id = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(id + "!");
                }
            });
        }
    }
}
