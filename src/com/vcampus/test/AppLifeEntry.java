package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.AppLife;

import java.awt.*;

public class AppLifeEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install ();
                AppLife app = new AppLife();
                app.setVisible(true);
            }
        });
    }

}
