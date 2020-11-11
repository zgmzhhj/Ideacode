package com.zgwzhhj.Thread.ThreadPoolExecutor;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) buildThreadPoolExecutor();

        int activeCount = -1;
        int queueSize = -1;
        while (true) {
            if (activeCount != threadPoolExecutor.getActiveCount() || queueSize != threadPoolExecutor.getQueue().size()) {
                System.out.println("Active  : " + threadPoolExecutor.getActiveCount());
                System.out.println("Core  : " + threadPoolExecutor.getCorePoolSize());
                System.out.println("Queue  : " + threadPoolExecutor.getQueue().size());
                System.out.println("Max  : " + threadPoolExecutor.getMaximumPoolSize());
                activeCount = threadPoolExecutor.getActiveCount();
                queueSize = threadPoolExecutor.getQueue().size();
                System.out.println("=================================");
            }
        }
    }

    private static ExecutorService buildThreadPoolExecutor() {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), r -> {
            Thread t = new Thread(r);
            return t;
        }, new ThreadPoolExecutor.AbortPolicy());
        System.out.println("the ThreadPoolExecutor create");
        executorService.execute(() -> sleepSeconds(20));
        executorService.execute(() -> sleepSeconds(20));
        executorService.execute(() -> sleepSeconds(100));
        //executorService.execute(()->sleepSeconds(100));
        return executorService;
    }

    public static void sleepSeconds(long time) {
        try {
            System.out.println(" executorThread  :  " + Thread.currentThread().getName() + "  ");
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
