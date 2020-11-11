package com.zgwzhhj.designpattern.pattern3;

import java.util.Random;

//写操作
public class WriteWorker extends Thread {
    private final static Random random = new Random(System.currentTimeMillis());

    private final ShareData shareData;

    private final String filler;

    private int index = 0;

    public WriteWorker(ShareData shareData, String filler) {
        this.shareData = shareData;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                System.out.println(Thread.currentThread().getName() + " Writer " + c);
                shareData.write();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.charAt(index)) ;
        index = 0;
        return c;
    }
}
