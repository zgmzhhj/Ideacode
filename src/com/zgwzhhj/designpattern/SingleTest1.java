package com.zgwzhhj.designpattern;

import java.util.stream.IntStream;

public class SingleTest1 {

    private static SingleTest1 Instance = new SingleTest1();

    private SingleTest1() {
    }

    /**
     * 饿汉模式，在class加载前对象已经实例化
     *
     * @param args
     */
    public static void main(String[] args) {

        IntStream.rangeClosed(0, 100).forEach(i -> new Thread(() -> {
            SingleWithEnumTest instance = SingleWithEnumTest.getInstance();
            System.out.println(instance);
        }, String.valueOf(i)).start());
    }

    public static SingleTest1 getInstance() {
        return Instance;
    }
}
