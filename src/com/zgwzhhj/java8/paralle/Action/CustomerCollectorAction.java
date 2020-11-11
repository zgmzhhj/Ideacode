package com.zgwzhhj.java8.paralle.Action;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class CustomerCollectorAction {
    public static void main(String[] args) {
        Collector<String, List<String>, List<String>> collator = new ToLostCollector<>();
        //   String [] arrs=new String[]{"dasj","asda","weqwvds","das"};


        List<String> result = Arrays.asList("dasj", "asda", "weqwvds", "das").parallelStream()
                .filter(s -> s.length() >= 5)
                .collect(collator);

        System.out.println(result);
    }
}
