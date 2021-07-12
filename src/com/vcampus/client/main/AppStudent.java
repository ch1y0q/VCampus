package com.vcampus.client.main;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AppStudent extends JFrame {
    private JPanel contentPane;
    public static JLabel lblBalance;
    public AppStudent() {
        setResizable(true);
        //setIconImage(Toolkit.getDefaultToolkit().getImage(AppStudent.class.getResource("/resources/assets/icon/fav.png")));
        setTitle("学生主页 - VCampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1151, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblVcampus = new JLabel("学生主页 - VCampus");
        lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 32));
        lblVcampus.setBounds(103, 25, 500, 43);
        contentPane.add(lblVcampus);

        JButton btnTeaching = new JButton("教务平台");
        btnTeaching.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        btnTeaching.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        //btnTeaching.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/teaching.png")));
        btnTeaching.setBounds(374, 600, 220, 80);
        contentPane.add(btnTeaching);

        JButton btnLibrary = new JButton(" 李文正图书馆");
        btnLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLibrary.setBackground(new Color(255, 255, 240));
        btnLibrary.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        //btnLibrary.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/library.png")));
        btnLibrary.setBounds(120, 491, 220, 80);
        contentPane.add(btnLibrary);

        JButton btnShop = new JButton("苏果在线商店");
        btnShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnShop.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        //btnShop.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/shop.png")));
        btnShop.setBounds(120, 600, 220, 80);
        contentPane.add(btnShop);

        JButton btnOpencourse = new JButton("在线课堂");
        btnOpencourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                    }
                });
            }
        });
        //btnOpencourse.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/opencourse.png")));
        btnOpencourse.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnOpencourse.setBounds(374, 491, 220, 80);
        contentPane.add(btnOpencourse);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/app.png")));
        lblNewLabel.setBounds(25, 12, 64, 64);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("关于我");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblNewLabel_1.setBounds(806, 143, 122, 64);
        contentPane.add(lblNewLabel_1);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
        panel.setBounds(806, 221, 280, 216);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblName = new JLabel("...");
        lblName.setBounds(104, 23, 149, 18);
        panel.add(lblName);
        JButton namechange =new JButton("编辑");
        namechange.setBounds(200,23,60,18);
        namechange.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        namechange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jd = new JDialog();
                jd.setBounds(320, 180, 260, 100);
                jd.setTitle("请输入修改的值");
                jd.getContentPane().setLayout(new GridLayout(1, 1));
                jd.add(new JLabel("姓名"));
                JTextField tf=new JTextField(20);
                jd.add(tf);
                tf.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String s1=tf.getText();
                        tf.setText("");
                        lblName.setText(s1);
                    }
                });
                jd.setModal(true);//确保弹出的窗口在其他窗口前面
                jd.setVisible(true);
            }
        });
        panel.add(namechange);

        JLabel lblCardNumber = new JLabel("...");
        lblCardNumber.setBounds(104, 54, 72, 18);
        panel.add(lblCardNumber);
        JButton cardchange =new JButton("编辑");
        cardchange.setBounds(200,54,60,18);
        cardchange.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        cardchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jd = new JDialog();
                jd.setBounds(320, 180, 260, 100);
                jd.setTitle("请输入修改的值");
                jd.getContentPane().setLayout(new GridLayout(1, 1));
                jd.add(new JLabel("一卡通号"));
                JTextField tf=new JTextField(20);
                jd.add(tf);
                tf.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String s1=tf.getText();
                        tf.setText("");
                        lblCardNumber.setText(s1);
                    }
                });
                jd.setModal(true);//确保弹出的窗口在其他窗口前面
                jd.setVisible(true);
            }
        });
        panel.add(cardchange);

        JLabel lblStudentNumber = new JLabel("...");
        lblStudentNumber.setBounds(104, 85, 149, 18);
        panel.add(lblStudentNumber);
        JButton stunumchange =new JButton("编辑");
        stunumchange.setBounds(200,85,60,18);
        stunumchange.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        stunumchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jd = new JDialog();
                jd.setBounds(320, 180, 260, 100);
                jd.setTitle("请输入修改的值");
                jd.getContentPane().setLayout(new GridLayout(1, 1));
                jd.add(new JLabel("学号"));
                JTextField tf=new JTextField(20);
                jd.add(tf);
                tf.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String s1=tf.getText();
                        tf.setText("");
                        lblStudentNumber.setText(s1);
                    }
                });
                jd.setModal(true);//确保弹出的窗口在其他窗口前面
                jd.setVisible(true);
            }
        });
        panel.add(stunumchange);

        JLabel lblAcademy = new JLabel("...");
        lblAcademy.setBounds(104, 116, 149, 18);
        panel.add(lblAcademy);
        JButton academychange =new JButton("编辑");
        academychange.setBounds(200,116,60,18);
        academychange.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        academychange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jd = new JDialog();
                jd.setBounds(320, 180, 260, 100);
                jd.setTitle("请输入修改的值");
                jd.getContentPane().setLayout(new GridLayout(1, 1));
                jd.add(new JLabel("院系"));
                JTextField tf=new JTextField(20);
                jd.add(tf);
                tf.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String s1=tf.getText();
                        tf.setText("");
                        lblAcademy.setText(s1);
                    }
                });
                jd.setModal(true);//确保弹出的窗口在其他窗口前面
                jd.setVisible(true);
            }
        });
        panel.add(academychange);

        lblBalance = new JLabel("...");
        lblBalance.setBounds(104, 147, 97, 18);
        panel.add(lblBalance);

        JLabel lblBookLend = new JLabel("...");
        lblBookLend.setBounds(104, 178, 72, 18);
        panel.add(lblBookLend);

        JLabel label = new JLabel("姓名：");
        label.setBounds(18, 23, 72, 18);
        panel.add(label);

        JLabel label_1 = new JLabel("一卡通号：");
        label_1.setBounds(18, 54, 84, 18);
        panel.add(label_1);

        JLabel label_2 = new JLabel("学号：");
        label_2.setBounds(18, 85, 72, 18);
        panel.add(label_2);

        JLabel label_3 = new JLabel("院系：");
        label_3.setBounds(18, 116, 72, 18);
        panel.add(label_3);

        JLabel label_4 = new JLabel("一卡通余额：");
        label_4.setBounds(18, 147, 104, 18);
        panel.add(label_4);

        JLabel label_5 = new JLabel("图书馆借书：");
        label_5.setBounds(18, 178, 104, 18);
        panel.add(label_5);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
        //lblNewLabel_2.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/test.png")));
        lblNewLabel_2.setBounds(806, 450, 64, 64);
        contentPane.add(lblNewLabel_2);

        JLabel lblToday = new JLabel("今天是星期");
        lblToday.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        lblToday.setBounds(884, 460, 198, 18);
        contentPane.add(lblToday);

    }
}
