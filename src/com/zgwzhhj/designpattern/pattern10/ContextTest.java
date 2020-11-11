package com.zgwzhhj.designpattern.pattern10;

import com.zgwzhhj.designpattern.pattern9.ExecutionTest;

import java.util.stream.IntStream;

public class ContextTest {
    public static void main(String[] args) {
        IntStream.range(1, 5).forEach(i -> {
            new Thread(new ExecutionTest()).start();
        });
    }
}
