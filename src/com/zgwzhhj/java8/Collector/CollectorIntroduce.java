package com.zgwzhhj.java8.Collector;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorIntroduce {
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("green", 170),
                new Apple("green", 120),
                new Apple("yellow", 150),
                new Apple("yellow", 170),
                new Apple("green", 120)
        );
        List<Apple> result = list.stream()
                .filter(a -> a.getColor().equals("green"))
                .collect(Collectors.toList());

        System.out.println("=========================================");
        Optional.ofNullable(result).ifPresent(System.out::println);
        System.out.println("=========================================");

        Optional.ofNullable(group2(list)).ifPresent(System.out::println);
        System.out.println("=========================================");

        Optional.ofNullable(group3(list)).ifPresent(System.out::println);
    }

    /**
     * 以前的方式
     *
     * @param apples
     *
     * @return
     */
    private static Map<String, List<Apple>> group(List<Apple> apples) {

        Map<String, List<Apple>> map = new HashMap<>();
        for (Apple a : apples) {
            List<Apple> list = map.get(a.getColor());
            if (null == list) {
                list = new ArrayList<>();
                map.put(a.getColor(), list);
            }
            list.add(a);
        }
        return map;
    }

    /**
     * 经过Lambda表达式改造后的，但还是过于复杂
     *
     * @param apples
     *
     * @return
     */
    private static Map<String, List<Apple>> group2(List<Apple> apples) {

        Map<String, List<Apple>> map = new HashMap<>();
        apples.stream().forEach(a -> {
            List<Apple> colorList =
                    Optional.ofNullable(map.get(a.getColor()))
                            .orElseGet(() -> {
                                List<Apple> list = new ArrayList<>();
                                map.put(a.getColor(), list);
                                return list;
                            });
            colorList.add(a);
        });
        return map;
    }

    /**
     * 使用Stream
     *
     * @param apples
     *
     * @return
     */
    private static Map<String, List<Apple>> group3(List<Apple> apples) {
        return apples.stream().collect(Collectors.groupingBy(Apple::getColor));
    }
}
