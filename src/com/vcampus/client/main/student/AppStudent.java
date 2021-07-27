package com.vcampus.client.main.student;

import com.alee.managers.style.StyleId;
import com.vcampus.UI.myJLabel;
import com.vcampus.client.LoginUI;
import com.vcampus.client.main.AppLife;
import com.vcampus.client.main.AppStuCourse;
import com.vcampus.client.main.library.ManagerLibrary.ManLibrary;
import com.vcampus.client.main.student.StudentInfo.AppStuInfo;
import com.vcampus.client.main.shop.AppShop;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Xiao Kaijie
 * @date 2021-07-13
 */

public class AppStudent extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
    static int index=0;
    public myJLabel selficon=new myJLabel();
    private class TimeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(index==3) index=0;
            else index++;
            selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/testphoto/pic"+index+".jpg")));
        }
    }

    public AppStudent() {
        setResizable(true);
        setTitle(res.getString("student_main"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblVcampus = new JLabel(res.getString("student_main"));
        lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.BOLD, 40));
        lblVcampus.setForeground(new Color(0xF70F535F, true));
        lblVcampus.setBounds(50, 22, 800, 43);
        contentPane.add(lblVcampus);

        JLayeredPane self=new JLayeredPane();
        self.setBounds(70,50,820,600);

        selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/testphoto/pic0.jpg")));
        selficon.setBounds(20,60,800,400);
        selficon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("http://www.seu.edu.cn"));
                } catch (Exception l){
                    l.printStackTrace();
                }
            }
        });
        JButton addphoto=new JButton("←");
        addphoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index<3) index++;
                else index=0;
                selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/testphoto/pic"+index+".jpg")));
            }
        });
        addphoto.setBounds(20,241,50,50);
        addphoto.setFont(new Font("微软雅黑", Font.BOLD, 25));
        addphoto.setForeground(new Color(0xDA2E2E95, true));
        JButton decreasephoto=new JButton("→");
        decreasephoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index>0)  index--;
                else index=3;
                selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/testphoto/pic"+index+".jpg")));
            }
        });
        decreasephoto.setBounds(745,240,50,50);
        decreasephoto.setFont(new Font("微软雅黑", Font.BOLD, 25));
        decreasephoto.setForeground(new Color(0xDA2E2E95, true));

        self.add(addphoto,1);
        self.add(decreasephoto,1);
        self.add(selficon,2);
        contentPane.add(self);

        Timer timer=new Timer(5000,new TimeListener());
        timer.start();

        JButton logout = new JButton(res.getString("logout"));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==logout)
                {
                    LoginUI app=new LoginUI();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        logout.setFont(new Font("微软雅黑", Font.BOLD, 14));
        logout.setBounds(1450,5,50,30);
        logout.setForeground(new Color(33, 117, 206,100));
        contentPane.add(logout);

        myJLabel lblNews = new myJLabel();
        lblNews.setText("每日新闻");
        lblNews.setBounds(780,470,165,85);
        lblNews.setFont(new Font("微软雅黑", Font.BOLD, 18));
        lblNews.setForeground(new Color(17, 70, 123));
        lblNews.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNews);

        lblNews.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        final JButton btnLibrary = new JButton ();//美化，使用weblaf的button
        btnLibrary.putClientProperty ( StyleId.STYLE_PROPERTY, StyleId.buttonHover );
        btnLibrary.setText("李文正图书馆");btnLibrary.setBounds(120, 510, 150, 150);
        btnLibrary.setOpaque(true);
        btnLibrary.setFont( new Font("微软雅黑", Font.BOLD, 18));
        btnLibrary.setBackground(new Color(0xDA9E9EF1, true));
        btnLibrary.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        btnLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnLibrary)
                {
                    ManLibrary app=new ManLibrary();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        contentPane.add(btnLibrary);


        final JButton btnOpencourse = new JButton("生活服务");
        btnOpencourse.putClientProperty( StyleId.STYLE_PROPERTY, StyleId.buttonHover);
        btnOpencourse.setBounds(270, 600, 150, 150);
        btnOpencourse.setOpaque(true);
        btnOpencourse.setFont( new Font("微软雅黑", Font.BOLD, 18));
        btnOpencourse.setBackground(new Color(0xDA61A4B8, true));
        btnOpencourse.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        btnOpencourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnOpencourse)
                {
                    AppLife app=new AppLife();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        contentPane.add(btnOpencourse);

        final JButton btnShop = new JButton("苏果在线商店");
        btnShop.putClientProperty( StyleId.STYLE_PROPERTY, StyleId.buttonHover);
        btnShop.setBounds(420, 510, 150, 150);
        btnShop.setOpaque(true);
        btnShop.setFont( new Font("微软雅黑", Font.BOLD, 18));
        btnShop.setBackground(new Color(0xDAF1AA7C, true));
        btnShop.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        btnShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnShop)
                {
                    AppShop app=new AppShop();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        contentPane.add(btnShop);

        final JButton btnTeaching = new JButton("教务平台");
        btnTeaching.putClientProperty( StyleId.STYLE_PROPERTY, StyleId.buttonHover);
        btnTeaching.setBounds(570, 600, 150, 150);
        btnTeaching.setOpaque(true);
        btnTeaching.setFont( new Font("微软雅黑", Font.BOLD, 18));
        btnTeaching.setBackground(new Color(0xDAE76180, true));
        btnTeaching.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        btnTeaching.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnLibrary)
                {
                    AppStuCourse app=new AppStuCourse();
                    app.open();
                    setVisible(false);
                }
            }
        });
        contentPane.add(btnTeaching);

        final JButton btnReport = new JButton("每日上报");
        btnReport.putClientProperty( StyleId.STYLE_PROPERTY, StyleId.buttonHover);
        btnReport.setBounds(720, 555, 120, 120);
        btnReport.setOpaque(true);
        btnReport.setFont( new Font("微软雅黑", Font.BOLD, 18));
        btnReport.setBackground(new Color(0xDAEAEC97, true));
        btnReport.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        btnReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        contentPane.add(btnReport);



        myJLabel lblNewLabel_1 = new myJLabel();
        lblNewLabel_1.setText("关于我(点击可进行编辑)");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setForeground(new Color(21, 85, 151));
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblNewLabel_1.setBounds(1006, 103, 300, 80);
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==lblNewLabel_1)
                {
                    AppStuInfo app=new AppStuInfo();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        contentPane.add(lblNewLabel_1);

        StuInfoPanel jplStuInfo=new StuInfoPanel();
        jplStuInfo.init();
        jplStuInfo.setBounds(1006,170,350,230);
        contentPane.add(jplStuInfo);

        myJLabel lblNewLabel_2 = new myJLabel();
        lblNewLabel_2.setText("今日课程");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2.setForeground(new Color(21, 85, 151));
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblNewLabel_2.setBounds(1006, 430, 200, 80);
        contentPane.add(lblNewLabel_2);

        StuCoursePanel jplStuCorse=new StuCoursePanel();
        jplStuCorse.init();
        jplStuCorse.setBounds(1006,500,350,230);
        contentPane.add(jplStuCorse);
    }

}