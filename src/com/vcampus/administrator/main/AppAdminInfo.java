package com.vcampus.administrator.main;

import javax.swing.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 管理员个人信息界面
 * @author Dong Ruojing
 * @date 2021/7/18
 */
public class AppAdminInfo  extends JFrame {
    private JPanel contentPane;

    public AppAdminInfo() {
        setResizable(false);//允许窗口大小更改，建议不更改
        setTitle("个人信息管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 800, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton returnButton = new JButton("← 返回");
        returnButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        returnButton.setBounds(10,5,80,30);
        returnButton.setForeground(new Color(33, 117, 206,100));
        contentPane.add(returnButton);

        JButton LogoutButton = new JButton("登出");
        LogoutButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        LogoutButton.setBounds(720,5,50,30);
        LogoutButton.setForeground(new Color(33, 117, 206,100));
        contentPane.add(LogoutButton);

        JButton EditButton = new JButton("启动编辑");
        EditButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        EditButton.setBounds(610,450,80,30);
        EditButton.setForeground(new Color(58, 51, 168,100));
        contentPane.add(EditButton);

        JButton LoadPortraitButton = new JButton("上传头像");
        LoadPortraitButton.setFont(new Font("微软雅黑", Font.BOLD, 10));
        LoadPortraitButton.setBounds(280,250,60,25);
        LoadPortraitButton.setForeground(new Color(58, 51, 168,100));
        contentPane.add(LoadPortraitButton);

        JButton SaveButton = new JButton("保存");
        SaveButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        SaveButton.setBounds(700,450,50,30);
        SaveButton.setForeground(new Color(58, 51, 168,100));
        contentPane.add(SaveButton);

        //输入框
        JTextField txt_1=new JTextField();
        txt_1.setBounds(550,60,150,30);
        contentPane.add(txt_1);
        JTextField txt_2=new JTextField();
        txt_2.setBounds(550,100,150,30);
        contentPane.add(txt_2);
        JTextField txt_3=new JTextField();
        txt_3.setBounds(550,140,150,30);
        contentPane.add(txt_3);
        JTextField txt_4=new JTextField();
        txt_4.setBounds(550,180,150,30);
        contentPane.add(txt_4);
        JTextField txt_5=new JTextField();
        txt_5.setBounds(550,220,150,30);
        contentPane.add(txt_5);
        JTextField txt_6=new JTextField();
        txt_6.setBounds(550,260,150,30);
        contentPane.add(txt_6);
        JTextField txt_7=new JTextField();
        txt_7.setBounds(550,300,150,30);
        contentPane.add(txt_7);

        JLabel label = new JLabel("姓名：");
        label.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label.setOpaque(true);
        label.setForeground(new Color(19, 188, 210));
        label.setBackground(new Color(255,255,255,80));
        label.setBounds(400, 60, 72, 30);
        contentPane.add(label);

        JLabel label_1 = new JLabel("一卡通号：");
        label_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label_1.setOpaque(true);
        label_1.setForeground(new Color(19, 188, 210));
        label_1.setBackground(new Color(255,255,255,80));
        label_1.setBounds(400, 100, 72, 30);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("性别：");
        label_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label_2.setOpaque(true);
        label_2.setForeground(new Color(19, 188, 210));
        label_2.setBackground(new Color(255,255,255,80));
        label_2.setBounds(400, 140, 72, 30);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("电子邮箱：");
        label_3.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label_3.setOpaque(true);
        label_3.setForeground(new Color(19, 188, 210));
        label_3.setBackground(new Color(255,255,255,80));
        label_3.setBounds(400, 180, 72, 30);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("电话：");
        label_4.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label_4.setOpaque(true);
        label_4.setForeground(new Color(19, 188, 210));
        label_4.setBackground(new Color(255,255,255,80));
        label_4.setBounds(400, 220, 72, 30);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("身份证号：");
        label_5.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label_5.setOpaque(true);
        label_5.setForeground(new Color(19, 188, 210));
        label_5.setBackground(new Color(255,255,255,80));
        label_5.setBounds(400, 260, 72, 30);
        contentPane.add(label_5);

        JLabel label_6 = new JLabel("地址：");
        label_6.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label_6.setOpaque(true);
        label_6.setForeground(new Color(19, 188, 210));
        label_6.setBackground(new Color(255,255,255,80));
        label_6.setBounds(400, 300, 72, 30);
        contentPane.add(label_6);

        JLabel HeadPortrait= new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/adminInfo1.jpg")));
        HeadPortrait.setOpaque(true);
        HeadPortrait.setBorder(BorderFactory.createMatteBorder(6,6,6,6,
                new Color(255, 255, 255, 255)));
        HeadPortrait.setBounds(165, 60, 185, 185);
        contentPane.add(HeadPortrait);

        JLabel TransLabel = new JLabel("");//半透明效果
        TransLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel.setOpaque(true);
        TransLabel.setBackground(new Color(255,255,255,100));
        TransLabel.setBounds(20, 50, 345, 440);
        contentPane.add(TransLabel);//先添加的label在最上层

        JLabel TransLabel2 = new JLabel("");//半透明效果
        TransLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel2.setOpaque(true);
        TransLabel2.setBackground(new Color(255,255,255,70));
        TransLabel2.setBounds(520, 58, 210, 274);
        contentPane.add(TransLabel2);//先添加的label在最上层

        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/adminInfo1.jpg")));
        bg.setOpaque(true);
        //bg.setForeground(new Color(255, 255, 255,100));
        bg.setBounds(20, 50, 345, 440);
        contentPane.add(bg);

        JLabel underLabel= new JLabel();
        underLabel.setOpaque(true);
        underLabel.setForeground(new Color(33, 117, 206));
        //underLabel.setBackground(new Color(227, 145, 145,50));//这个颜色也很好看
        underLabel.setBackground(new Color(34, 189, 176,50));
        underLabel.setBounds(380, 50, 390, 440);
        contentPane.add(underLabel);//总在最底层，代码段写在最后


    }

}
