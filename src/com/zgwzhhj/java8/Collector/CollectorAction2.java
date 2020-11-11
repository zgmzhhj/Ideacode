package com.zgwzhhj.java8.Collector;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

public class CollectorAction2 {
    public static void main(String[] args) {
        testGroupByConcurrent();
        testGroupByConcurrent2();
        testGroupByConcurrent3();
        testJoining();
        testJoiningWithDelimiter();
        testJoiningWithDelimiterAndSuffix();
        testMapping();
        testMaxBy();
        testMinBy();
    }


    private static void testGroupByConcurrent() {
        System.out.println("with Function");
        ConcurrentMap<Dish.TYPE, List<Dish>> collect = CollectorAction.menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testGroupByConcurrent2() {
        System.out.println("with Function and Collector");
        ConcurrentMap<Dish.TYPE, Double> collect = CollectorAction.menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType,
                Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testGroupByConcurrent3() {
        System.out.println("with Function and Supplier and Collector");
        ConcurrentSkipListMap<Dish.TYPE, Double> collect = CollectorAction.menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, ConcurrentSkipListMap::new,
                Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testJoining() {
        System.out.println("testJoining");
        Optional.of(CollectorAction.menu.stream().map(Dish::getName).collect(Collectors.joining())).ifPresent(System.out::println);

    }

    private static void testJoiningWithDelimiter() {
        System.out.println("testJoining");
        Optional.of(CollectorAction.menu.stream().map(Dish::getName).collect(Collectors.joining(";"))).ifPresent(System.out::println);

    }

    private static void testJoiningWithDelimiterAndSuffix() {
        System.out.println("testJoining");
        Optional.of(CollectorAction.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(",", "Names[", "]")))
                .ifPresent(System.out::println);

    }

    private static void testMapping() {
        Optional.of(CollectorAction.menu.stream()
                .collect(Collectors.mapping(Dish::getName,
                        Collectors.joining(","))))
                .ifPresent(System.out::println);

    }

    private static void testMaxBy() {
        CollectorAction.menu.stream()
                .collect(Collectors.maxBy(Comparator
                        .comparingInt(Dish::getCalories)))
                .ifPresent(System.out::print);
    }

    private static void testMinBy() {
        CollectorAction.menu.stream()
                .collect(Collectors.minBy(Comparator
                        .comparingInt(Dish::getCalories)))
                .ifPresent(System.out::print);
    }
}
