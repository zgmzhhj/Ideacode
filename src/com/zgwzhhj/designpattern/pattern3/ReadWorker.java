package com.zgwzhhj.designpattern.pattern3;

//读操作
public class ReadWorker extends Thread {
    private final ShareData shareData;

    public ReadWorker(ShareData data) {
        this.shareData = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readbuf = shareData.read();
                System.out.println(Thread.currentThread().getName() + " read " + readbuf);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
