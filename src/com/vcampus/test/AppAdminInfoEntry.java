package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.manager.AdminInfoPanel;
import com.vcampus.client.main.manager.AppAdminInfoFrame;

/**
 * @author Dong Ruojing
 * @date 2021/7/18
 */
public class AppAdminInfoEntry {
    public static void main(String[]args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install ();
                AppAdminInfoFrame app = new AppAdminInfoFrame();
                app.setVisible(true);
            }
        });
    }
}
