package com.zgwzhhj.designpattern.pattern3;

public class ReadWriteClient {
    public static void main(String[] args) {
        final ShareData shareData = new ShareData(10);


        new WriteWorker(shareData, "qwertyuiop").start();

        new ReadWorker(shareData).start();


    }
}
