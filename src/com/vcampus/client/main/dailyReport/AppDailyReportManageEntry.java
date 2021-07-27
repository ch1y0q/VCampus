package com.vcampus.client.main.dailyReport;

import com.alee.laf.WebLookAndFeel;
import com.vcampus.client.main.dailyReport.AppDailyReportManage;

/**
 * @author Dong Ruojing
 * @date 2021/7/27
 */
public class AppDailyReportManageEntry {
    public static void main(String[]args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install ();
                AppDailyReportManage app = new AppDailyReportManage();
                app.setVisible(true);
            }
        });
    }
}
