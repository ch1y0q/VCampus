package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.teacher.AppTeacher;

import java.awt.*;

public class AppTeacherEntry {
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install ();
                AppTeacher app = new AppTeacher();
                app.setVisible(true);
            }
        });
    }
}
