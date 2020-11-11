package com.zgwzhhj.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class CountDownLatchExample1 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);

        IntStream.rangeClosed(0, 10).forEach(i -> new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(i);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
