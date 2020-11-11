package com.zgwzhhj.classloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private final static String DEFAULT_DIR = "D:\\Ideacode\\src\\com\\zgwzhhj\\classloader";

    private String dir = DEFAULT_DIR;

    private String classLoaderName;

    public MyClassLoader() {
        super();
    }

    public MyClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(String classLoaderName, ClassLoader parent) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classpath = name.replace(".", "/");
        File classfile = new File(dir, classpath + ".class");
        if (!classfile.exists()) {
            throw new ClassNotFoundException("the class" + name + "not found ");
        }
        byte[] classByte = loadClass(classfile);
        if (null == classByte || classByte.length == 0) {
            throw new ClassNotFoundException("load the class" + name + "failes ");
        }
        return this.defineClass(name, classByte, 0, classByte.length);
    }

    private byte[] loadClass(File classfile) {
        try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                FileInputStream fis = new FileInputStream(classfile)) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }
}
