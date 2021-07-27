package com.vcampus.client.main.dailyReport;

import com.vcampus.client.main.manager.ManCategory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * 管理员接受每日健康上报界面
 * @author Dong Ruojing
 * @date 2021/7/27
 */
public class AppDailyReportManage extends JFrame{
    private JPanel contentPane;
    private int width = 1151;
    private int height = 800;

    public AppDailyReportManage()
    {
        setResizable(true);//允许窗口大小更改
        setTitle("每日上报查看");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTree jt= new ManCategory().init();
        jt.setBounds(0,50,200,600);
        contentPane.add(jt);//设置目录

        //绘制panel
        DailyReportManagePanel jplDailyReportManage =new DailyReportManagePanel();
        jplDailyReportManage.setBounds(300,70,1300,600);
        contentPane.add(jplDailyReportManage);



 }
}
