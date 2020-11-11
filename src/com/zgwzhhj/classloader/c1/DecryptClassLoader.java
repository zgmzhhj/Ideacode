package com.zgwzhhj.classloader.c1;

import java.io.*;

public class DecryptClassLoader extends ClassLoader {

    private final static String DEFAULT_DIR = "D:\\classLoader";

    private String dir = DEFAULT_DIR;

    public DecryptClassLoader() {
        super();
    }

    public DecryptClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classpath = name.replace(",", "/");
        File classFile = new File(dir, classpath + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException("the class" + name + " not found" + dir);
        }
        byte[] classbyte = loadClassByte(classFile);
        if (null == classbyte || classbyte.length == 0) {
            throw new ClassNotFoundException("load the class" + name + "failed");
        }
        return this.defineClass(name, classbyte, 0, classbyte.length);
    }

    private byte[] loadClassByte(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(classFile)) {
            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data ^ EncryptUtils.ENCRYPT_FACTOR);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

}
