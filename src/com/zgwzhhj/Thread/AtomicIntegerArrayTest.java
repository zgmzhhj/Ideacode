package com.zgwzhhj.Thread;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        testCreateAtomicIntegerArray();
        testGet();
        testSet();
    }

    public static void testCreateAtomicIntegerArray() {
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        System.out.println(array.length());
    }

    public static void testGet() {
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        System.out.println(array.get(5));
    }

    public static void testSet() {
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        array.set(5, 5);
        System.out.println(array.get(5));

    }

}
