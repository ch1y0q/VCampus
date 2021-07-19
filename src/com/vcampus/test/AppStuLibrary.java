package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.StuLibrary;

/**
 * @author Dong Ruojing
 * @date 2021/7/18
 * 图书馆界面测试
 */
public class AppStuLibrary {
    public static void main(String[]args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install ();
                StuLibrary app = new StuLibrary();
                app.setVisible(true);
            }
        });
    }
}
