package com.vcampus.client.main.dailyReport;

import com.vcampus.client.main.App;
import com.vcampus.client.main.expandTree;
import com.vcampus.client.main.manager.ManCategory;
import com.vcampus.client.main.student.StuCategory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class AppDailyReport extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
    private JPanel contentPane;
    public AppDailyReport() {
        setResizable(true);
        setTitle(res.getString("student_main"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTree jt= new StuCategory().init();
        jt.setBounds(0,0,200,d.height);
        expandTree.expandTree(jt,true);
        contentPane.add(jt);//设置目录



        DailyReportPanel panel=new DailyReportPanel();
        panel.setBounds(300,20,1300,700);
        contentPane.add(panel);//绘制panel



    }
}
