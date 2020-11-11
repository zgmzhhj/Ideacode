package com.zgwzhhj.Thread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDetailsTest {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        System.out.println(i.get());
        i = new AtomicInteger(10);
        System.out.println(i.get());
        //set
        i.set(11);
        System.out.println(i.get());
        System.out.println("=================");
        //getAndSet 先获取值后赋值
        AtomicInteger getandset = new AtomicInteger();
        int result = getandset.getAndSet(10);
        System.out.println(result);
        System.out.println(getandset.get());

        /**
         * 使用两个线程对 getandset2 进行操作
         */
        AtomicInteger getandset2 = new AtomicInteger();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    int v = getandset2.getAndAdd(1);
                    System.out.println(Thread.currentThread().getName() + v);
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    int v = getandset2.getAndAdd(1);
                    System.out.println(Thread.currentThread().getName() + v);
                }
            }
        }.start();
    }
}
