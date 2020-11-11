package com.zgwzhhj.Thread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;


public class CompareAndSetLock {

    private final AtomicInteger value = new AtomicInteger();

    private Thread LockedThread;

    public void tryLock() throws GetLockException {
        boolean success = value.compareAndSet(0, 1);
        if (!success) {
            throw new GetLockException("get the lock failed ");
        } else
            LockedThread = Thread.currentThread();

    }

    public void unlock() {
        if (0 == value.get()) {
            return;
        }
        if (LockedThread == Thread.currentThread())
            value.compareAndSet(1, 0);
    }
}
