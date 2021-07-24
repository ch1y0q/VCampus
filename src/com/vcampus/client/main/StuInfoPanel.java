package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
/**
 * @author Xiao Kaijie
 * @date 2021-07-13
 */
public class StuInfoPanel extends JPanel {
    public JPanel init()
    {
        JPanel jPanel=new JPanel();
        jPanel.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
        jPanel.setLayout(null);

        JLabel label = new JLabel("姓名：");
        label.setBounds(18, 23, 72, 18);
        jPanel.add(label);

        JLabel label_1 = new JLabel("一卡通号：");
        label_1.setBounds(18, 54, 84, 18);
        jPanel.add(label_1);

        JLabel label_2 = new JLabel("学号：");
        label_2.setBounds(18, 85, 72, 18);
        jPanel.add(label_2);

        JLabel label_3 = new JLabel("院系：");
        label_3.setBounds(18, 116, 72, 18);
        jPanel.add(label_3);

        JLabel label_4 = new JLabel("一卡通余额：");
        label_4.setBounds(18, 147, 104, 18);
        jPanel.add(label_4);

        JLabel label_5 = new JLabel("图书馆借书：");
        label_5.setBounds(18, 178, 104, 18);
        jPanel.add(label_5);

        JLabel lblName = new JLabel("...");
        lblName.setBounds(104, 23, 149, 18);
        jPanel.add(lblName);

        JLabel lblCardNumber = new JLabel("...");
        lblCardNumber.setBounds(104, 54, 72, 18);
        jPanel.add(lblCardNumber);

        JLabel lblStudentNumber = new JLabel("...");
        lblStudentNumber.setBounds(104, 85, 149, 18);
        jPanel.add(lblStudentNumber);

        JLabel lblAcademy = new JLabel("...");
        lblAcademy.setBounds(104, 116, 149, 18);
        jPanel.add(lblAcademy);

        JLabel lblBalance = new JLabel("...");
        lblBalance.setBounds(104, 147, 97, 18);
        jPanel.add(lblBalance);

        JLabel lblBookLend = new JLabel("...");
        lblBookLend.setBounds(104, 178, 72, 18);
        jPanel.add(lblBookLend);

        return jPanel;
    }
}
