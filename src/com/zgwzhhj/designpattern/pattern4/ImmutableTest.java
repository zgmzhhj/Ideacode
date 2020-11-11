package com.zgwzhhj.designpattern.pattern4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不可变对象 默认是final修饰类的
 */
public class ImmutableTest {
    private final int age;
    private final String name;
    private final List<String> list;

    public ImmutableTest(int age, String name, List<String> list) {
        this.age = age;
        this.name = name;
        this.list = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);//不可修改
    }
}
