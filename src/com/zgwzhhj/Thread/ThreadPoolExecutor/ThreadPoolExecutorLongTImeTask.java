package com.zgwzhhj.Thread.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Q:对于一些在线程池中耗费很长时间的任务，在shutdown()后它仍会继续执行而导致程序无法关闭
 * A:将工作的线程设置为守护线程，当main线程结束时它也结束
 */
public class ThreadPoolExecutorLongTImeTask {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), r -> {
            Thread t = new Thread(r);
            /**
             *  t.setDaemon(true) 解决了线程池在shutdown()后
             *  某个线程一直在工作而导致线程池不能关闭的问题
             */
            t.setDaemon(true);
            return t;
        }, new ThreadPoolExecutor.AbortPolicy());

        //并行
        IntStream.range(0, 10).boxed().forEach(i -> {
            executorService.submit(() -> {
                while (true) {

                }
            });
        });

        //串行
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("========串行=======");
    }
}
