package com.zgwzhhj.java8.Optional;

import java.util.Optional;

public class OptionaInAction {
    public static void main(String[] args) {

        //System.out.println(getInsuranceNameByOptional(null));

        Optional.ofNullable(getInsuranceNameByOptional(null))
                .ifPresent(System.out::print);

    }

    public static String getInsuranceNameByOptional(Person person) {
        /**
         * flatMap 扁平化的流，不会对流再进行包装
         * 若使用Map下面方法则会返回
         * Optional<Optional>  的类型
         */
        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .flatMap(Insurance::getName).orElse("UNKNOWN");
    }
}
