package com.zgwzhhj.Thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class Simple {
        private long i = 0;

        public Simple(long i) {
            this.i = 1;
            System.out.println("==========");
        }

        public long getI() {
            return i;
        }
    }

    public static void main(String[] args) throws InstantiationException {
//        Simple simple = new Simple(1);
//        System.out.println(simple.getI());
        Unsafe unsafe = getUnsafe();
        Simple simple = (Simple) unsafe.allocateInstance(Simple.class);
        System.out.println(simple.getI());
    }
}
