package com.zgwzhhj.Thread.ThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorExample {
    public static void main(String[] args) {
        //useCacheThreadPoolService();
        useFixSizePool();
        //usrSingle();
    }

    /**
     * newCachedThreadPool()没有核心线程，在超过线程的生命周期后线程自动销毁，线程池关闭
     * newCachedThreadPool()构造参数
     * int corePoolSize           0
     * int maximumPoolSize        Integer.MAX_VALUE
     * long keepAliveTime         60L
     * TimeUnit unit              TimeUnit.SECONDS
     * BlockingQueue<Runnable>    SynchronousQueue<Runnable>  数组实现
     * ThreadFactory              defaultThreadFactory
     * <p>
     * 适合运行时间短的线程
     */
    private static void useCacheThreadPoolService() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("initActiveCount:" + ((ThreadPoolExecutor) executorService).getActiveCount());
        System.out.println("beginActiveCount:" + ((ThreadPoolExecutor) executorService).getActiveCount());

        executorService.execute(() -> System.out.println("============"));
        System.out.println("CorePoolSize: " + ((ThreadPoolExecutor) executorService).getCorePoolSize());
        IntStream.range(0, 10).boxed().forEach(i -> {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " [ " + i + " ] ");
            });
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ActiveCount: " + ((ThreadPoolExecutor) executorService).getActiveCount());
        });
    }

    /**
     * newFixedThreadPool()创建固定个数的线程池,不能自动关闭线程池
     * <p>
     * int corePoolSize                nThreads,
     * int maximumPoolSize             nThreads,
     * long keepAliveTime              0L
     * TimeUnit unit                   TimeUnit.MILLISECONDS
     * BlockingQueue<Runnable>         new LinkedBlockingQueue<Runnable>
     * ThreadFactory
     */
    private static void useFixSizePool() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println("initActiveCount:" + ((ThreadPoolExecutor) executorService).getActiveCount());
        System.out.println("beginActiveCount:" + ((ThreadPoolExecutor) executorService).getActiveCount());

        executorService.execute(() -> System.out.println("============"));
        System.out.println("CorePoolSize: " + ((ThreadPoolExecutor) executorService).getCorePoolSize());
        IntStream.range(0, 10).boxed().forEach(i -> {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " [ " + i + " ] ");
            });
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ActiveCount: " + ((ThreadPoolExecutor) executorService).getActiveCount());
        });
    }

    /**
     * 单个线程的线程池与单个线程的区别
     * 线程池中线程使用完不会关闭，线程池会将任务提交到线程池中
     * <p>
     * int corePoolSize             1
     * int maximumPoolSize          1
     * long keepAliveTime           0L,
     * TimeUnit unit           TimeUnit.MILLISECONDS,
     * BlockingQueue<Runnable>  new LinkedBlockingQueue<Runnable>
     * ThreadFactory
     */
    private static void usrSingle() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10).boxed().forEach(i -> {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " [ " + i + " ] ");
            });
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());
        });
    }
}
