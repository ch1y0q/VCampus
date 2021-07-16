package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.AppDormitory;

import java.awt.*;

public class AppDormitoryEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install ();
                AppDormitory app = new AppDormitory();
                app.setVisible(true);
            }
        });
    }
}
