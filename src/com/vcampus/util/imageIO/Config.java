package com.vcampus.util.imageIO;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Dong Ruojing
 * @date 2021/7/27
 */
public class Config {

    public Config(){
        InetAddress addr;
        String IP = null;
        try {
            addr = InetAddress.getLocalHost();
            IP = addr.getHostAddress().toString();// 获得本机IP
            System.out.println(IP);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        MessageForImage.IP=IP;
    }
}
