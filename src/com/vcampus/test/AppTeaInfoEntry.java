package com.vcampus.test;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.teacher.TeacherInfo.AppTeaInfo;

/**
 * 教师信息界面测试
 * @author Dong Ruojing
 * @date 2021/7/23
 */
public class AppTeaInfoEntry {
    public static void main(String[]args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install ();
                AppTeaInfo app = new AppTeaInfo();
                app.setVisible(true);
            }
        });
    }
}
