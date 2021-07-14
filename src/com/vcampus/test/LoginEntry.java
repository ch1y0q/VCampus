package com.vcampus.test;

import com.vcampus.client.LoginUI;
import com.vcampus.client.main.AppStudent;

import java.awt.*;

public class LoginEntry {
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginUI app = new LoginUI();
                app.setVisible(true);
            }
        });
    }
}
