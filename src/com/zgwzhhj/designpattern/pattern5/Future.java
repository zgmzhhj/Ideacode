package com.zgwzhhj.designpattern.pattern5;

public interface Future<T> {
    T get() throws InterruptedException;
}
