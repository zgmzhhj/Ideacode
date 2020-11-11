package com.zgwzhhj.classloader;

public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader("myClassLoader");
        Class<?> aClass = myClassLoader.loadClass("com.zgwzhhj.classloader.MyObject");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());


    }
}
