package com.zgwzhhj.java8.Collector;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.zgwzhhj.java8.Collector.CollectorAction.menu;

public class CollectorAction3 {
    public static void main(String[] args) {
        testPartitioningByWithPredicate();
        testPartitioningByWithPredicateAndCollector();
        testBinaryOperator();
        testReducingBinaryOperatorAndIdentiy();
        testReducingBinaryOperator();
        testSummarizingDouble();
    }

    private static void testPartitioningByWithPredicate() {
        System.out.println("testPartitioningByWithPredicate");
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testPartitioningByWithPredicateAndCollector() {
        System.out.println("testPartitioningByWithPredicateAndCollector");
        Map<Boolean, Double> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingInt(Dish::getCalories)));
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testBinaryOperator() {
        System.out.println("testBinaryOperator");
        Optional<Dish> collect = menu.stream().collect(
                Collectors.reducing(
                        BinaryOperator.maxBy(
                                Comparator.comparingInt(Dish::getCalories))));
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperatorAndIdentiy() {
        System.out.println("testReducingBinaryOperatorAndIdentiy");
        Integer collect = menu.stream().map(Dish::getCalories).collect(Collectors.reducing(0, (d1, d2) -> d1 + d2));
        System.out.println(collect);
    }

    private static void testReducingBinaryOperator() {
        System.out.println("testReducingBinaryOperator");
        Integer collect = menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, (d1, d2) -> d1 + d2));
        System.out.println(collect);
    }

    private static void testSummarizingDouble() {
        System.out.println("testSummarizingDouble");
        Optional.of(menu.stream().collect(Collectors.summarizingLong(Dish::getCalories))).ifPresent(System.out::println);
    }
}
