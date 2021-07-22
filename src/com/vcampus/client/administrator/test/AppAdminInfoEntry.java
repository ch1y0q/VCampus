package com.vcampus.client.administrator.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.administrator.main.AppAdminInfo;

/**
 * @author Dong Ruojing
 * @date 2021/7/18
 */
public class AppAdminInfoEntry {
    public static void main(String[]args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install ();
                AppAdminInfo app = new AppAdminInfo();
                app.setVisible(true);
            }
        });
    }
}
