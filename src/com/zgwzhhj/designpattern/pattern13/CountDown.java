package com.zgwzhhj.designpattern.pattern13;

//自定义countdown
public class CountDown {
    private final int total;

    private int count = 0;

    public CountDown(int total) {
        this.total = total;
    }

    public void down() throws InterruptedException {
        synchronized (this) {
            this.count++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this) {
            while (count != total) {
                this.wait();
            }

        }
    }
}
