package com.vcampus.client.main.Student;

import com.vcampus.UI.myJLabel;

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
        setBorder(new LineBorder(new Color(135, 206, 250), 3, true));
        lblCI1 = new JLabel(res.getString("no_course")); //1-2
        lblCI1.setFont(new Font("宋体", Font.PLAIN, 15));
        lblCI1.setBounds(140, 30, 222, 30);
        add(lblCI1);
        lblCI2 = new JLabel(res.getString("no_course"));//3-4
        lblCI2.setFont(new Font("宋体", Font.PLAIN, 15));
        lblCI2.setBounds(140, 60, 222, 30);
        add(lblCI2);
        lblCI3 = new JLabel(res.getString("no_course"));//6-7
        lblCI3.setFont(new Font("宋体", Font.PLAIN, 15));
        lblCI3.setBounds(140, 90, 222, 30);
        add(lblCI3);
        lblCI4 = new JLabel(res.getString("no_course"));//8-9
        lblCI4.setFont(new Font("宋体", Font.PLAIN, 15));
        lblCI4.setBounds(140, 120, 222, 30);
        add(lblCI4);
        lblCI5 = new JLabel(res.getString("no_course"));//11-12
        lblCI5.setFont(new Font("宋体", Font.PLAIN, 15));
        lblCI5.setBounds(140, 150, 222, 30);
        add(lblCI5);

        JLabel[] lblCourses = new JLabel[]{lblCI1, lblCI2, lblCI3, lblCI4, lblCI5};

        JLabel lblNewLabel_3 = new JLabel("1~2节");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(20, 30, 64, 30);
        add(lblNewLabel_3);

        JLabel label_6 = new JLabel("3~4节");
        label_6.setFont(new Font("宋体", Font.PLAIN, 15));
        label_6.setBounds(20, 60, 64, 30);
        add(label_6);

        JLabel label_7 = new JLabel("6~7节");
        label_7.setFont(new Font("宋体", Font.PLAIN, 15));
        label_7.setBounds(20, 90, 64, 30);
        add(label_7);
        JLabel label_8 = new JLabel("8~9节");
        label_8.setFont(new Font("宋体", Font.PLAIN, 15));
        label_8.setBounds(20, 120, 64, 30);
        add(label_8);

        JLabel label_9 = new JLabel();
        label_9.setText("11-13节");
        label_9.setFont(new Font("宋体", Font.PLAIN, 15));
        label_9.setBounds(20, 150, 64, 30);
        add(label_9);
    }
    public void init()
    {
        lblCI1.setText("校企实训");
        lblCI2.setText("校企实训");
        lblCI3.setText("校企实训");
        lblCI4.setText("校企实训");
        lblCI5.setText("校企实训");
    }
}
