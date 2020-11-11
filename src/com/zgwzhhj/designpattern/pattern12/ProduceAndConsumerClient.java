package com.zgwzhhj.designpattern.pattern12;

public class ProduceAndConsumerClient {
    /**
     * 生产者和消费者测试
     *
     * @param args
     */
    public static void main(String[] args) {
        final MessageQueue messageQueue = new MessageQueue();

        new ProduceThread(messageQueue, 1).start();
        new ConsumerThread(messageQueue, 1).start();
    }
}
