package com.zgwzhhj.designpattern.pattern16;

import java.util.Random;

public class WorkerPool extends Thread {

    private final Channel channel;
    private static final Random random = new Random(System.currentTimeMillis());


    public WorkerPool(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            channel.take().execute();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
