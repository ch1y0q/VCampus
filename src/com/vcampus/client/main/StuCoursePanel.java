package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class StuCoursePanel extends JPanel {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
    public JLabel lblCI1;
    public JLabel lblCI2;
    public JLabel lblCI3;
    public JLabel lblCI4;
    public JLabel lblCI5;
    public StuCoursePanel()
    {
        setLayout(null);
        setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
        lblCI1 = new JLabel(res.getString("no_course")); //1-2
        lblCI1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCI1.setBounds(70, 10, 222, 30);
        add(lblCI1);
        lblCI2 = new JLabel(res.getString("no_course"));//3-4
        lblCI2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCI2.setBounds(70, 40, 222, 30);
        add(lblCI2);
        lblCI3 = new JLabel(res.getString("no_course"));//6-7
        lblCI3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCI3.setBounds(70, 70, 222, 30);
        add(lblCI3);
        lblCI4 = new JLabel(res.getString("no_course"));//8-9
        lblCI4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCI4.setBounds(70, 100, 222, 30);
        add(lblCI4);
        lblCI5 = new JLabel(res.getString("no_course"));//11-12
        lblCI5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCI5.setBounds(70, 130, 222, 30);
        add(lblCI5);

        JLabel[] lblCourses = new JLabel[]{lblCI1, lblCI2, lblCI3, lblCI4, lblCI5};

        JLabel lblNewLabel_3 = new JLabel("1~2节");
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(0, 10, 64, 30);
        add(lblNewLabel_3);

        JLabel label_6 = new JLabel("3~4节");
        label_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_6.setBounds(0, 40, 64, 30);
        add(label_6);

        JLabel label_7 = new JLabel("6~7节");
        label_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_7.setBounds(0, 70, 64, 30);
        add(label_7);
        JLabel label_8 = new JLabel("8~9节");
        label_8.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_8.setBounds(0, 100, 64, 30);
        add(label_8);

        JLabel label_9 = new JLabel("11~12节");
        label_9.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_9.setBounds(0, 130, 64, 30);
        add(label_9);
    }
    public void init()
    {

    }
}
