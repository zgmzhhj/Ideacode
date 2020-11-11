package com.zgwzhhj.designpattern.pattern5;

public class AsynFuture<T> implements Future<T> {

    //判断是否结束
    private volatile boolean done = false;

    private T result;

    //完成工作
    public void done(T result) {
        synchronized (this) {
            this.result = result;
            this.done = true;
            this.notifyAll();
        }
    }

    //
    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!done) {
                this.wait();
            }
            //完成工作
            return result;
        }
    }
}
