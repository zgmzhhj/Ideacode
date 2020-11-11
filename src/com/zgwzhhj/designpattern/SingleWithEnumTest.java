package com.zgwzhhj.designpattern;

import java.util.stream.IntStream;

public class SingleWithEnumTest {
    /**
     * 使用枚举实现单例模式
     */
    private SingleWithEnumTest() {
    }

    private enum Singleton {
        INSTANCE;

        private final SingleWithEnumTest instance;

        Singleton() {
            instance = new SingleWithEnumTest();
        }

        public SingleWithEnumTest getInstance() {
            return instance;
        }
    }

    public static SingleWithEnumTest getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {

        IntStream.rangeClosed(0, 100).forEach(i -> new Thread(() -> {
            SingleWithEnumTest instance = SingleWithEnumTest.getInstance();
            System.out.println(instance);
        }, String.valueOf(i)).start());
    }

}
