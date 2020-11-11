package com.zgwzhhj.test;

public class demo {
    public static void main(String[] args) {

        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);
        String s1 = "100";
        String s2 = "1" + new String("00");
        System.out.println(s1 == s2);
        Integer i3 = 100;
        Integer i4 = 100;
        System.out.println(i3 == i4);
    }

}
