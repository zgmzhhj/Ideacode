package com.zgwzhhj.Thread;

public class ThreadTest extends Thread {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
    }

    @Override
    public void run() {
        System.out.println("extends Thread");
    }
}
