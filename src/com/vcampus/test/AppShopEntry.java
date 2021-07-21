package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.AppShop;

import java.awt.*;

public class AppShopEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install ();
                AppShop app = new AppShop();
                app.setVisible(true);
            }
        });
    }
}
