package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.AppServer;

/**
 * @author Dong Ruojing
 * @date 2021/7/16
 */
public class AppServerEntry {
    public static void main(String[]args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install ();
                AppServer app = new AppServer();
                app.setVisible(true);
            }
        });
    }


}
