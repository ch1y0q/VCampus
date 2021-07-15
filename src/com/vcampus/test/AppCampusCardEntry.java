package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.AppCampusCard;
import com.vcampus.server.App;

import java.awt.*;

public class AppCampusCardEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install ();
                AppCampusCard app = new AppCampusCard();
                app.setVisible(true);
            }
        });
    }
}
