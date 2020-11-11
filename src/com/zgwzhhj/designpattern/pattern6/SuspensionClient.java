package com.zgwzhhj.designpattern.pattern6;

public class SuspensionClient {
    public static void main(String[] args) throws InterruptedException {

        //Guarded Suspension
        //当一个服务在工作时非常忙，不能切换当前任务，将新的任务放在队列里然后按序完成
        final RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "chen").start();

        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();
        //serverThread.join();
        Thread.sleep(10000);
        serverThread.close();
    }
}
