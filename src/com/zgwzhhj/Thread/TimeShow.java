package com.zgwzhhj.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeShow {

    public static void main(String[] args) {

        //final Exchanger<String> exchanger = new Exchanger<String>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (true) {
            System.out.println(df.format(new Date()));
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
