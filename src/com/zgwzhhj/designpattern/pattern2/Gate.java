package com.zgwzhhj.designpattern.pattern2;

public class Gate {
    private int counter = 0;
    private String name = "Nobady";
    private String addres = "Nowhere";

    synchronized public void pass(String name, String addres) {
        this.counter++;
        this.name = name;
        this.addres = addres;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.addres.charAt(0)) {
            System.out.println("BROKEN_________" + toString());
        }
    }

    synchronized public String toString() {
        return "NO." + counter + ":" + name + ',' + addres;
    }
}
