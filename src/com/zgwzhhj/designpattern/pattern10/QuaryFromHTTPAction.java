package com.zgwzhhj.designpattern.pattern10;

import com.zgwzhhj.designpattern.pattern9.Context;

public class QuaryFromHTTPAction {
    public void execute() {
        try {
            Thread.sleep(1000);
            Context context = ActionContext.getActionContext().getContext();
            String name = context.getName();
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
