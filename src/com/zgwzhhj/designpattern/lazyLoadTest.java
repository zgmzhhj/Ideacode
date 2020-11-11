package com.zgwzhhj.designpattern;


import java.util.stream.IntStream;

public class lazyLoadTest {

    private static lazyLoadTest Instance;

    /**
     * 使用懒加载实现单例模式，在多线程中是非安全的
     *
     * @param args
     */
    public static void main(String[] args) {

        IntStream.rangeClosed(0, 100).forEach(i -> new Thread(() -> {
            SingleWithEnumTest instance = SingleWithEnumTest.getInstance();
            System.out.println(instance);
        }, String.valueOf(i)).start());
    }

    private lazyLoadTest() {
    }

    public static lazyLoadTest getInstance() {
        if (Instance != null) {
            return Instance;
        }
        Instance = new lazyLoadTest();
        return Instance;
    }
}
