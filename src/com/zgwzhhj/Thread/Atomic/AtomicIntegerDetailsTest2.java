package com.zgwzhhj.Thread.Atomic;

public class AtomicIntegerDetailsTest2 {

    private final static CompareAndSetLock LOCK = new CompareAndSetLock();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        doSomething();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (GetLockException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

   /* private static void doSomething() throws InterruptedException {
        synchronized (AtomicIntegerDetailsTest2.class) {
            System.out.println(Thread.currentThread().getName() + "get the lock");
            Thread.sleep(100000);
        }
    }*/

    private static void doSomething() throws InterruptedException, GetLockException {
        try {
            LOCK.tryLock();
            System.out.println(Thread.currentThread().getName() + "get the lock");
            Thread.sleep(100000);
        } finally {
            LOCK.unlock();
        }
    }
}
