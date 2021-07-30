package com.vcampus.client.main.student;

import com.vcampus.client.main.App;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
/**
 * 学生信息相关面板
 * @author Xiao Kaijie
 * @date 2021-07-20
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
        setBorder(new LineBorder(new Color(135, 206, 250), 3, true));
        setLayout(null);

        JLabel label = new JLabel("姓名：");
        label.setBounds(18, 23, 72, 18);
        label.setFont(new Font("宋体", Font.PLAIN, 15));
        add(label);

        JLabel label_1 = new JLabel("一卡通号：");
        label_1.setBounds(18, 54, 84, 18);
        label_1.setFont(new Font("宋体", Font.PLAIN, 15));
        add(label_1);

        JLabel label_2 = new JLabel("学号：");
        label_2.setBounds(18, 85, 72, 18);
        label_2.setFont(new Font("宋体", Font.PLAIN, 15));
        add(label_2);

        JLabel label_3 = new JLabel("院系：");
        label_3.setBounds(18, 116, 72, 18);
        label_3.setFont(new Font("宋体", Font.PLAIN, 15));
        add(label_3);

        JLabel label_4 = new JLabel("一卡通余额：");
        label_4.setBounds(18, 147, 104, 18);
        label_4.setFont(new Font("宋体", Font.PLAIN, 15));
        add(label_4);

        JLabel label_5 = new JLabel("已借书数：");
        label_5.setBounds(18, 178, 104, 18);
        label_5.setFont(new Font("宋体", Font.PLAIN, 15));
        add(label_5);

        lblName = new JLabel("...");
        lblName.setBounds(124, 23, 149, 18);
        lblName.setFont(new Font("宋体", Font.PLAIN, 15));
        add(lblName);

        lblCardNumber = new JLabel("...");
        lblCardNumber.setBounds(124, 54, 72, 18);
        lblCardNumber.setFont(new Font("宋体", Font.PLAIN, 15));
        add(lblCardNumber);

        lblStudentNumber = new JLabel("...");
        lblStudentNumber.setBounds(124, 85, 149, 18);
        lblStudentNumber.setFont(new Font("宋体", Font.PLAIN, 15));
        add(lblStudentNumber);

        lblAcademy = new JLabel("...");
        lblAcademy.setBounds(124, 116, 180, 18);
        lblAcademy.setFont(new Font("宋体", Font.PLAIN, 15));
        add(lblAcademy);

        lblBalance = new JLabel("...");
        lblBalance.setBounds(124, 147, 97, 18);
        lblBalance.setFont(new Font("宋体", Font.PLAIN, 15));
        add(lblBalance);

        lblBookLend = new JLabel("...");
        lblBookLend.setBounds(124, 178, 72, 18);
        lblBookLend.setFont(new Font("宋体", Font.PLAIN, 15));
        add(lblBookLend);
    }

    public void init()
    {
        lblName.setText(App.session.getStudent().getName());
        lblCardNumber.setText(App.session.getStudent().getCardNumber());
        lblStudentNumber.setText(App.session.getStudent().getStudentNumber());
        lblAcademy.setText(App.session.getStudent().getSchoolByNumber());
        lblBalance.setText(String.valueOf(App.session.getStudent().getBalance()));
        lblBookLend.setText("2");
    }
}
