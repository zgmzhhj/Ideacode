package com.zgwzhhj.designpattern.pattern4;

public class ImmutablePerformTest {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        SynObj synObj = new SynObj();
        synObj.setName("chen");
        ImmutableObj immutableObj = new ImmutableObj("chen");

        Thread t1 = new Thread(() -> {
            for (long i = 0L; i < 1000000; i++) {
                System.out.println(Thread.currentThread().getName() + synObj.toString());
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0L; i < 1000000; i++) {
                System.out.println(Thread.currentThread().getName() + synObj.toString());
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long endTime = System.currentTimeMillis();
        System.out.println("the time " + (endTime - startTime));
    }
}

final class ImmutableObj {
    private final String name;

    ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ImmutableObj{" +
                "name='" + name + '\'' +
                '}';
    }
}

class SynObj {
    private String name;

    public SynObj(String name) {
        this.name = name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public SynObj() {

    }

    public synchronized String toString() {
        return "SynObj{" +
                "name='" + name + '\'' +
                '}';
    }
}
