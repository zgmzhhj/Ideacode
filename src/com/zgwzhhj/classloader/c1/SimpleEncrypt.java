package com.zgwzhhj.classloader.c1;

public class SimpleEncrypt {
    private final static String plain = "hello classloader";

    private static final byte ENCRYPT_FACTOR = (byte) 0xff;

    public static void main(String[] args) {
        byte[] bytes = plain.getBytes();
        byte[] encrypt = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            encrypt[i] = (byte) (bytes[i] ^ ENCRYPT_FACTOR);
        }
        System.out.println("加密");
        System.out.println(new String(encrypt));
        byte[] decrypt = new byte[encrypt.length];
        for (int i = 0; i < bytes.length; i++) {
            decrypt[i] = (byte) (encrypt[i] ^ ENCRYPT_FACTOR);
        }
        System.out.println("解密");
        System.out.println(new String(decrypt));
    }
}
