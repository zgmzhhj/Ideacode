package com.zgwzhhj.java8.Collector;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 定义一个菜单
 */
public class CollectorAction {
    public final static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.TYPE.MEAT),
            new Dish("beef", false, 700, Dish.TYPE.MEAT),
            new Dish("chicken", false, 400, Dish.TYPE.MEAT),
            new Dish("french fries", true, 530, Dish.TYPE.OTHER),
            new Dish("rice", true, 350, Dish.TYPE.OTHER),
            new Dish("season fruit", true, 120, Dish.TYPE.OTHER),
            new Dish("pizza", true, 550, Dish.TYPE.OTHER),
            new Dish("prawns", false, 400, Dish.TYPE.FISH),
            new Dish("salmon", false, 450, Dish.TYPE.FISH));

    public static void main(String[] args) {
        testAverageDouble();
        testAverageInt();
        testAverageLong();
        testCollectorAndThen();
    }

    private static void testAverageDouble() {
        System.out.println("testAverageDouble");
        Double collect = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        //方法引用
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testAverageInt() {
        System.out.println("testAverageInt");
        Double collect = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testAverageLong() {
        System.out.println("testAverageLong");
        Double collect = menu.stream().collect(Collectors.averagingLong(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testCollectorAndThen() {
        System.out.println("");
        Optional.ofNullable(menu.stream().collect(Collectors
                .collectingAndThen(Collectors
                        .averagingInt(Dish::getCalories), a
                        -> "the Average is:" + a))).ifPresent(System
                .out::print);

        List<Dish> collect = menu.stream().filter(d
                -> d.getType().equals(Dish.TYPE.MEAT)).collect(Collectors.toList());
        System.out.println(collect);
    }

}
