package com.zgwzhhj.Thread;

import java.util.Arrays;

public class ThreadGroup1 {
    public static void main(String[] args) {
        //use the name
        ThreadGroup tg1 = new ThreadGroup("tg1");
        Thread t1 = new Thread(tg1, "t1") {
            @Override
            public void run() {
                System.out.println(getThreadGroup().getName());
                System.out.println(getThreadGroup().getParent());
                System.out.println(Thread.currentThread().getPriority());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        System.out.println("=========");
        ThreadGroup tg2 = new ThreadGroup("tg2");
        Thread t2 = new Thread(() -> {
            System.out.println("tg2:  " + tg1.getName());
            Thread[] threads = new Thread[tg1.activeCount()];
            tg1.enumerate(threads);
            Arrays.asList(threads).forEach(System.out::println);

        });
        t2.start();
//        System.out.println(tg2.getName());
//        System.out.println(tg2.getParent());
        //use the parent and group name
       /* System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());*/
    }
}
