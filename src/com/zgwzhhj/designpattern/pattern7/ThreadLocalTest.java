package com.zgwzhhj.designpattern.pattern7;

public class ThreadLocalTest {
    //ThreadLocal是线程安全的
    //Theradlocal 使用map存储key key值为Thread.currentThread()
    private static ThreadLocal threadLocal = new ThreadLocal() {
        //设置默认值
        @Override
        protected Object initialValue() {
            return "chen";
        }
    };

    //Thread1不能访问Thread2的ThreadLoacl
    public static void main(String[] args) throws InterruptedException {
        // threadLocal.set("chen");
        //如果没有赋值则为null
        Thread.sleep(100);
        System.out.println(threadLocal.get());
    }
}
