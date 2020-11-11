package com.zgwzhhj.designpattern.pattern9;

public class QuaryFromHTTPAction {
    public void execute(Context context) {
        try {
            Thread.sleep(1000);
            String name = "jing";
            context.setName(name);
            String cardid = getCardId(name);
            context.setId(cardid);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getCardId(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "464" + Thread.currentThread().getId();
    }
}
