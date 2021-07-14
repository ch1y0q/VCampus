package com.vcampus.test;

import com.vcampus.client.main.AppShop;
import com.vcampus.server.App;

import java.awt.*;

public class AppShopEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppShop app = new AppShop();
                app.setVisible(true);
            }
        });
    }
}
