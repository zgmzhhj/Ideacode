package com.zgwzhhj.designpattern.pattern0;

public class User extends Thread {
    private String myname;

    private final String myaddress;

    private final Gate gate;

    public User(String myname, String myaddress, Gate gate) {
        this.myname = myname;
        this.myaddress = myaddress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myname + "BEGIN");
        while (true) {
            this.gate.pass(myname, myaddress);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
