package com.zgwzhhj.Thread.ThreadPoolExecutor;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolExecutorTask {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), r -> {
            Thread t = new Thread(r);
            return t;
        }, new ThreadPoolExecutor.AbortPolicy());
        IntStream.range(0, 10).boxed().forEach(i -> {
            //execute是非阻塞式的
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(20);
                    System.out.println(Thread.currentThread().getName() + "[ " + i + " ] finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        try {
            List<Runnable> runnables = executorService.shutdownNow();
            runnables.forEach(System.out::println);
            System.out.println("===========all finish=========");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //executorService.awaitTermination(30,TimeUnit.SECONDS);
        System.out.println("===========all finish=========");
    }
}
