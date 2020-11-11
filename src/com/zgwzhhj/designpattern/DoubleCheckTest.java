package com.zgwzhhj.designpattern;


import java.util.stream.IntStream;

public class DoubleCheckTest {

    private static volatile DoubleCheckTest Instance;

    public static void main(String[] args) {
/*        System.out.println("Class loaded, Instance uninitialized");
        DoubleCheckTest instance = getInstance();
        System.out.println(instance);*/
        /**
         * 使用懒加载来实现单例模式，在初始化对象时进行doublecheck
         * 创建一个set用来查看所有线程获取的实例对象是否唯一
         */

        IntStream.rangeClosed(0, 10000).forEach(i -> new Thread(() -> {
            SingleWithEnumTest instance = SingleWithEnumTest.getInstance();
            System.out.println(instance);
        }, String.valueOf(i)).start());

    }

    private DoubleCheckTest() {
    }

    public static DoubleCheckTest getInstance() {
        if (Instance == null) {
            synchronized (DoubleCheckTest.class) {
                if (Instance == null) {
                    Instance = new DoubleCheckTest();
                }
            }
        }
        return Instance;
    }
}
