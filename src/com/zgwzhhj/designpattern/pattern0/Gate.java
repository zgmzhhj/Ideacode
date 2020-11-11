package com.zgwzhhj.designpattern.pattern0;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String adders = "Nowhere";

    public void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.adders = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != adders.charAt(0)) {
            System.out.println("**********BROKEN******" + toString());
        }
    }

    public String toString() {
        return "NO." + counter + ":" + name + "," + adders;
    }
}
