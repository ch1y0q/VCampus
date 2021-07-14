package com.vcampus.test;

import com.vcampus.client.main.AppStudent;
import com.vcampus.server.App;

import java.awt.*;

public class AppStudentEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppStudent app = new AppStudent();
                app.setVisible(true);
            }
        });
    }
}
