package com.zgwzhhj.java8.Collector;

public class Dish {

    public enum TYPE {
        MEAT,
        OTHER,
        FISH
    }

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final TYPE type;

    public Dish(String name, boolean vegetarian, int calories, TYPE type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public TYPE getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}
