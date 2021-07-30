package com.vcampus.client.main.teacher;

import com.alee.managers.style.StyleId;
import com.vcampus.client.LoginUI;
import com.vcampus.client.main.App;
import com.vcampus.client.main.life.AppLifeTeacher;
import com.vcampus.client.main.courseManage.AppTeaCourse;
import com.vcampus.client.main.teacher.TeacherInfo.AppTeaInfo;
import com.vcampus.client.main.library.TeaLibrary;
import com.vcampus.client.main.shop.AppShop;
import com.vcampus.util.Utf8ResourceBundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 教师主入口
 * @author Xiao Kaijie
 * @date 2021-07-18
 */

public class AppTeacher extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = Utf8ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);

    public AppTeacher() {
        setResizable(true);
        setTitle(res.getString("teacher_main"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        System.out.println(d.width+" "+d.height);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label =new JLabel();
        label.setText(" 欢迎您,"+ App.session.getTeacher().getName() );//App.session.getTeacher().getName()
        label.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);
        label.setForeground(new Color(33, 117, 206));
        label.setBackground(new Color(33,177,206,80));
        label.setBounds(50, 5, 140, 30);
        contentPane.add(label);

        JButton LogoutButton = new JButton(res.getString("logout"));
        LogoutButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        LogoutButton.setBounds(200,5,50,30);
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

        JLayeredPane self=new JLayeredPane();
        self.setBounds(50,50,1500,1000);
        JLabel selficon=new JLabel("");
        selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teainformation.jpg")));
        selficon.setBounds(70, 15, 290,420);
        JLabel selfin=new JLabel("");
        JLabel selftext=new JLabel("个人信息");
        selftext.setFont(new Font("微软雅黑", Font.BOLD, 20));
        selftext.setForeground(new Color(0, 0, 0,150));
        selftext.setHorizontalAlignment(SwingConstants.CENTER);
        selfin.setOpaque(true);
        selfin.setBackground(new Color(255, 255, 255, 90));
        selfin.setBorder( BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        selfin.setBounds(65,230,170,210);
        selftext.setBounds(65,230,170,210);
        selfin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==selfin)
                {
                    AppTeaInfo app=new AppTeaInfo();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                selftext.setForeground(Color.BLACK);
            }
            public void mouseExited(MouseEvent e) {
                selftext.setForeground(new Color(0, 0, 0,150));
            }});
        self.add(selftext,0);
        self.add(selfin,1);
        self.add(selficon,2);

        JLabel classicon=new JLabel("");
        classicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teaclass.jpg")));
        classicon.setBounds(400,15,410,300);
        JLabel classin=new JLabel("");
        JLabel classtext=new JLabel("课程管理");
        classtext.setFont(new Font("微软雅黑", Font.BOLD, 20));
        classtext.setForeground(new Color(0, 0, 0,150));
        classtext.setHorizontalAlignment(SwingConstants.CENTER);
        classin.setOpaque(true);
        classin.setBackground(new Color(255, 255, 255, 90));
        classin.setBorder( BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        classin.setBounds(635,10,180,180);
        classtext.setBounds(635,10,180,180);
        classin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==classin)
                {
                    AppTeaCourse app=new AppTeaCourse();
                    app.open();
                    setVisible(false);
                }
            }
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                classtext.setForeground(Color.BLACK);
            }
            public void mouseExited(MouseEvent e) { classtext.setForeground(new Color(0, 0, 0,150));; }
        });
        self.add(classtext,0);
        self.add(classin,1);
        self.add(classicon,2);

        JLabel cardicon=new JLabel("");
        cardicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teacard.jpg")));
        cardicon.setBounds(850,15,480,300);
        JLabel cardin=new JLabel("");
        JLabel cardtext=new JLabel("一卡通");
        cardtext.setFont(new Font("微软雅黑",Font.BOLD, 20));
        cardtext.setForeground(new Color(0, 0, 0,150));
        cardtext.setHorizontalAlignment(SwingConstants.CENTER);
        cardin.setOpaque(true);
        cardin.setBackground(new Color(255, 255, 255, 90));
        cardin.setBorder( BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        cardin.setBounds(845,185,235,135);
        cardtext.setBounds(845,185,235,135);
        cardin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==cardin)
                {
                    AppLifeTeacher app=new AppLifeTeacher();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                cardtext.setForeground(Color.BLACK);
            }
            public void mouseExited(MouseEvent e) {
                cardtext.setForeground(new Color(0, 0, 0,150));
            }});
        self.add(cardtext,0);
        self.add(cardin,1);
        self.add(cardicon,2);

        JLabel shopicon=new JLabel("");
        shopicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teashop.jpg")));
        shopicon.setBounds(70,470,460,250);
        JLabel shopin=new JLabel("");
        JLabel shoptext=new JLabel("网上商店");
        shoptext.setFont(new Font("微软雅黑", Font.BOLD, 20));
        shoptext.setForeground(new Color(0, 0, 0,150));
        shoptext.setHorizontalAlignment(SwingConstants.CENTER);
        shopin.setOpaque(true);
        shopin.setBackground(new Color(255, 255, 255, 90));
        shopin.setBorder( BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        shopin.setBounds(230,465,170,270);
        shoptext.setBounds(230,465,170,270);
        shopin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==shopin)
                {
                    AppShop app=new AppShop();
                    app.setVisible(true);
                    setVisible(false);
                }}
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                shoptext.setForeground(Color.BLACK);
            }
            public void mouseExited(MouseEvent e) {
                shoptext.setForeground(new Color(0, 0, 0,150));
            }});
        self.add(shoptext,0);
        self.add(shopin,1);
        self.add(shopicon,2);

        JLabel Libicon=new JLabel("");
        Libicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teaLib.jpg")));
        Libicon.setBounds(570,350,760,370);
        JLabel Libin=new JLabel("");
        JLabel Libtext=new JLabel("图书馆");
        Libtext.setFont(new Font("微软雅黑", Font.BOLD, 20));
        Libtext.setHorizontalAlignment(SwingConstants.CENTER);
        Libtext.setForeground(new Color(0, 0, 0,150));
        Libin.setOpaque(true);
        Libin.setBackground(new Color(255, 255, 255, 90));
        Libin.setBorder( BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        Libin.setBounds(1075,345,270,410);
        Libtext.setBounds(1075,345,270,410);
        Libin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==Libin) {
                    TeaLibrary app=new TeaLibrary();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                Libtext.setForeground(Color.BLACK);
            }
            public void mouseExited(MouseEvent e) {
                Libtext.setForeground(new Color(0, 0, 0,150));
            }});
        self.add(Libtext,0);
        self.add(Libin,1);
        self.add(Libicon,2);
        contentPane.add(self);

        //按钮
        final JButton btnReport = new JButton ();
        btnReport.putClientProperty ( StyleId.STYLE_PROPERTY, StyleId.buttonHover );
        btnReport.setText("I love SEU");btnReport.setBounds(445, 395, 140, 95);
        btnReport.setOpaque(true);
        btnReport.setFont( new Font("微软雅黑", Font.BOLD, 18));
        btnReport.setForeground(new Color(0, 0, 0,150));
        btnReport.setBackground(new Color(0x7ACBB5));
        btnReport.setBorder(BorderFactory.createMatteBorder(5,5,5,5,
                new Color(255,255,255,255)));
        btnReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnReport)
                {
                    //AppDailyReport app=new AppDailyReport();
                    //setVisible(false);
                    //app.setVisible(true);
                    btnReport.setBackground(new Color(236, 116, 116));
                    btnReport.setForeground(new  Color(255, 255, 255));
                }
            }
        });
        contentPane.add(btnReport);

    }
}
