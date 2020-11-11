package com.zgwzhhj.designpattern.pattern16;

public class WorkerClient {
    public static void main(String[] args) {

        Channel channel = new Channel(5);
        channel.startWork();

        new TransportThread("chen", channel).start();
        new TransportThread("jing", channel).start();
        new TransportThread("kasd", channel).start();
        new TransportThread("eqwe", channel).start();
    }
}
