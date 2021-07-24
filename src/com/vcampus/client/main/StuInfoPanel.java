package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
/**
 * @author Xiao Kaijie
 * @date 2021-07-13
 */
public class StuInfoPanel extends JPanel {
    public JLabel lblName;
    public JLabel lblCardNumber;
    public JLabel lblStudentNumber;
    public JLabel lblAcademy;
    public JLabel lblBalance;
    public JLabel lblBookLend;
    public StuInfoPanel()
    {
        setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
        setLayout(null);

        JLabel label = new JLabel("姓名：");
        label.setBounds(18, 23, 72, 18);
        add(label);

        JLabel label_1 = new JLabel("一卡通号：");
        label_1.setBounds(18, 54, 84, 18);
        add(label_1);

        JLabel label_2 = new JLabel("学号：");
        label_2.setBounds(18, 85, 72, 18);
        add(label_2);

        JLabel label_3 = new JLabel("院系：");
        label_3.setBounds(18, 116, 72, 18);
        add(label_3);

        JLabel label_4 = new JLabel("一卡通余额：");
        label_4.setBounds(18, 147, 104, 18);
        add(label_4);

        JLabel label_5 = new JLabel("图书馆借书：");
        label_5.setBounds(18, 178, 104, 18);
        add(label_5);

        lblName = new JLabel("...");
        lblName.setBounds(104, 23, 149, 18);
        add(lblName);

        lblCardNumber = new JLabel("...");
        lblCardNumber.setBounds(104, 54, 72, 18);
        add(lblCardNumber);

        lblStudentNumber = new JLabel("...");
        lblStudentNumber.setBounds(104, 85, 149, 18);
        add(lblStudentNumber);

        lblAcademy = new JLabel("...");
        lblAcademy.setBounds(104, 116, 149, 18);
        add(lblAcademy);

        lblBalance = new JLabel("...");
        lblBalance.setBounds(104, 147, 97, 18);
        add(lblBalance);

        lblBookLend = new JLabel("...");
        lblBookLend.setBounds(104, 178, 72, 18);
        add(lblBookLend);
    }

    public void init()
    {
        lblName.setText(App.session.getStudent().getName());
        lblCardNumber.setText(App.session.getStudent().getCardNumber());
        lblStudentNumber.setText(App.session.getStudent().getStudentNumber());
        lblAcademy.setText("计算机科学与工程学院");
        lblBalance.setText("123.45");
        lblBookLend.setText("0");
    }
}
