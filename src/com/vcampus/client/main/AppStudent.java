package com.vcampus.client.main;

import com.vcampus.UI.myJLabel;
import com.vcampus.client.LoginUI;
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
        logout.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        logout.setBounds(1200, 25, 60, 30);
        contentPane.add(logout);

        myJLabel lblNews = new myJLabel();
        lblNews.setText("每日新闻");
        lblNews.setBounds(780,500,165,100);
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


        JButton btnLibrary = new JButton("李文正图书馆");
        btnLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnLibrary)
                {
                    StuLibrary app=new StuLibrary();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        btnLibrary.setBackground(new Color(255, 255, 240));
        btnLibrary.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnLibrary.setBounds(120, 600, 220, 80);
        contentPane.add(btnLibrary);

        JButton btnOpencourse = new JButton("生活服务");
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
        //btnOpencourse.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/opencourse.png")));
        btnOpencourse.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnOpencourse.setBounds(400, 600, 220, 80);
        contentPane.add(btnOpencourse);

        JButton btnShop = new JButton("苏果在线商店");
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
        btnShop.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        //btnShop.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/shop.png")));
        btnShop.setBounds(120, 700, 220, 80);
        contentPane.add(btnShop);

        JButton btnTeaching = new JButton("教务平台");
        btnTeaching.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnLibrary)
                {
                    AppStuCourse app=new AppStuCourse();
                    setVisible(false);
                }
            }
        });
        btnTeaching.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        //btnTeaching.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/teaching.png")));
        btnTeaching.setBounds(400, 700, 220, 80);
        contentPane.add(btnTeaching);

        JLabel lblNewLabel_1 = new JLabel("关于我(点击可进行编辑)");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblNewLabel_1.setBounds(1006, 143, 300, 64);
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
        jplStuInfo.setBounds(1006,230,350,230);
        contentPane.add(jplStuInfo);

        StuCoursePanel jplStuCorse=new StuCoursePanel();
        jplStuCorse.init();
        jplStuCorse.setBounds(1006,500,400,230);
        contentPane.add(jplStuCorse);
    }

}