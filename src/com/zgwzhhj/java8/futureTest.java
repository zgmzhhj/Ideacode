package com.zgwzhhj.java8;

import java.util.concurrent.*;

public class futureTest {
    public static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Future<String> result1 = executor.submit(
                () -> {
                    long startTime = System.currentTimeMillis();
                    Thread.sleep(5000);
                    long endTime = System.currentTimeMillis();
                    return Thread.currentThread().getName() + " is Finish" + (endTime - startTime);
                });
        Future<String> result2 = executor.submit(
                () -> {
                    long startTime = System.currentTimeMillis();
                    Thread.sleep(1000);
                    long endTime = System.currentTimeMillis();
                    return Thread.currentThread().getName() + " is Finish" + (endTime - startTime);
                });
        try {
            String s1 = result1.get();
            String s2 = result2.get();
            System.out.println("do other");
            System.out.println(s1);
            System.out.println(s2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
