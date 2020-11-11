package com.zgwzhhj.Thread;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.IntStream;

public class AtomicIntegerFieldUpdataTest {


    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i");
        TestMe me = new TestMe();
        IntStream.rangeClosed(0, 20).forEach(i -> {
            new Thread() {
                @Override
                public void run() {
                    updater.compareAndSet(me, i, 1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i);

                }
            }.start();
        });
    }

    static class TestMe {
        public volatile int i;
    }
}
