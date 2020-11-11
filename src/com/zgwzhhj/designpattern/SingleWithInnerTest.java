package com.zgwzhhj.designpattern;


import java.util.stream.IntStream;

public class SingleWithInnerTest {
    /**
     * 使用内部类实现单例模式，在私有的内部类中初始化对象
     */
    private static class SingleHolder {
        private static SingleWithInnerTest instance = new SingleWithInnerTest();
    }

    private SingleWithInnerTest() {
    }

    public static void main(String[] args) {

        IntStream.rangeClosed(0, 100).forEach(i -> new Thread(() -> {
            SingleWithEnumTest instance = SingleWithEnumTest.getInstance();
            System.out.println(instance);
        }, String.valueOf(i)).start());
    }

    public static SingleWithInnerTest getInstance() {
        return SingleHolder.instance;
    }
}
