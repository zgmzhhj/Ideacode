package com.zgwzhhj.Thread.Atomic;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    /**
     * 内存可见性，内存屏障（禁止重排序），不能保障原子性
     */
    // private static volatile int value=0;

    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws InterruptedException {
    /*    Thread t1=new Thread(){
            @Override
            public void run() {
                int x=0;
                while (x < 500) {
                    set.add(value);
                    int temp= value;
                    System.out.println(Thread.currentThread().getName() + ":" + temp);
                    value+=1;
                    x++;
                    *//**
         * value=value+1
         * (1)get value from main memory to local memory
         * (2)add 1->x
         * (3)assign hte value to x
         * (4)flush to main memory
         *//*
                }
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                int x=0;
                while (x < 500) {
                    set.add(value);
                    int temp= value;
                    System.out.println(Thread.currentThread().getName() + ":" + temp);
                    value+=1;
                    x++;
                }
            }
        };
        Thread t3=new Thread(){
            @Override
            public void run() {
                int x=0;
                while (x < 500) {
                    set.add(value);
                    int temp= value;
                    System.out.println(Thread.currentThread().getName() + ":" + temp);
                    value+=1;
                    x++;
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(set.size());*/
        /**
         * AtomicInteger保证有序性，原子性，可见性
         *   getAndIncrement() 自增
         * 使用多个线程对一个数据进行自增
         */
        final AtomicInteger value = new AtomicInteger();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 5) {
                    int v = value.getAndIncrement();
                    set.add(v);
                    System.out.println(Thread.currentThread().getName() + ":" + v);
                    x++;
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 5) {
                    int v = value.getAndIncrement();
                    set.add(v);
                    System.out.println(Thread.currentThread().getName() + ":" + v);
                    x++;
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                int x = 0;
                while (x < 5) {
                    int v = value.getAndIncrement();
                    set.add(v);
                    System.out.println(Thread.currentThread().getName() + ":" + v);
                    x++;
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(set.size());
    }
}
