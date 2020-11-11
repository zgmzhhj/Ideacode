package com.zgwzhhj.designpattern.pattern14;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageHandler {
    private static final Random random = new Random(System.currentTimeMillis());
    private final static Executor executor = Executors.newFixedThreadPool(5);

    public void request(Message message) {
        executor.execute(() -> {
            String value = message.getValues();
            System.out.println("the message will be handler" + Thread.currentThread().getName());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    public void shutdown() {
        ((ExecutorService) executor).shutdown();
    }
}
