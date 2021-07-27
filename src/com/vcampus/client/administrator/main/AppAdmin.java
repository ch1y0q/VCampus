package com.vcampus.client.administrator.main;

import com.alee.managers.style.StyleId;
import com.vcampus.client.LoginUI;
import com.vcampus.client.main.*;
import com.vcampus.client.main.dailyReport.AppDailyReport;
import com.vcampus.client.main.dailyReport.AppDailyReportManage;
import com.vcampus.client.main.library.StuLibrary;
import com.vcampus.client.main.manager.StuManage;
import com.vcampus.client.main.manager.TeaManage;
import com.vcampus.client.main.library.ManagerLibrary.ManLibrary;
import com.vcampus.client.main.shop.AppShop;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 管理员登录界面
 * @author Dong Ruojing
 * @date 2021/7/16
 */
public class AppAdmin extends JFrame{
    private JPanel contentPane;
    //public static JLabel lblAdmin;

    public AppAdmin(){

        setResizable(true);
        setTitle("管理员主页");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(400, 200, 800, 550);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //System.out.println(d.width);1536
        //System.out.println(d.height);864
        //(true);
        setSize(d.width, d.height);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel label =new JLabel();
        label.setText(" 欢迎您,"+"xxx" );//App.session.getAdmin().getName()
        label.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label.setOpaque(true);
        label.setForeground(new Color(33, 117, 206));
        label.setBackground(new Color(33,177,206,80));
        label.setBounds(1270, 5, 100, 30);
        contentPane.add(label);


        JButton returnButton = new JButton("← 返回");
        returnButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        returnButton.setBounds(10,5,80,30);
        returnButton.setForeground(new Color(33, 117, 206,100));
        //contentPane.add(returnButton);

        JButton LogoutButton = new JButton("登出");
        LogoutButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        LogoutButton.setBounds(1380,5,50,30);
        LogoutButton.setForeground(new Color(33, 117, 206,100));
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==LogoutButton)
                {
                    LoginUI app=new LoginUI();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        contentPane.add(LogoutButton);

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
                    //setVisible(false);
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
        contentPane.add(TeacherInfoLabel1);//先添加的label在最上层

        JLabel TeacherInfoLabel = new JLabel("");//透明框
        TeacherInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TeacherInfoLabel.setOpaque(true);
        TeacherInfoLabel.setBackground(new Color(255,255,255,90));
        TeacherInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        TeacherInfoLabel.setBounds(455, 60, 170, 170);
        contentPane.add(TeacherInfoLabel);//先添加的label在最上层


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
                    //setVisible(false);
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
                StudentInfoLabel1.setForeground(new Color(0, 0, 0,243));//字颜色
            }

            @Override
            public void mouseExited(MouseEvent e) {
                StudentInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
        contentPane.add(StudentInfoLabel1);//先添加的label在最上层

        JLabel StudentInfoLabel = new JLabel("");//透明框
        StudentInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        StudentInfoLabel.setOpaque(true);
        StudentInfoLabel.setBackground(new Color(255,255,255,90));
        StudentInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        StudentInfoLabel.setBounds(285, 230, 170, 170);
        contentPane.add(StudentInfoLabel);//先添加的label在最上层

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
                    AppAdminInfo app=new AppAdminInfo();
                    //setVisible(false);
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
                PersonInfoLabel1.setForeground(new Color(0, 0, 0, 243));//字颜色

            }

