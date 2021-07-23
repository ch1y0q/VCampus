package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.AppStudent;
//import com.vcampus.server.App;

import java.awt.*;

public class AppStudentEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install ();
                AppStudent app = new AppStudent();
                app.setVisible(true);
            }
        });
    }
}
