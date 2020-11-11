package com.zgwzhhj.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampReferenceTest {

    private static AtomicStampedReference<Integer> atomicref = new AtomicStampedReference<Integer>(100, 0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                boolean success = atomicref.compareAndSet(100, 101, atomicref.getStamp(), atomicref.getStamp() + 1);
                System.out.println(success);

                success = atomicref.compareAndSet(101, 100, atomicref.getStamp(), atomicref.getStamp() + 1);
                System.out.println(success);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                int stamp = atomicref.getStamp();
                System.out.println("before sleep stamp:" + stamp);
                TimeUnit.SECONDS.sleep(2);
                atomicref.compareAndSet(100, 101, stamp, stamp + 1);

                atomicref.compareAndSet(101, 100, atomicref.getStamp(), atomicref.getStamp() + 1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}

