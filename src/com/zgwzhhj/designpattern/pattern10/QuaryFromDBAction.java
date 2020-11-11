package com.zgwzhhj.designpattern.pattern10;

import com.zgwzhhj.designpattern.pattern9.Context;

public class QuaryFromDBAction {
    public void execute(Context context) {
        try {
            Thread.sleep(1000);
            String name = "chen";
            ActionContext.getActionContext().getContext().getName();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
