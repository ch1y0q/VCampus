package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Xiao Kaijie
 * @date 2021-07-13
 */

public class StudetailInfo extends JPanel {
    public JLabel detailicon;
    public JTextField txtname;
    public JTextField txtcard;
    public JTextField txtSex;
    public JTextField txtacademy;
    public JTextField Stunum;
    public JTextField StuClass1;
    public JTextField txtbodynumber;
    public JTextField txtBirth;
    public JTextField txtemail;
    public JTextField txtEntry;
    public JTextField txtphone;
    public StudetailInfo()
    {
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        JLabel detail=new JLabel("详细信息");
        detail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        detail.setBounds(0, 0, 80, 30);
        detail.setBorder(new EmptyBorder(0,0,0,0));
        add(detail);

        detailicon=new JLabel("");
        detailicon.setIcon(new ImageIcon());
        detailicon.setBounds(0,40,80,100);
        add(detailicon);

        JLabel Teaname=new JLabel("姓名");
        Teaname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaname.setBounds(100, 10, 80, 30);
        Teaname.setBorder(new EmptyBorder(0,0,0,0));
        add(Teaname);
        txtname = new JTextField();    //创建文本框
        txtname.setText("姓名");
        txtname.setBounds(190, 10, 100, 30);
        add(txtname);
        JLabel cardnumber=new JLabel("一卡通号");
        cardnumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        cardnumber.setBounds(100, 40, 80, 30);
        cardnumber.setBorder(new EmptyBorder(0,0,0,0));
        add(cardnumber);
        txtcard = new JTextField();    //创建文本框
        txtcard.setText("一卡通号");
        txtcard.setBounds(190, 40, 100, 30);
        add(txtcard);
        JLabel Sex=new JLabel("性别");
        Sex.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Sex.setBounds(100,70 , 80, 30);
        Sex.setBorder(new EmptyBorder(0,0,0,0));
        add(Sex);
        txtSex = new JTextField();    //创建文本框
        txtSex.setText("性别");
        txtSex.setBounds(190, 70, 100, 30);
        add(txtSex);
        JLabel Teaacademy=new JLabel("学院");
        Teaacademy.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaacademy.setBounds(100, 100, 80, 30);
        Teaacademy.setBorder(new EmptyBorder(0,0,0,0));
        add(Teaacademy);
        txtacademy = new JTextField();    //创建文本框
        txtacademy.setText("学院");
        txtacademy.setBounds(190, 100, 100, 30);
        add(txtacademy);
        JLabel Stunumber=new JLabel("学号");
        Stunumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Stunumber.setBounds(100, 130, 90, 30);
        Stunumber.setBorder(new EmptyBorder(0,0,0,0));
        add(Stunumber);
        Stunum = new JTextField();    //创建文本框
        Stunum.setText("学号");
        Stunum.setBounds(190, 130, 100, 30);
        add(Stunum);
        JLabel StuClass=new JLabel("班级");
        StuClass.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        StuClass.setBounds(100, 160, 90, 30);
        StuClass.setBorder(new EmptyBorder(0,0,0,0));
        add(StuClass);
        StuClass1 = new JTextField();    //创建文本框
        StuClass1.setText("班级");
        StuClass1.setBounds(190, 160, 100, 30);
        add(StuClass1);
        JLabel bodynumber=new JLabel("身份证号");
        bodynumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        bodynumber.setBounds(300, 10, 150, 30);
        bodynumber.setBorder(new EmptyBorder(0,0,0,0));
        add(bodynumber);
        txtbodynumber = new JTextField();    //创建文本框
        txtbodynumber.setText("身份证号");
        txtbodynumber.setBounds(460, 10, 100, 30);
        add(txtbodynumber);
        JLabel TeaBirth=new JLabel("出生日期");
        TeaBirth.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        TeaBirth.setBounds(300, 40, 150, 30);
        TeaBirth.setBorder(new EmptyBorder(0,0,0,0));
        add(TeaBirth);
        txtBirth = new JTextField();    //创建文本框
        txtBirth.setText("出生日期");
        txtBirth.setBounds(460, 40, 100, 30);
        add(txtBirth);
        JLabel Teaemail=new JLabel("邮箱");
        Teaemail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaemail.setBounds(300, 70, 150, 30);
        Teaemail.setBorder(new EmptyBorder(0,0,0,0));
        add(Teaemail);
        txtemail = new JTextField();    //创建文本框
        txtemail.setText("邮箱");
        txtemail.setBounds(460, 70, 100, 30);
        add(txtemail);
        JLabel zhuanye=new JLabel("专业");
        zhuanye.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        zhuanye.setBounds(300, 100, 150, 30);
        zhuanye.setBorder(new EmptyBorder(0,0,0,0));
        add(zhuanye);
        txtEntry = new JTextField();    //创建文本框
        txtEntry.setText("专业");
        txtEntry.setBounds(460, 100, 100, 30);
        add(txtEntry);
        JLabel phone=new JLabel("电话");
        phone.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        phone.setBounds(300, 130, 150, 30);
        phone.setBorder(new EmptyBorder(0,0,0,0));
        add(phone);
        txtphone = new JTextField();    //创建文本框
        txtphone.setText("电话");
        txtphone.setBounds(460, 130, 100, 30);
        add(txtphone);

        JButton edit = new JButton("启动编辑");
        edit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        edit.setBounds(600, 10, 200, 30);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(edit);

        JButton save = new JButton("保存");
        save.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        save.setBounds(600, 50, 200, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(save);

        JButton Studelete = new JButton("删除该条学生信息");
        Studelete.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Studelete.setBounds(600, 90, 200, 30);
        Studelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(Studelete);
    }
    public void init(){

    }
    public void edit(){

    }
    public void save(){

    }
    public void deleteStu(){

    }
}
