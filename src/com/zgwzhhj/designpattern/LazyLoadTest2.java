package com.zgwzhhj.designpattern;

import java.util.stream.IntStream;

public class LazyLoadTest2 {

    private static LazyLoadTest2 Instance;

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

    private LazyLoadTest2() {
    }

    public static synchronized LazyLoadTest2 getInstance() {
        if (Instance != null) {
            return Instance;
        }
        Instance = new LazyLoadTest2();
        return Instance;
    }
}
