package com.zgwzhhj.designpattern.pattern5;

public class FutureService {
    public <T> Future<T> submit(final FutureTest<T> task) {
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
        }).start();
        return asynFuture;
    }
}
