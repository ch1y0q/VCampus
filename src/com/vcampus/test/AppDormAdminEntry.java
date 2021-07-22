package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.AppDormAdmin;

import java.awt.*;

public class AppDormAdminEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install ();
                AppDormAdmin app = new AppDormAdmin();
                app.setVisible(true);
            }
        });
    }
}
