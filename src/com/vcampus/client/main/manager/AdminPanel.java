package com.vcampus.client.main.manager;

import com.alee.managers.style.StyleId;
import com.vcampus.client.LoginUI;
import com.vcampus.client.main.App;
import com.vcampus.client.main.AppDormAdmin;
import com.vcampus.client.main.courseManage.AppAdminCourse;
import com.vcampus.client.main.dailyReport.AppDailyReportManage;
import com.vcampus.client.main.library.ManagerLibrary.ManLibrary;
import com.vcampus.client.main.shop.AppShopAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Dong Ruojing
 * @date 2021/7/30
 */
public class AdminPanel extends JPanel {

    public AdminPanel(){

        setLayout(null);

        JLabel TeacherInfoLabel1 = new JLabel("教师信息管理");//文字框
        TeacherInfoLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        TeacherInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
        TeacherInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        TeacherInfoLabel1.setBounds(455, 60, 170, 170);
        TeacherInfoLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==TeacherInfoLabel1)
                {
                    TeaManage app=new TeaManage();
                    setVisible(false);
                    app.setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                TeacherInfoLabel1.setForeground(new Color(0, 0, 0, 243));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                TeacherInfoLabel1.setForeground(new Color(0, 0, 0, 150));
            }
        });
        add(TeacherInfoLabel1);//先添加的label在最上层

        JLabel TeacherInfoLabel = new JLabel("");//透明框
        TeacherInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TeacherInfoLabel.setOpaque(true);
        TeacherInfoLabel.setBackground(new Color(255,255,255,90));
        TeacherInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        TeacherInfoLabel.setBounds(455, 60, 170, 170);
        add(TeacherInfoLabel);//先添加的label在最上层


        JLabel StudentInfoLabel1 = new JLabel("学生信息管理");//文字框
        StudentInfoLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        StudentInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
        StudentInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        StudentInfoLabel1.setBounds(285, 230, 170, 170);
        StudentInfoLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==StudentInfoLabel1)
                {
                    StuManage app=new StuManage();
                    app.setVisible(true);
                    setVisible(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                StudentInfoLabel1.setForeground(new Color(0, 0, 0,243));//字颜色
            }

            @Override
            public void mouseExited(MouseEvent e) {
                StudentInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
        add(StudentInfoLabel1);//先添加的label在最上层

        JLabel StudentInfoLabel = new JLabel("");//透明框
        StudentInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        StudentInfoLabel.setOpaque(true);
        StudentInfoLabel.setBackground(new Color(255,255,255,90));
        StudentInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        StudentInfoLabel.setBounds(285, 230, 170, 170);
        add(StudentInfoLabel);//先添加的label在最上层

        JLabel PersonInfoLabel1 = new JLabel("个人信息管理");//文字框
        PersonInfoLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        PersonInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
        PersonInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        PersonInfoLabel1.setBounds(115, 400, 170, 170);
        PersonInfoLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==PersonInfoLabel1)
                {
                    AppAdminInfoFrame app=new AppAdminInfoFrame();
                    app.setVisible(true);
                    setVisible(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                PersonInfoLabel1.setForeground(new Color(0, 0, 0, 243));//字颜色

            }

            @Override
            public void mouseExited(MouseEvent e) {
                PersonInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
       add(PersonInfoLabel1);

        JLabel PersonInfoLabel = new JLabel("");//透明框
        PersonInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        PersonInfoLabel.setOpaque(true);
        PersonInfoLabel.setBackground(new Color(255,255,255,90));
        PersonInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        PersonInfoLabel.setBounds(115, 400, 170, 170);
        add(PersonInfoLabel);//先添加的label在最上层


        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg.jpg")));
        bg.setPreferredSize(new Dimension(400,400));
        add(bg);
        bg.setBounds(120, 65, 500, 500);
        //bg.setBorder(BorderFactory.createMatteBorder(5,5,5,5,new Color(255,255,255,80)));

        JLabel ShopInfoLabel1 = new JLabel("网上商店");
        ShopInfoLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        ShopInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
        ShopInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        ShopInfoLabel1.setBounds(285, 580, 340, 160);
        ShopInfoLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()== ShopInfoLabel1)
                {
                    AppShopAdmin app=new AppShopAdmin();
                    app.setVisible(true);
                    setVisible(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ShopInfoLabel1.setForeground(new Color(0, 0, 0,243));//字颜色
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ShopInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
       add(ShopInfoLabel1);//先添加的label在最上层

        JLabel ShopInfoLabel = new JLabel("");
        ShopInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ShopInfoLabel.setOpaque(true);
        ShopInfoLabel.setBackground(new Color(255,255,255,90));
        ShopInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        ShopInfoLabel.setBounds(285, 580, 340, 160);
        add(ShopInfoLabel);//先添加的label在最上层

        JLabel bg2 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg2.jpg")));
        add(bg2);
        bg2.setBounds(120, 585, 500, 150);

        JLabel LifeInfoLabel1 = new JLabel("生活管理");
        LifeInfoLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        LifeInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
        LifeInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        LifeInfoLabel1.setBounds(890, 60, 195, 390);
        LifeInfoLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==LifeInfoLabel1)
                {
                    AppDormAdmin app=new AppDormAdmin();
                    app.setVisible(true);
                    setVisible(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                LifeInfoLabel1.setForeground(new Color(0, 0, 0,243));//字颜色
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LifeInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
        add(LifeInfoLabel1);//先添加的label在最上层

        JLabel LifeInfoLabel = new JLabel("");
        LifeInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LifeInfoLabel.setOpaque(true);
        LifeInfoLabel.setBackground(new Color(255,255,255,90));
        LifeInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        LifeInfoLabel.setBounds(890, 60, 195, 390);
        add(LifeInfoLabel);//先添加的label在最上层

        JLabel bg3 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg3.jpg")));
        add(bg3);
        bg3.setBounds(700, 65, 380, 380);

        JLabel CourseInfoLabel1 = new JLabel("课程管理");
        CourseInfoLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        CourseInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
        CourseInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        CourseInfoLabel1.setBounds(1230, 185, 145, 165);
        CourseInfoLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==CourseInfoLabel1)
                {
                    AppAdminCourse app=new AppAdminCourse();
                    app.setVisible(true);
                    setVisible(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                CourseInfoLabel1.setForeground(new Color(0, 0, 0,243));//字颜色
            }

            @Override
            public void mouseExited(MouseEvent e) {
                CourseInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
        add(CourseInfoLabel1);//先添加的label在最上层

        JLabel CourseInfoLabel = new JLabel("");
        CourseInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        CourseInfoLabel.setOpaque(true);
        CourseInfoLabel.setBackground(new Color(255,255,255,90));
        CourseInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        CourseInfoLabel.setBounds(1230, 185, 145, 165);
        add(CourseInfoLabel);//先添加的label在最上层

        JLabel bg4 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg4.jpg")));
        add(bg4);
        bg4.setBounds(1140, 190, 230, 250);

        JLabel LibraryInfoLabel1 = new JLabel("图书馆");
        LibraryInfoLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        LibraryInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
        LibraryInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        LibraryInfoLabel1.setBounds(695, 465, 200, 280);
        LibraryInfoLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==LibraryInfoLabel1)
                {
                    ManLibrary app=new ManLibrary();
                    app.setVisible(true);
                    setVisible(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                LibraryInfoLabel1.setForeground(new Color(0, 0, 0,243));//字颜色
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LibraryInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
       add(LibraryInfoLabel1);//先添加的label在最上层


        JLabel LibraryInfoLabel = new JLabel("");
        LibraryInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LibraryInfoLabel.setOpaque(true);
        LibraryInfoLabel.setBackground(new Color(255,255,255,90));
        LibraryInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        LibraryInfoLabel.setBounds(695, 460, 200, 280);
        add(LibraryInfoLabel);//先添加的label在最上层


        JLabel bg5 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg5.jpg")));
        add(bg5);
        bg5.setBounds(700, 465, 670, 270);

        JLabel TransLabel = new JLabel("");
        TransLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel.setOpaque(true);
        TransLabel.setBackground(new Color(255,255,255,100));
        TransLabel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,
                new Color(41, 210, 190, 114)));
        TransLabel.setBounds(1140, 63, 110, 110);
        add(TransLabel);//先添加的label在最上层

        JLabel bg6 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg6.jpg")));
        add(bg6);
        bg6.setBounds(1140, 63, 110, 110);
        bg6.setForeground(new Color(255,255,255,255));

        //管理员接收每日上报
        final JButton btnReport = new JButton ();
        btnReport.putClientProperty ( StyleId.STYLE_PROPERTY, StyleId.buttonHover );
        btnReport.setText("每日上报");btnReport.setBounds(1260, 85, 90, 90);
        btnReport.setOpaque(true);
        btnReport.setFont( new Font("微软雅黑", Font.BOLD, 14));
        btnReport.setForeground(new Color(0, 0, 0,150));
        btnReport.setBackground(new Color(0x7ACBB5));
        btnReport.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        btnReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnReport)
                {
                    AppDailyReportManage app=new AppDailyReportManage();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        add(btnReport);


    }


    private class MyButtonListener implements ActionListener {//监听器类
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("button");
        }

    }
}
