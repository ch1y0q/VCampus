package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.student.StudentInfo.AppStuInfo;

/**
 * 学生信息界面测试
 * @author Dong Ruojing
 * @date 2021/7/23
 */
public class AppStuInfoEntry {
    public static void main(String[]args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install ();
                AppStuInfo app = new AppStuInfo();
                app.setVisible(true);
            }
        });
    }
}
