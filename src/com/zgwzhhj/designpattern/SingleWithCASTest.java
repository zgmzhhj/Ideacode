package com.zgwzhhj.designpattern;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class SingleWithCASTest {
    /**
     * 使用Atomic类型来实现单例
     */
    private static final AtomicReference<SingleWithCASTest> INSTANCE = new AtomicReference<>();

    private static SingleWithCASTest instance;

    private SingleWithCASTest() {
    }

    public static void main(String[] args) {

        IntStream.rangeClosed(0, 100).forEach(i -> new Thread(() -> {
            SingleWithEnumTest instance = SingleWithEnumTest.getInstance();
            System.out.println(instance);
        }, String.valueOf(i)).start());
    }

    public static final SingleWithCASTest getInstance() {

        SingleWithCASTest Instance = INSTANCE.get();
        if (null != instance)
            return instance;

        INSTANCE.compareAndSet(null, new SingleWithCASTest());
        return INSTANCE.get();
    }
}
