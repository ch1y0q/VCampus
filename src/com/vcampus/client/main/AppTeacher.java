package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.Objects;
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
        setBounds(0, 0, 1151, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton back = new JButton("返回");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        back.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        back.setBounds(0, 20, 60, 30);
        contentPane.add(back);

        JLabel tf = new JLabel();
        tf.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf.setText("欢迎你:" + "XXX");
        tf.setBounds(800, 20, 200, 30);
        tf.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(tf);

        JButton logout = new JButton(res.getString("logout"));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        logout.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        logout.setBounds(1000, 20, 60, 30);
        contentPane.add(logout);

        JLayeredPane self=new JLayeredPane();
        self.setBounds(50,50,1000,800);
        JLabel selficon=new JLabel("");
        selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teainformation.jpg")));
        selficon.setBounds(50,50,200,300);
        JLabel selfin=new JLabel("");
        JLabel selftext=new JLabel("个人信息");
        selftext.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        selftext.setForeground(new Color(0, 0, 0, 255));
        selfin.setOpaque(true);
        selfin.setBackground(new Color(255, 255, 255, 175));
        selfin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        selfin.setBounds(50,200,150,150);
        selftext.setBounds(50,280,150,30);
        selfin.addMouseListener(new MouseListener() {
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
                selftext.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selftext.setForeground(new Color(0, 0, 0, 255));
            }
        });
        self.add(selftext,0);
        self.add(selfin,1);
        self.add(selficon,2);

        JLabel classicon=new JLabel("");
        classicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teaclass.jpg")));
        classicon.setBounds(300,50,325,250);
        JLabel classin=new JLabel("");
        JLabel classtext=new JLabel("课程管理");
        classtext.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        classtext.setForeground(new Color(0, 0, 0, 255));
        classin.setOpaque(true);
        classin.setBackground(new Color(255, 255, 255, 175));
        classin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        classin.setBounds(480,50,145,125);
        classtext.setBounds(480,75,145,30);
        classin.addMouseListener(new MouseListener() {
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
                classtext.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                classtext.setForeground(new Color(0, 0, 0, 255));;
            }
        });
        self.add(classtext,0);
        self.add(classin,1);
        self.add(classicon,2);

        JLabel cardicon=new JLabel("");
        cardicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teacard.jpg")));
        cardicon.setBounds(650,50,325,250);
        JLabel cardin=new JLabel("");
        JLabel cardtext=new JLabel("一卡通");
        cardtext.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        cardtext.setForeground(new Color(0, 0, 0, 255));
        cardin.setOpaque(true);
        cardin.setBackground(new Color(255, 255, 255, 175));
        cardin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        cardin.setBounds(650,175,150,125);
        cardtext.setBounds(650,240,150,30);
        cardin.addMouseListener(new MouseListener() {
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
                cardtext.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cardtext.setForeground(new Color(0,0,0,255));
            }
        });
        self.add(cardtext,0);
        self.add(cardin,1);
        self.add(cardicon,2);

        JLabel shopicon=new JLabel("");
        shopicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teashop.jpg")));
        shopicon.setBounds(50,370,300,300);
        JLabel shopin=new JLabel("");
        JLabel shoptext=new JLabel("网上商店");
        shoptext.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        shoptext.setForeground(new Color(0, 0, 0, 255));
        shopin.setOpaque(true);
        shopin.setBackground(new Color(255, 255, 255, 175));
        shopin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        shopin.setBounds(200,370,150,300);
        shoptext.setBounds(200,450,150,30);
        shopin.addMouseListener(new MouseListener() {
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
                shoptext.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                shoptext.setForeground(new Color(0,0,0,255));
            }
        });
        self.add(shoptext,0);
        self.add(shopin,1);
        self.add(shopicon,2);

        JLabel Libicon=new JLabel("");
        Libicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teaLib.jpg")));
        Libicon.setBounds(400,340,575,330);
        JLabel Libin=new JLabel("");
        JLabel Libtext=new JLabel("图书馆");
        Libtext.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        Libtext.setForeground(new Color(0, 0, 0, 255));
        Libin.setOpaque(true);
        Libin.setBackground(new Color(255, 255, 255, 175));
        Libin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        Libin.setBounds(800,340,175,330);
        Libtext.setBounds(800,450,175,30);
        Libin.addMouseListener(new MouseListener() {
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
                Libtext.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Libtext.setForeground(new Color(0,0,0,255));
            }
        });
        self.add(Libtext,0);
        self.add(Libin,1);
        self.add(Libicon,2);
        contentPane.add(self);


    }
}
