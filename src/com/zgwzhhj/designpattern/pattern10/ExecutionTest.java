package com.zgwzhhj.designpattern.pattern10;

import com.zgwzhhj.designpattern.pattern9.Context;
import com.zgwzhhj.designpattern.pattern9.QuaryFromDBAction;
import com.zgwzhhj.designpattern.pattern9.QuaryFromHTTPAction;

public class ExecutionTest implements Runnable {

    private QuaryFromDBAction quaryAction = new QuaryFromDBAction();
    private QuaryFromHTTPAction quaryFromHTTPAction = new QuaryFromHTTPAction();

    @Override
    public void run() {
        Context context = ActionContext.getActionContext().getContext();
        quaryAction.execute(context);
        System.out.println("the name is sucessly");
        quaryFromHTTPAction.execute(context);
        System.out.println("From HTTP the name is :" + context.getName() + " and id: " + context.getCardid());

    }
}
