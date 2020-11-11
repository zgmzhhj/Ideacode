package com.zgwzhhj.java8;

public class LambdaTest {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Previous methods");
            }
        };

        t1.start();
        new Thread(() -> {
            System.out.println("Use Lambda");
        }).start();
    }
}
