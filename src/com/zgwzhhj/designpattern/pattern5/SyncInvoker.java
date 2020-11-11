package com.zgwzhhj.designpattern.pattern5;

public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
        /*String result=get();
        System.out.println(result );*/
        FutureService futureService = new FutureService();
        Future future = futureService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        });
        System.out.println("=============");
        System.out.println("do other thing");
        Thread.sleep(10000);
        System.out.println(future.get());
    }

    public static String get() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }


}
