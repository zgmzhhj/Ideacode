package com.zgwzhhj.java8.paralle.Action;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelProcessing {
    public static void main(String[] args) {
        //   System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("the best time process" + measureSumPerformance(ParallelProcessing::normalAdd, 100000000));
        //System.out.println("the "+measureSumPerformance(ParallelProcessing::iterateStream,10000000));

        // System.out.println("the "+measureSumPerformance(ParallelProcessing::iterateStream2,10000000));
        System.out.println("the best time process" + measureSumPerformance(ParallelProcessing::iterateStream3, 100000000));

    }


    private static long measureSumPerformance(Function<Long, Long> adder, long limit) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long startTimestamp = System.currentTimeMillis();
            long result = adder.apply(limit);
            long duration = System.currentTimeMillis() - startTimestamp;
            //System.out.println("the result of sum:"+result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    private static long iterateStream(long limit) {
        return Stream.iterate(1L, i -> i + 1).limit(limit).reduce(0L, Long::sum);
    }

    private static long iterateStream2(long limit) {
        return Stream.iterate(1L, i -> i + 1).parallel().limit(limit).reduce(0L, Long::sum);
    }

    private static long iterateStream3(long limit) {
        return LongStream.rangeClosed(1, limit).sum();
    }

    private static long normalAdd(long limit) {
        long result = 0;
        for (long i = 0; i < limit; i++) {
            result += i;
        }
        return result;
    }
}
