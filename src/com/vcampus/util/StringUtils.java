package com.vcampus.util;

import java.security.MessageDigest;

/**
 * 包含一些与字符串处理相关的方法
 *
 * @author Huang Qiyue
 * @date 2021-07-12
 */

public class StringUtils {
    /* 定义十六进制字符 */
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 转换字节数组为16进制字串
     *
     * @param b 字节数组
     * @return 16进制字串
     */

    public static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * MD5加密
     *
     * @param origin 明文
     * @return MD5加密后的密文
     */
    public static String MD5Encode(String origin) {
        assert (origin != null);
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return resultString;
    }

    /**
     * MD5加密，加盐版本
     *
     * @param origin 明文
     * @param salt   盐
     * @return MD5加密后的密文
     */
    public static String MD5EncodeSalted(String origin, String salt) {
        assert (origin != null);
        String resultString = null;
        try {
            if (salt == null) {
                salt = "";
            }
            resultString = new String(origin + salt);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(MD5EncodeSalted("123", ""));
    }
}
