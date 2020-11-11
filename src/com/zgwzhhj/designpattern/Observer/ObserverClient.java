package com.zgwzhhj.designpattern.Observer;

public class ObserverClient {
    public static void main(String[] args) {
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("==============");
        subject.setState(10);
        System.out.println("=======state not change=======");
        subject.setState(10);
        System.out.println("====state change=====");
        subject.setState(11);
    }
}

