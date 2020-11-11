package com.zgwzhhj.test;

public class sushu {
    public static void main(String[] args) {
        int m, n;

        for (m = 3; m < 20; m++) {
            for (n = 2; n < m; n++) {
                if (m % n == 0) {
                    break;
                }
            }
            if (n >= m) {
                System.out.println(" %d ," + n);

            }

        }
    }
}
