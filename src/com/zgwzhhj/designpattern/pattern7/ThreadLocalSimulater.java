package com.zgwzhhj.designpattern.pattern7;

import java.util.HashMap;
import java.util.Map;

//模拟Thradlocal
public class ThreadLocalSimulater<T> {
    private final Map<Thread, T> storage = new HashMap<>();

    public void set(T t) {
        synchronized (this) {
            Thread key = Thread.currentThread();
            storage.put(key, t);
        }
    }

    public T get() {
        synchronized (this) {
            Thread key = Thread.currentThread();
            T value = storage.get(key);
            if (null == value) {
                return initalVlue();
            }
            return value;
        }
    }

    public T initalVlue() {
        return (T) "no value";
    }
}
