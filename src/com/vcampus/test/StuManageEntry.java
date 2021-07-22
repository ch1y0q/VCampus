package com.vcampus.test;

import com.vcampus.client.main.StuManage;

import java.awt.*;

public class StuManageEntry {
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                StuManage app = new StuManage();
                app.setVisible(true);
            }
        });
    }
}
