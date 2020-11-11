package com.zgwzhhj.Thread;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class semaphoreTest3 {
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(() -> {
            try {
                /**
                 * 申请信号量，若没有指定数量则默认为 1
                 */
                semaphore.acquire();
                //  TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            System.out.println("t1 finish");
        });
        t1.start();

        TimeUnit.MILLISECONDS.sleep(50);

        Thread t2 = new Thread(() -> {
            try {
                semaphore.acquire();
                //    TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            System.out.println("t2 finish");

        });
        t2.start();

        TimeUnit.MILLISECONDS.sleep(50);

        t2.interrupt();
    }
}