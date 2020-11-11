package com.zgwzhhj.designpattern.pattern12;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者线程
 */
public class ProduceThread extends Thread {
    private final MessageQueue messageQueue;

    private final static Random random = new Random(System.currentTimeMillis());

    private final static AtomicInteger counter = new AtomicInteger(0);

    public ProduceThread(MessageQueue messageQueue, int seq) {
        super("PRODUCE" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = new Message("message" + counter.getAndDecrement());
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName() + " put message :" + message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
