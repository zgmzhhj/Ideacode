package com.zgwzhhj.java8;

import java.util.concurrent.*;

public class FutureInAction {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(10000);
                return "FINISHED";
            } catch (InterruptedException e) {
                return "ERROR";
            }
        });
        try {
            String s = future.get(10, TimeUnit.MICROSECONDS);
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}