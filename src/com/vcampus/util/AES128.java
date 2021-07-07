package com.vcampus.util;

import java.util.Random;

import static java.util.Base64.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 * @Author: Huang Qiyue
 * @Date: 2021-07-09
 * @Description: AES128加解密类
 */

public class AES128 {

    static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     *
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.err.println("Key is null!");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.err.print("Key is not 16 bit!");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(TRANSFORMATION); //"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return getEncoder().encodeToString(encrypted);// 使用Base64再进行一次编码
    }

    /**
     * 解密
     *
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.err.println("Key is null!");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.err.print("Key is not 16 bit!");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = getDecoder().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "utf-8");
                return originalString;
            } catch (Exception e) {
                System.err.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
            return null;
        }
    }

    /**
     * 生成指定长度的密钥（盐）
     *
     * @param n 密钥长度
     * @return
     */
    public static String getCKey(int n) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            String str = random.nextInt(2) % 2 == 0 ? "num" : "char";
            if ("char".equalsIgnoreCase(str)) { // 产生字母
                int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (nextInt + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(str)) { // 产生数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        //String cKey = "1234567890123h56";
        String cKey = getCKey(16);
        System.out.println("密钥：" + cKey);
        // 需要加密的字串
        String cSrc = "This is a message.";
        System.out.println(cSrc);
        // 加密
        String enString = AES128.Encrypt(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String DeString = AES128.Decrypt(enString, cKey);
        System.out.println("解密后的字串是：" + DeString);
    }
}