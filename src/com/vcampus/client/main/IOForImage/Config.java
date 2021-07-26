package com.vcampus.client.main.IOForImage;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vcampus.client.main.IOForImage.MessageForImage;

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
        MessageForImage._IP=IP;
    }
}
