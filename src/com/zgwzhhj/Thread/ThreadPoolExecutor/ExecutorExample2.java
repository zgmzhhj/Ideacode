package com.zgwzhhj.Thread.ThreadPoolExecutor;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorExample2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> collect = IntStream.range(0, 20).boxed().map(i ->
                (Callable<String>) () -> {
                    System.out.println("thread  " + Thread.currentThread().getName());
                    sleep(1);
                    return "task" + i;
                }
        ).collect(Collectors.toList());

        executorService.invokeAll(collect).stream().map(future -> {


            String s = null;
            try {
                s = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            return s;
        }).forEach(System.out::println);
        /*executorService.invokeAll(collect).stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).forEach(System.out::println);
        try {
            executorService.invokeAll(collect);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
