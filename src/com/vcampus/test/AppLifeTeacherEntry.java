package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.life.AppLifeTeacher;

import java.awt.*;

public class AppLifeTeacherEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install ();
                AppLifeTeacher app = new AppLifeTeacher();
                app.setVisible(true);
            }
        });
    }
}
