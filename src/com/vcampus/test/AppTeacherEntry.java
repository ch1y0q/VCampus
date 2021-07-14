package com.vcampus.test;

import com.vcampus.client.main.AppStudent;
import com.vcampus.client.main.AppTeacher;

import java.awt.*;

public class AppTeacherEntry {
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppTeacher app = new AppTeacher();
                app.setVisible(true);
            }
        });
    }
}
