package com.zgwzhhj.designpattern.pattern3;

//共享数据
public class ShareData {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public ShareData(int size) {
        buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        try {
            lock.readLock();
            return doRead();
        } finally {
            lock.readUnlock();
        }
    }

    public void write() throws InterruptedException {
        try {
            lock.writeLock();
            doWrite();
        } finally {
            lock.writeUnlock();
        }
    }

    public void doWrite() {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '=';
            slowly(10);
        }
    }

    public char[] doRead() {
        char[] newbuff = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newbuff[i] = buffer[i];
        }
        slowly(50);
        return newbuff;
    }

    public void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
