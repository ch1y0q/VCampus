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
 * @date 2021-07-17
 */

public class AppTeacher extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);

    public AppTeacher() {
        setResizable(true);
        setTitle(res.getString("teacher_main"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1151, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
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
        back.setBounds(0, 25, 60, 25);
        contentPane.add(back);

        JLabel tf = new JLabel();
        tf.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf.setText("欢迎你:" + "XXX");
        tf.setBounds(800, 25, 200, 25);
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
        logout.setBounds(1000, 25, 60, 25);
        contentPane.add(logout);

        JLayeredPane self=new JLayeredPane();
        self.setBounds(50,70,1000,800);
        JLabel selficon=new JLabel("");
        selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teainformation.jpg")));
        selficon.setBounds(50,70,200,300);
        JLabel selfin=new JLabel("个人信息");
        selfin.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        selfin.setForeground(new Color(255,0,0,70));
        selfin.setOpaque(true);
        selfin.setBackground(new Color(18, 52, 154, 30));
        selfin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        selfin.setBounds(50,250,100,30);
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
                selfin.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selfin.setForeground(new Color(255,0,0,70));
                selfin.setBackground(new Color(18, 52, 154, 30));
                selfin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
            }
        });
        self.add(selfin,1);
        self.add(selficon,2);

        JLabel classicon=new JLabel("");
        classicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teaclass.jpg")));
        classicon.setBounds(300,70,400,300);
        JLabel classin=new JLabel("课程管理");
        classin.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        classin.setForeground(new Color(255,0,0,70));
        classin.setOpaque(true);
        classin.setBackground(new Color(18, 52, 154, 30));
        classin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        classin.setBounds(300,250,100,30);
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
                classin.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                classin.setForeground(new Color(255,0,0,70));
                classin.setBackground(new Color(18, 52, 154, 30));
                classin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
            }
        });
        self.add(classin,1);
        self.add(classicon,2);

        JLabel cardicon=new JLabel("");
        cardicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teacard.jpg")));
        cardicon.setBounds(700,70,400,300);
        JLabel cardin=new JLabel("一卡通");
        cardin.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        cardin.setForeground(new Color(255,0,0,70));
        cardin.setOpaque(true);
        cardin.setBackground(new Color(18, 52, 154, 30));
        cardin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        cardin.setBounds(700,250,100,30);
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
                cardin.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cardin.setForeground(new Color(255,0,0,70));
                cardin.setBackground(new Color(18, 52, 154, 30));
                cardin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
            }
        });
        self.add(cardin,1);
        self.add(cardicon,2);

        JLabel shopicon=new JLabel("");
        shopicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teashop.jpg")));
        shopicon.setBounds(700,70,400,300);
        JLabel shopin=new JLabel("一卡通");
        shopin.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        shopin.setBounds(700,250,100,30);
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
                shopin.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                shopin.setForeground(new Color(255,0,0,70));
                shopin.setBackground(new Color(18, 52, 154, 30));
                shopin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
            }
        });
        self.add(shopin,1);
        self.add(shopicon,2);

        JLabel Libicon=new JLabel("");
        Libicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teaLib.jpg")));
        Libicon.setBounds(700,70,400,300);
        JLabel Libin=new JLabel("一卡通");
        Libin.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        Libin.setBounds(700,250,100,30);
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
                Libin.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Libin.setForeground(new Color(255,0,0,70));
                Libin.setBackground(new Color(18, 52, 154, 30));
                Libin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
            }
        });
        self.add(Libin,1);
        self.add(Libicon,2);
        contentPane.add(self);

    }
}
