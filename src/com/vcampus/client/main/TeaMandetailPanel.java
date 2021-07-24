package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeaMandetailPanel extends JPanel {
    public JPanel Teadetail=new JPanel();
    public JPanel init(){
        Teadetail.setLayout(null);
        JLabel detail=new JLabel("详细信息");
        detail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        detail.setBounds(0, 0, 80, 30);
        detail.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(detail);

        JLabel detailicon=new JLabel("");
        detailicon.setIcon(new ImageIcon());
        detailicon.setBounds(0,40,80,100);
        Teadetail.add(detailicon);

        JLabel Teaname=new JLabel("姓名");
        Teaname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaname.setBounds(100, 10, 80, 30);
        Teaname.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(Teaname);
        JTextField txtname = new JTextField();    //创建文本框
        txtname.setText("姓名");
        txtname.setBounds(190, 10, 100, 30);
        Teadetail.add(txtname);
        JLabel cardnumber=new JLabel("一卡通号");
        cardnumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        cardnumber.setBounds(100, 40, 80, 30);
        cardnumber.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(cardnumber);
        JTextField txtcard = new JTextField();    //创建文本框
        txtcard.setText("一卡通号");
        txtcard.setBounds(190, 40, 100, 30);
        Teadetail.add(txtcard);
        JLabel Sex=new JLabel("性别");
        Sex.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Sex.setBounds(100,70 , 80, 30);
        Sex.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(Sex);
        JTextField txtSex = new JTextField();    //创建文本框
        txtSex.setText("性别");
        txtSex.setBounds(190, 70, 100, 30);
        Teadetail.add(txtSex);
        JLabel Teaacademy=new JLabel("学院");
        Teaacademy.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaacademy.setBounds(100, 100, 80, 30);
        Teaacademy.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(Teaacademy);
        JTextField txtacademy = new JTextField();    //创建文本框
        txtacademy.setText("学院");
        txtacademy.setBounds(190, 100, 100, 30);
        Teadetail.add(txtacademy);
        JLabel Tealevel=new JLabel("职称");
        Tealevel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Tealevel.setBounds(100, 130, 90, 30);
        Tealevel.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(Tealevel);
        JTextField txtlevel = new JTextField();    //创建文本框
        txtlevel.setText("职称");
        txtlevel.setBounds(190, 130, 100, 30);
        Teadetail.add(txtlevel);
        JLabel bodynumber=new JLabel("身份证号");
        bodynumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        bodynumber.setBounds(300, 10, 150, 30);
        bodynumber.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(bodynumber);
        JTextField txtbodynumber = new JTextField();    //创建文本框
        txtbodynumber.setText("身份证号");
        txtbodynumber.setBounds(460, 10, 100, 30);
        Teadetail.add(txtbodynumber);
        JLabel TeaBirth=new JLabel("出生日期");
        TeaBirth.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        TeaBirth.setBounds(300, 40, 150, 30);
        TeaBirth.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(TeaBirth);
        JTextField txtBirth = new JTextField();    //创建文本框
        txtBirth.setText("出生日期");
        txtBirth.setBounds(460, 40, 100, 30);
        Teadetail.add(txtBirth);
        JLabel Teaemail=new JLabel("邮箱");
        Teaemail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaemail.setBounds(300, 70, 150, 30);
        Teaemail.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(Teaemail);
        JTextField txtemail = new JTextField();    //创建文本框
        txtemail.setText("邮箱");
        txtemail.setBounds(460, 70, 100, 30);
        Teadetail.add(txtemail);
        JLabel selfEntry=new JLabel("个人主页链接");
        selfEntry.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        selfEntry.setBounds(300, 100, 150, 30);
        selfEntry.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(selfEntry);
        JTextField txtEntry = new JTextField();    //创建文本框
        txtEntry.setText("个人主页链接");
        txtEntry.setBounds(460, 100, 100, 30);
        Teadetail.add(txtEntry);
        JLabel phone=new JLabel("电话");
        phone.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        phone.setBounds(300, 130, 150, 30);
        phone.setBorder(new EmptyBorder(0,0,0,0));
        Teadetail.add(phone);
        JTextField txtphone = new JTextField();    //创建文本框
        txtphone.setText("电话");
        txtphone.setBounds(460, 130, 100, 30);
        Teadetail.add(txtphone);

        JButton edit = new JButton("启动编辑");
        edit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        edit.setBounds(600, 10, 200, 30);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Teadetail.add(edit);

        JButton save = new JButton("保存");
        save.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        save.setBounds(600, 50, 200, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Teadetail.add(save);

        JButton Teadelete = new JButton("删除该条教师信息");
        Teadelete.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teadelete.setBounds(600, 90, 200, 30);
        Teadelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Teadetail.add(Teadelete);
        return Teadetail;
    }
}
