package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class StuCoursePanel extends JPanel {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
    public JPanel jPanel=new JPanel();
    public JPanel init()
    {
        jPanel.setLayout(null);
        jPanel.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
        JLabel lblCI1 = new JLabel(res.getString("no_course")); //1-2
        lblCI1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCI1.setBounds(70, 10, 222, 30);
        jPanel.add(lblCI1);
        JLabel lblCI2 = new JLabel(res.getString("no_course"));//3-4
        lblCI2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCI2.setBounds(70, 40, 222, 30);
        jPanel.add(lblCI2);
        JLabel lblCI3 = new JLabel(res.getString("no_course"));//5-6
        lblCI3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCI3.setBounds(70, 70, 222, 30);
        jPanel.add(lblCI3);
        JLabel lblCI4 = new JLabel(res.getString("no_course"));//7-8
        lblCI4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCI4.setBounds(70, 100, 222, 30);
        jPanel.add(lblCI4);
        JLabel lblCI5 = new JLabel(res.getString("no_course"));//9-10
        lblCI5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCI5.setBounds(70, 130, 222, 30);
        jPanel.add(lblCI5);

        JLabel[] lblCourses = new JLabel[]{lblCI1, lblCI2, lblCI3, lblCI4, lblCI5};

        JLabel lblNewLabel_3 = new JLabel("1~2节");
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(0, 10, 64, 30);
        jPanel.add(lblNewLabel_3);

        JLabel label_6 = new JLabel("3~4节");
        label_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_6.setBounds(0, 40, 64, 30);
        jPanel.add(label_6);

        JLabel label_7 = new JLabel("6~7节");
        label_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_7.setBounds(0, 70, 64, 30);
        jPanel.add(label_7);
        JLabel label_8 = new JLabel("8~9节");
        label_8.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_8.setBounds(0, 100, 64, 30);
        jPanel.add(label_8);

        JLabel label_9 = new JLabel("11~12节");
        label_9.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_9.setBounds(0, 130, 64, 30);
        jPanel.add(label_9);
        return jPanel;
    }
}
