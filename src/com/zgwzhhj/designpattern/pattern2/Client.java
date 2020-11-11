package com.zgwzhhj.designpattern.pattern2;

public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User cj = new User("cj", "sx", gate);
        User zj = new User("zj", "ax", gate);
        User sj = new User("sj", "sx", gate);

        sj.start();
        zj.start();
        sj.start();

    }
}
