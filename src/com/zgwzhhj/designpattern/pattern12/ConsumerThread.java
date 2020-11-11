package com.zgwzhhj.designpattern.pattern12;

import java.util.Random;

/**
 * 消费者线程
 */
public class ConsumerThread extends Thread {
    private final MessageQueue messageQueue;

    private final static Random random = new Random(System.currentTimeMillis());


    public ConsumerThread(MessageQueue messageQueue, int seq) {
        super("Consumer" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName() + " take message :" + message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
