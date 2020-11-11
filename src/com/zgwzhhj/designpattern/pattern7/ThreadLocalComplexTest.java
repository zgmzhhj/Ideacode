package com.zgwzhhj.designpattern.pattern7;

import java.util.Random;

public class ThreadLocalComplexTest {
    private final static ThreadLocal<String> threadlocal = new ThreadLocal<>();

    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            threadlocal.set("Thread1");
            try {
                Thread.sleep(random.nextInt(1000));
                String s = threadlocal.get();
                System.out.println(Thread.currentThread().getName() + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            threadlocal.set("Thread2");
            try {
                Thread.sleep(random.nextInt(1000));
                String s = threadlocal.get();
                System.out.println(Thread.currentThread().getName() + s);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName() + threadlocal.get());
    }
}
