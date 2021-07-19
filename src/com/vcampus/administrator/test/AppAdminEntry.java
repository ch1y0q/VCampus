package com.vcampus.administrator.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.administrator.main.AppAdmin;

/**
 * 管理员登录界面测试
 * @author Dong Ruojing
 * @date 2021/7/16
 */
public class AppAdminEntry {
    public static void main(String[]args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install ();
                AppAdmin app = new AppAdmin();
                app.setVisible(true);
            }
        });
    }


}
