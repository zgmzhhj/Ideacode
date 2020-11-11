package com.zgwzhhj.designpattern.pattern0;

public class client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User u1 = new User("u1", "a1", gate);
        User u2 = new User("u2", "a2", gate);
        User u3 = new User("u3", "a3", gate);

        u1.start();
        u2.start();
        u3.start();
    }
}
