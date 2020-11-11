package com.zgwzhhj.designpattern.pattern9;

public class QuaryFromDBAction {
    public void execute(Context context) {
        try {
            Thread.sleep(1000);
            String name = "chen";
            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
