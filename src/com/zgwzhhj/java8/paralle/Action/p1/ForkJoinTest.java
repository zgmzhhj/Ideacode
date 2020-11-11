package com.zgwzhhj.java8.paralle.Action.p1;

public class ForkJoinTest {
    private static int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        // System.out.println(calc());
        AccumulatorRecursiveTask accumulatorRecursiveTask = new AccumulatorRecursiveTask(0, data.length, data);
        Integer result = accumulatorRecursiveTask.compute();
        System.out.println(result);
    }

}