            @Override
            public void mouseExited(MouseEvent e) {
                PersonInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
        contentPane.add(PersonInfoLabel1);

        JLabel PersonInfoLabel = new JLabel("");//透明框
        PersonInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        PersonInfoLabel.setOpaque(true);
        PersonInfoLabel.setBackground(new Color(255,255,255,90));
        PersonInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                 new Color(255,255,255,255)));
        PersonInfoLabel.setBounds(115, 400, 170, 170);
        contentPane.add(PersonInfoLabel);//先添加的label在最上层


        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg.jpg")));
        bg.setPreferredSize(new Dimension(400,400));
        contentPane.add(bg);
        bg.setBounds(120, 65, 500, 500);
        //bg.setBorder(BorderFactory.createMatteBorder(5,5,5,5,new Color(255,255,255,80)));

        JLabel ShopInfoLabel1 = new JLabel("网上商店");
        ShopInfoLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        ShopInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
        ShopInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        ShopInfoLabel1.setBounds(285, 580, 340, 190);
        ShopInfoLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()== ShopInfoLabel1)
                {
                    AppShop app=new AppShop();
                    //setVisible(false);
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
                ShopInfoLabel1.setForeground(new Color(0, 0, 0,243));//字颜色
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ShopInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
        contentPane.add(ShopInfoLabel1);//先添加的label在最上层

        JLabel ShopInfoLabel = new JLabel("");
        ShopInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ShopInfoLabel.setOpaque(true);
        ShopInfoLabel.setBackground(new Color(255,255,255,90));
        ShopInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
          new Color(255,255,255,255)));
        ShopInfoLabel.setBounds(285, 580, 340, 190);
        contentPane.add(ShopInfoLabel);//先添加的label在最上层

        JLabel bg2 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg2.jpg")));
        contentPane.add(bg2);
        bg2.setBounds(120, 585, 500, 180);

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
                    //setVisible(false);
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
                LifeInfoLabel1.setForeground(new Color(0, 0, 0,243));//字颜色
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LifeInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
        contentPane.add(LifeInfoLabel1);//先添加的label在最上层

        JLabel LifeInfoLabel = new JLabel("");
        LifeInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LifeInfoLabel.setOpaque(true);
        LifeInfoLabel.setBackground(new Color(255,255,255,90));
        LifeInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
            new Color(255,255,255,255)));
        LifeInfoLabel.setBounds(890, 60, 195, 390);
        contentPane.add(LifeInfoLabel);//先添加的label在最上层

        JLabel bg3 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg3.jpg")));
        contentPane.add(bg3);
        bg3.setBounds(700, 65, 380, 380);

        JLabel CourseInfoLabel1 = new JLabel("课程管理");
        CourseInfoLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        CourseInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
        CourseInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        CourseInfoLabel1.setBounds(1230, 185, 165, 165);
        CourseInfoLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==CourseInfoLabel1)
                {
                    AppAdminCourse app=new AppAdminCourse();
                    //setVisible(false);
                    /*need setVisiable
                     */
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
        contentPane.add(CourseInfoLabel1);//先添加的label在最上层

        JLabel CourseInfoLabel = new JLabel("");
        CourseInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        CourseInfoLabel.setOpaque(true);
        CourseInfoLabel.setBackground(new Color(255,255,255,90));
        CourseInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        CourseInfoLabel.setBounds(1230, 185, 165, 165);
        contentPane.add(CourseInfoLabel);//先添加的label在最上层

        JLabel bg4 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg4.jpg")));
        contentPane.add(bg4);
        bg4.setBounds(1140, 190, 250, 250);

        JLabel LibraryInfoLabel1 = new JLabel("图书馆");
        LibraryInfoLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        LibraryInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
        LibraryInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        LibraryInfoLabel1.setBounds(695, 465, 200, 310);
        LibraryInfoLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==LibraryInfoLabel1)
                {
                    ManLibrary app=new ManLibrary();
                    //setVisible(false);
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
                LibraryInfoLabel1.setForeground(new Color(0, 0, 0,243));//字颜色
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LibraryInfoLabel1.setForeground(new Color(0, 0, 0,150));//字颜色
            }
        });
        contentPane.add(LibraryInfoLabel1);//先添加的label在最上层


        JLabel LibraryInfoLabel = new JLabel("");
        LibraryInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LibraryInfoLabel.setOpaque(true);
        LibraryInfoLabel.setBackground(new Color(255,255,255,90));
        LibraryInfoLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        LibraryInfoLabel.setBounds(695, 465, 200, 310);
        contentPane.add(LibraryInfoLabel);//先添加的label在最上层


        JLabel bg5 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg5.jpg")));
        contentPane.add(bg5);
        bg5.setBounds(700, 465, 690, 300);

        JLabel TransLabel = new JLabel("");
        TransLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel.setOpaque(true);
        TransLabel.setBackground(new Color(255,255,255,100));
        TransLabel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,
                new Color(41, 210, 190, 114)));
        TransLabel.setBounds(1140, 63, 110, 110);
        contentPane.add(TransLabel);//先添加的label在最上层

        JLabel bg6 = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/AdminImage/bg6.jpg")));
        contentPane.add(bg6);
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
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        contentPane.add(btnReport);


    }


    private class MyButtonListener implements ActionListener {//监听器类
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("button");
        }
    }


}
