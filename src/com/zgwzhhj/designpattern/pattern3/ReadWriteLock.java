package com.zgwzhhj.designpattern.pattern3;

public class ReadWriteLock {
    private int readingReaders = 0;   //读操作的线程数
    private int waitingReaders = 0;   //等待读的线程数
    private int writingWrites = 0;      //正在写的线程数（最多一个）
    private int waitingWrite = 0;     //等待写的线程数
    private boolean preferWrite = true;

    public ReadWriteLock() {

    }

    public synchronized void readLock() throws InterruptedException {
        this.waitingReaders++;
        try {
            while (writingWrites > 0) {
                this.wait();
            }
            this.readingReaders++;
        } finally {
            waitingReaders--;
        }
    }

    public synchronized void readUnlock() {
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        this.waitingWrite++;
        try {
            while (readingReaders > 0 || writingWrites > 0) {
                this.wait();
            }
            this.writingWrites--;
        } finally {
            this.waitingWrite--;
        }
    }

    public synchronized void writeUnlock() {
        this.writingWrites--;
        this.notifyAll();
    }


}
