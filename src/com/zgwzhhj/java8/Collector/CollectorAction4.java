package com.zgwzhhj.java8.Collector;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.zgwzhhj.java8.Collector.CollectorAction.menu;

public class CollectorAction4 {
    public static void main(String[] args) {
        testSummingDouble();
        testSummingLong();
        testSummingInt();
    }

    private static void testSummingDouble() {
        Optional.of(menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories)).getSum()).ifPresent(System.out::println);
    }

    private static void testSummingLong() {
        Optional.of(menu.stream().map(Dish::getCalories).mapToLong(Integer::intValue).sum()).ifPresent(System.out::println);
    }

    private static void testSummingInt() {
        Optional.of(menu.stream().map(Dish::getCalories).mapToInt(Integer::intValue).sum()).ifPresent(System.out::println);
    }

}
