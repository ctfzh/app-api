package com.funbox.project.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
    /**
     * Encrypt with sha 256 string.
     *
     * @param psd the password
     * @return the string
     */
    public static String encryptWithSHA256(String psd) {
        MessageDigest md;
        String outStr;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(psd.getBytes());
            outStr = byteToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return outStr;
    }


    private static String byteToString(byte[] digest) {
        StringBuilder buf = new StringBuilder();
        for (byte aDigest : digest) {
            String tempStr = Integer.toHexString(aDigest & 0xff);
            if (tempStr.length() == 1) {
                buf.append("0").append(tempStr);
            } else {
                buf.append(tempStr);
            }
        }
        return buf.toString().toUpperCase();
    }

    /**
     * Encrypt with md 5 string.
     *
     * @param plainText the plain text
     * @return the string
     */
    public static String encryptWithMD5(String plainText) {
        StringBuilder builder = new StringBuilder("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            for (byte aB : b) {
                i = aB;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    builder.append("0");
                builder.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //32位加密
        return builder.toString().toUpperCase();
        // 16位的加密
        //return builder.toString().substring(8, 24);
    }

    public static void main(String[] args) {
//        String code = encryptWithSHA256("yukaile");
//        System.out.println(code + "----" + code.length());

        String code2 = encryptWithMD5("123456789中文");
        System.out.println(code2 + "----" + code2.length());
    }
}