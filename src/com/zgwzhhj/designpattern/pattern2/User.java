package com.zgwzhhj.designpattern.pattern2;

public class User extends Thread {
    private String myName;

    private String myAddress;

    private final Gate gate;

    public User(String myName, String myAddress, Gate gate) {
        this.myName = myName;
        this.myAddress = myAddress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myName + "BEGIN________");
        while (true) {
            this.gate.pass(myName, myAddress);
        }
    }
}
