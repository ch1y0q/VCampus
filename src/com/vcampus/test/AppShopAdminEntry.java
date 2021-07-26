package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.shop.AppShopAdmin;

import java.awt.*;

public class AppShopAdminEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install ();
                AppShopAdmin app = new AppShopAdmin();
                app.setVisible(true);
            }
        });
    }
}
