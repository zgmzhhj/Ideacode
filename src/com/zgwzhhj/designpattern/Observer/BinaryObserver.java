package com.zgwzhhj.designpattern.Observer;

public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary " + Integer.toBinaryString(subject.getState()));
    }
}
