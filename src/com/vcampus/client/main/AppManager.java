package com.vcampus.client.main;

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
 * @date 2021-07-17
 */

public class AppManager extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);

    public AppManager() {
        setResizable(true);
        setTitle(res.getString("manager_main"));
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
        JLabel inforicon=new JLabel("");
        inforicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/managein.jpg")));
        inforicon.setBounds(50,70,400,500);
        JLabel selfin=new JLabel("个人信息");
        selfin.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        selfin.setForeground(new Color(255,0,0,70));
        selfin.setOpaque(true);
        selfin.setBackground(new Color(18, 52, 154, 30));
        selfin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        selfin.setBounds(50,470,100,30);
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

        JLabel Stuin=new JLabel("学生信息管理");
        Stuin.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        Stuin.setForeground(new Color(255,0,0,70));
        Stuin.setOpaque(true);
        Stuin.setBackground(new Color(18, 52, 154, 30));
        Stuin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        Stuin.setBounds(180,300,100,30);
        Stuin.addMouseListener(new MouseListener() {
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
                Stuin.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Stuin.setForeground(new Color(255,0,0,70));
                Stuin.setBackground(new Color(18, 52, 154, 30));
                Stuin.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
            }
        });

        JLabel Teain=new JLabel("教师信息管理");
        Teain.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        Teain.setForeground(new Color(255,0,0,70));
        Teain.setOpaque(true);
        Teain.setBackground(new Color(18, 52, 154, 30));
        Teain.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
        Teain.setBounds(300,70,100,30);
        Teain.addMouseListener(new MouseListener() {
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

                Teain.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Teain.setForeground(new Color(255,0,0,70));
                Teain.setBackground(new Color(18, 52, 154, 30));
                Teain.setBorder( BorderFactory.createLineBorder(new Color(255,255,255)));
            }
        });

        self.add(selfin,1);
        self.add(Stuin,1);
        self.add(Teain,1);
        self.add(inforicon,2);
        contentPane.add(self);


    }
}
