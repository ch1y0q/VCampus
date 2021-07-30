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

    /**
     * 转换字节为16进制字串
     *
     * @param b 字节
     * @return 16进制字串
     */
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
        // examples
        System.out.println(MD5EncodeSalted("111", ""));//698d51a19d8a121ce581499d7b701668
        System.out.println(MD5EncodeSalted("123", ""));//202cb962ac59075b964b07152d234b70
        System.out.println(MD5EncodeSalted("222", ""));//bcbe3365e6ac95ea2c0343a2395834dd
        System.out.println(MD5EncodeSalted("333", ""));//310dcbbf4cce62f762a2aaa148d556bd
        System.out.println(MD5EncodeSalted("444", ""));//550a141f12de6341fba65b0ad0433500
        System.out.println(MD5EncodeSalted("555", ""));//15de21c670ae7c3f6f3f1f37029303c9
        System.out.println(MD5EncodeSalted("666", ""));//fae0b27c451c728867a567e8c1bb4e53
    }

}
