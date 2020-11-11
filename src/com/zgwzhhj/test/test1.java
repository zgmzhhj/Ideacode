package com.zgwzhhj.test;

public class test1 {

    public status s;

    public enum status {
        READY,
        WORKING,
        FINISH,
    }

    boolean isReady() {
        return getS() == status.READY;
    }

    boolean isWorking() {
        return getS() == status.WORKING;
    }

    boolean isFinish() {
        return getS() == status.FINISH;
    }

    public status getS() {
        return s;
    }
}
