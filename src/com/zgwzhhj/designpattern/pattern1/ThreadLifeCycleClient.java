package com.zgwzhhj.designpattern.pattern1;

import java.util.Arrays;

public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1", "2", "3"));
    }
}
