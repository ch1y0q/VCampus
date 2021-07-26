package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.TeaManage;

import java.awt.*;

public class TeaManageEntry {
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WebLookAndFeel.install ();
                TeaManage app = new TeaManage();
                app.setVisible(true);
            }
        });
    }
}
