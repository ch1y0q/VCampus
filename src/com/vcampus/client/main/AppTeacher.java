package com.vcampus.client.main;

import com.vcampus.client.LoginUI;
import com.vcampus.client.main.TeacherInfo.AppTeaInfo;
import com.vcampus.client.main.shop.AppShop;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Xiao Kaijie
 * @date 2021-07-18
 */

public class AppTeacher extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);

    public AppTeacher() {
        setResizable(true);
        setTitle(res.getString("teacher_main"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        System.out.println(d.width+" "+d.height);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel tf = new JLabel();
        tf.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf.setText("欢迎你:" + "XXX");
        tf.setBounds(1000, 20, 200, 30);
        tf.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(tf);

        JButton logout = new JButton(res.getString("logout"));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==logout)
                {
                    LoginUI app=new LoginUI();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        logout.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        logout.setBounds(1330, 20, 60, 30);
        contentPane.add(logout);

        JLayeredPane self=new JLayeredPane();
        self.setBounds(50,50,1500,1000);
        JLabel selficon=new JLabel("");
        selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teainformation.jpg")));
        selficon.setBounds(0,0,300,420);
        JLabel selfin=new JLabel("");
        JLabel selftext=new JLabel("个人信息");
        selftext.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        selftext.setForeground(new Color(0, 0, 0, 255));
        selfin.setOpaque(true);
        selfin.setBackground(new Color(255, 255, 255, 100));
        selfin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        selfin.setBounds(0,210,170,210);
        selftext.setBounds(30,300,120,30);
        selfin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==selfin)
                {
                    AppTeaInfo app=new AppTeaInfo();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                selftext.setForeground(Color.red);
            }
            public void mouseExited(MouseEvent e) {
                selftext.setForeground(new Color(0, 0, 0, 255));
            }});
        self.add(selftext,0);
        self.add(selfin,1);
        self.add(selficon,2);

        JLabel classicon=new JLabel("");
        classicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teaclass.jpg")));
        classicon.setBounds(320,0,490,360);
        JLabel classin=new JLabel("");
        JLabel classtext=new JLabel("课程管理");
        classtext.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        classtext.setForeground(new Color(0, 0, 0, 255));
        classin.setOpaque(true);
        classin.setBackground(new Color(255, 255, 255, 100));
        classin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        classin.setBounds(660,0,150,180);
        classtext.setBounds(685,80,100,30);
        classin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==classin)
                {
                    AppTeaCourse app=new AppTeaCourse();
                    setVisible(false);
                    app.close();
                }
            }
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                classtext.setForeground(Color.red);
            }
            public void mouseExited(MouseEvent e) { classtext.setForeground(new Color(0, 0, 0, 255));; }
        });
        self.add(classtext,0);
        self.add(classin,1);
        self.add(classicon,2);

        JLabel cardicon=new JLabel("");
        cardicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teacard.jpg")));
        cardicon.setBounds(830,0,490,360);
        JLabel cardin=new JLabel("");
        JLabel cardtext=new JLabel("一卡通");
        cardtext.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        cardtext.setForeground(new Color(0, 0, 0, 255));
        cardin.setOpaque(true);
        cardin.setBackground(new Color(255, 255, 255, 100));
        cardin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        cardin.setBounds(830,180,200,180);
        cardtext.setBounds(885,260,100,30);
        cardin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==cardin)
                {
                    AppLife app=new AppLife();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                cardtext.setForeground(Color.red);
            }
            public void mouseExited(MouseEvent e) {
                cardtext.setForeground(new Color(0,0,0,255));
            }});
        self.add(cardtext,0);
        self.add(cardin,1);
        self.add(cardicon,2);

        JLabel shopicon=new JLabel("");
        shopicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teashop.jpg")));
        shopicon.setBounds(0,440,350,350);
        JLabel shopin=new JLabel("");
        JLabel shoptext=new JLabel("网上商店");
        shoptext.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        shoptext.setForeground(new Color(0, 0, 0, 255));
        shopin.setOpaque(true);
        shopin.setBackground(new Color(255, 255, 255, 100));
        shopin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        shopin.setBounds(170,440,180,350);
        shoptext.setBounds(210,615,100,30);
        shopin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==shopin)
                {
                    AppShop app=new AppShop();
                    setVisible(false);
                    app.setVisible(true);
                }}
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                shoptext.setForeground(Color.red);
            }
            public void mouseExited(MouseEvent e) {
                shoptext.setForeground(new Color(0,0,0,255));
            }});
        self.add(shoptext,0);
        self.add(shopin,1);
        self.add(shopicon,2);

        JLabel Libicon=new JLabel("");
        Libicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teaLib.jpg")));
        Libicon.setBounds(380,380,940,410);
        JLabel Libin=new JLabel("");
        JLabel Libtext=new JLabel("图书馆");
        Libtext.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        Libtext.setForeground(new Color(0, 0, 0, 255));
        Libin.setOpaque(true);
        Libin.setBackground(new Color(255, 255, 255, 100));
        Libin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        Libin.setBounds(1030,380,290,410);
        Libtext.setBounds(1130,580,100,30);
        Libin.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==Libin) {
                    TeaLibrary app=new TeaLibrary();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
            public void mousePressed(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) {
                Libtext.setForeground(Color.red);
            }
            public void mouseExited(MouseEvent e) {
                Libtext.setForeground(new Color(0,0,0,255));
            }});
        self.add(Libtext,0);
        self.add(Libin,1);
        self.add(Libicon,2);
        contentPane.add(self);
    }
}
