package com.zgwzhhj.designpattern.pattern15;

import java.util.Random;

public class CountIcrement extends Thread {
    private volatile boolean terminated = false;

    private int count = 0;
    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        try {
            while (!terminated) {
                System.out.println(Thread.currentThread().getName() + " " + count++);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
        } finally {
            this.clean();
        }
    }

    private void clean() {
        System.out.println("do some clean work for second phase ..count:" + count);
    }

    public void close() {
        this.terminated = true;
        this.interrupt();
    }
}
