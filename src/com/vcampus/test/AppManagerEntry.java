package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.AppManager;

import java.awt.*;

public class AppManagerEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            WebLookAndFeel.install ();
            AppManager app = new AppManager();
            app.setVisible(true);
        }
        });
    }
}
