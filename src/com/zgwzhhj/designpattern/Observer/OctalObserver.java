package com.zgwzhhj.designpattern.Observer;

public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal " + Integer.toOctalString(subject.getState()));
    }
}
