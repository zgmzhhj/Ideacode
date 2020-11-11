package com.zgwzhhj.designpattern.pattern15;

public class CountTest {
    public static void main(String[] args) {
        CountIcrement countIcrement = new CountIcrement();
        countIcrement.start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countIcrement.close();
    }
}
