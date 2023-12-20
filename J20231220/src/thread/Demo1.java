package thread;

// 定时器的实现

import java.util.PriorityQueue;

// 任务类, 需要对任务时间进行比较
class MyTimerTask implements Comparable<MyTimerTask> {
    // 要执行的任务
    private Runnable runnable;
    // 任务执行时间
    private long time;

    // 构造器, 需要传入任务和任务时间
    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = delay + System.currentTimeMillis();
    }

    // 重写比较方法
    @Override
    public int compareTo(MyTimerTask o) {
        return (int) (this.time - o.time);
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }
}


// 计时器类
class MyTimer {
    // 创建优先级队列, 确保最小时间的任务可以被执行
    private final PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    // 锁对象
    private final Object locker = new Object();

    // 往里面添加任务
    public void schedule(Runnable runnable, long delay) {
        synchronized (locker) {
            queue.offer(new MyTimerTask(runnable, delay));
            // 唤醒任务处理线程
            locker.notify();
        }
    }

    public MyTimer() {
        // 启动任务线程
        startThread();
    }

    public void startThread() {
        // 任务处理线程
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        // 当队列为空, 进行阻塞等待
                        while (queue.isEmpty()) {
                            locker.wait();
                        }

                        // 获取队头元素
                        MyTimerTask task = queue.peek();
                        // 获取当前时间
                        long time = System.currentTimeMillis();

                        // 当时间到了, 就执行任务, 并把这个任务提出任务队列
                        if (time >= task.getTime()) {
                            task.getRunnable().run();
                            queue.poll();
                        } else {
                            // 任务时间没到, 进行阻塞等待
                            locker.wait(task.getTime() - time);
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
    }
}

public class Demo1 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        }, 3000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
            }
        }, 2000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3");
            }
        }, 1000);
    }
}