package com.zgwzhhj.designpattern.pattern15;

import java.io.IOException;

public class AppServerClient {
    public static void main(String[] args) throws IOException {
        AppServer appServer = new AppServer(1234);
        appServer.start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        appServer.shutdown();
    }
}
