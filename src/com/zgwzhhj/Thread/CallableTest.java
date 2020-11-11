package com.zgwzhhj.Thread;

import java.util.concurrent.*;

public class CallableTest implements Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest callableTest = new CallableTest();
        ExecutorService service = Executors.newCachedThreadPool();
        Future submit = service.submit(callableTest);
        System.out.println(submit.get());

    }

    @Override
    public Object call() throws Exception {
        return "implements Callable";
    }
}
