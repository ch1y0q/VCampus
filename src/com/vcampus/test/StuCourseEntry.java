package com.vcampus.test;

import com.vcampus.client.main.AppCourse;

import java.awt.*;

public class StuCourseEntry {
    public static void main(String args[]){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppCourse app = new AppCourse();
            }
        });
    }
}
