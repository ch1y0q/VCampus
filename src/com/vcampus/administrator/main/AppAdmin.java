package com.vcampus.administrator.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 管理员登录界面
 * @author Dong Ruojing
 * @date 2021/7/16
 */
public class AppAdmin extends JFrame{
    private JPanel contentPane;
    public static JLabel lblAdmin;

    public AppAdmin(){
        setResizable(true);
        setTitle("管理员登录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 800, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel label =new JLabel();
        label.setText(" 欢迎您,xxx");
        label.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label.setOpaque(true);
        label.setForeground(new Color(33, 117, 206));
        label.setBackground(new Color(33,177,206,80));
        label.setBounds(600, 5, 100, 30);
        contentPane.add(label);


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

        JLabel TeacherInfoLabel = new JLabel("教师信息管理");
        TeacherInfoLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        TeacherInfoLabel.setForeground(new Color(0, 0, 0,150));//字颜色
        TeacherInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TeacherInfoLabel.setOpaque(true);
        TeacherInfoLabel.setBackground(new Color(255,255,255,90));
        TeacherInfoLabel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,
                new Color(255,255,255,255)));
        TeacherInfoLabel.setBounds(265, 62, 103, 103);
        contentPane.add(TeacherInfoLabel);//先添加的label在最上层

        JLabel StudentInfoLabel = new JLabel("学生信息管理");
        StudentInfoLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        StudentInfoLabel.setForeground(new Color(0, 0, 0,150));//字颜色
        StudentInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        StudentInfoLabel.setOpaque(true);
        StudentInfoLabel.setBackground(new Color(255,255,255,90));
        StudentInfoLabel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,
                new Color(255,255,255,255)));
        StudentInfoLabel.setBounds(165, 165, 100, 100);
        contentPane.add(StudentInfoLabel);//先添加的label在最上层

        JLabel PersonInfoLabel = new JLabel("个人信息管理");
        PersonInfoLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        PersonInfoLabel.setForeground(new Color(0, 0, 0,150));//字颜色
        PersonInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        PersonInfoLabel.setOpaque(true);
        PersonInfoLabel.setBackground(new Color(255,255,255,90));
        PersonInfoLabel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,
                 new Color(255,255,255,255)));
        PersonInfoLabel.setBounds(62, 265, 103, 103);
        contentPane.add(PersonInfoLabel);//先添加的label在最上层

        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/pic1.jpg")));
        bg.setPreferredSize(new Dimension(400,400));
        contentPane.add(bg);
        bg.setBounds(65, 65, 300, 300);
        //bg.setBorder(BorderFactory.createMatteBorder(5,5,5,5,new Color(255,255,255,80)));

        JLabel ShopInfoLabel = new JLabel("网上商店");
        ShopInfoLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        ShopInfoLabel.setForeground(new Color(0, 0, 0,150));//字颜色
        ShopInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ShopInfoLabel.setOpaque(true);
        ShopInfoLabel.setBackground(new Color(255,255,255,90));
        ShopInfoLabel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,
          new Color(255,255,255,255)));
        ShopInfoLabel.setBounds(162, 382, 206, 91);
        contentPane.add(ShopInfoLabel);//先添加的label在最上层

        JLabel bg2 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/pic3.jpg")));
        contentPane.add(bg2);
        bg2.setBounds(65, 385, 300, 85);

        JLabel LifeInfoLabel = new JLabel("生活管理");
        LifeInfoLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        LifeInfoLabel.setForeground(new Color(0, 0, 0,150));//字颜色
        LifeInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LifeInfoLabel.setOpaque(true);
        LifeInfoLabel.setBackground(new Color(255,255,255,90));
        LifeInfoLabel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,
            new Color(255,255,255,255)));
        LifeInfoLabel.setBounds(490, 62, 93, 256);
        contentPane.add(LifeInfoLabel);//先添加的label在最上层

        JLabel bg3 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/pic2.jpg")));
        contentPane.add(bg3);
        bg3.setBounds(400, 65, 180, 250);

        JLabel CourseInfoLabel = new JLabel("课程管理");
        CourseInfoLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        CourseInfoLabel.setForeground(new Color(0, 0, 0,150));//字颜色
        CourseInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        CourseInfoLabel.setOpaque(true);
        CourseInfoLabel.setBackground(new Color(255,255,255,90));
        CourseInfoLabel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,
                new Color(255,255,255,255)));
        CourseInfoLabel.setBounds(650, 162, 103, 103);
        contentPane.add(CourseInfoLabel);//先添加的label在最上层

        JLabel bg4 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/pic4.jpg")));
        contentPane.add(bg4);
        bg4.setBounds(585, 150, 180, 180);

        JLabel LibraryInfoLabel = new JLabel("图书馆");
        LibraryInfoLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        LibraryInfoLabel.setForeground(new Color(0, 0, 0,150));//字颜色
        LibraryInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LibraryInfoLabel.setOpaque(true);
        LibraryInfoLabel.setBackground(new Color(255,255,255,90));
        LibraryInfoLabel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,
                new Color(255,255,255,255)));
        LibraryInfoLabel.setBounds(397, 332, 96, 141);
        contentPane.add(LibraryInfoLabel);//先添加的label在最上层

        JLabel bg5 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/pic5.jpg")));
        contentPane.add(bg5);
        bg5.setBounds(385, 335, 380, 135);

        JLabel TransLabel = new JLabel("");
        TransLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel.setOpaque(true);
        TransLabel.setBackground(new Color(255,255,255,100));
        TransLabel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,
                new Color(41, 210, 190, 114)));
        TransLabel.setBounds(600, 63, 95, 95);
        contentPane.add(TransLabel);//先添加的label在最上层

        JLabel bg6 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/pic7.jpg")));
        contentPane.add(bg6);
        bg6.setBounds(603, 65, 90, 90);
        bg6.setForeground(new Color(255,255,255,255));

    }


    private class MyButtonListener implements ActionListener {//监听器类
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("button");
        }
    }


}
