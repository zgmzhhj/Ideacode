package com.zgwzhhj.Thread;

import java.util.*;

public class CopyOnWriteTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "PHP");
        //Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        Iterator<Map.Entry<Integer, String>> interator = map.entrySet().iterator();

        while (interator.hasNext()) {
            Map.Entry<Integer, String> entry = interator.next();
            System.out.println(entry.getKey() + entry.getValue());
        }

    }
}
