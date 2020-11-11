package com.zgwzhhj.Thread.Atomic;

public class JITTest {
    private static boolean init = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                while (!init) {
                    System.out.println(".");
                }
                /**等价与
                 * while(true){}
                 */
            }
        }.start();

        Thread.sleep(1000);

        new Thread() {
            @Override
            public void run() {
                init = true;
                System.out.println("set init to true");
            }
        }.start();
    }
}
