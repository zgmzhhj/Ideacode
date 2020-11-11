package com.zgwzhhj.Thread;

public class RunnableTest implements Runnable {
    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        new Thread(runnableTest).start();
    }

    @Override
    public void run() {
        System.out.println("implements Runnable");
    }
}
