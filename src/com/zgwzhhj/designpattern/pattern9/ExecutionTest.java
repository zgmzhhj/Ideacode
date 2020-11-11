package com.zgwzhhj.designpattern.pattern9;

public class ExecutionTest implements Runnable {

    private QuaryFromDBAction quaryAction = new QuaryFromDBAction();
    private QuaryFromHTTPAction quaryFromHTTPAction = new QuaryFromHTTPAction();

    @Override
    public void run() {
        final Context context = new Context();
        quaryAction.execute(context);
        System.out.println("the name is sucessly");
        System.out.println("From DBA the name is :" + context.getName() + " and id: " + context.getCardid());
        quaryFromHTTPAction.execute(context);
        System.out.println("From HTTP the name is :" + context.getName() + " and id: " + context.getCardid());

    }
}
