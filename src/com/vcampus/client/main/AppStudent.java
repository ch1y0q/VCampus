package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JLabel selficon=new JLabel("");
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
        setBounds(100, 100, 1151, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLayeredPane self=new JLayeredPane();
        self.setBounds(50,50,600,400);

        selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/testphoto/pic0.jpg")));
        selficon.setBounds(50,50,600,400);
        JButton addphoto=new JButton("增加");
        addphoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index<3) index++;
                else index=0;
                selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/testphoto/pic"+index+".jpg")));
            }
        });
        addphoto.setBounds(50,200,100,30);

        JButton decreasephoto=new JButton("减少");
        decreasephoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index>0)  index--;
                else index=3;
                selficon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/testphoto/pic"+index+".jpg")));
            }
        });
        decreasephoto.setBounds(500,200,100,30);

        self.add(addphoto,1);
        self.add(decreasephoto,1);
        self.add(selficon,2);
        contentPane.add(self);

        Timer timer=new Timer(5000,new TimeListener());
        timer.start();

        JLabel lblVcampus = new JLabel(res.getString("student_main"));
        lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 43));
        lblVcampus.setBounds(50, 25, 800, 43);
        contentPane.add(lblVcampus);

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
        logout.setBounds(1000, 25, 60, 18);
        contentPane.add(logout);

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

        JButton btnLibrary = new JButton("李文正图书馆");
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

        JButton btnOpencourse = new JButton("生活服务");
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

        JLabel lblCardNumber = new JLabel("...");
        lblCardNumber.setBounds(104, 54, 72, 18);
        panel.add(lblCardNumber);

        JLabel lblStudentNumber = new JLabel("...");
        lblStudentNumber.setBounds(104, 85, 149, 18);
        panel.add(lblStudentNumber);


        JLabel lblAcademy = new JLabel("...");
        lblAcademy.setBounds(104, 116, 149, 18);
        panel.add(lblAcademy);

        JLabel lblBalance = new JLabel("...");
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

        JLabel lblCI1 = new JLabel(res.getString("no_course")); //1-2
        lblCI1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblCI1.setBounds(884, 546, 222, 18);
        contentPane.add(lblCI1);
        JLabel lblCI2 = new JLabel(res.getString("no_course"));//3-4
        lblCI2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblCI2.setBounds(884, 583, 222, 18);
        contentPane.add(lblCI2);
        JLabel lblCI3 = new JLabel(res.getString("no_course"));//5-6
        lblCI3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblCI3.setBounds(884, 620, 222, 18);
        contentPane.add(lblCI3);
        JLabel lblCI4 = new JLabel(res.getString("no_course"));//7-8
        lblCI4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblCI4.setBounds(884, 657, 222, 18);
        contentPane.add(lblCI4);
        JLabel lblCI5 = new JLabel(res.getString("no_course"));//9-10
        lblCI5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblCI5.setBounds(884, 694, 222, 18);
        contentPane.add(lblCI5);

        JLabel[] lblCourses = new JLabel[]{lblCI1, lblCI2, lblCI3, lblCI4, lblCI5};


        JLabel lblNewLabel_3 = new JLabel("1~2节");
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(806, 541, 64, 24);
        contentPane.add(lblNewLabel_3);

        JLabel label_6 = new JLabel("3~4节");
        label_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_6.setBounds(806, 578, 64, 24);
        contentPane.add(label_6);

        JLabel label_7 = new JLabel("5~6节");
        label_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_7.setBounds(806, 615, 64, 24);
        contentPane.add(label_7);

        JLabel label_8 = new JLabel("7~8节");
        label_8.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_8.setBounds(806, 652, 64, 24);
        contentPane.add(label_8);

        JLabel label_9 = new JLabel("9~10节");
        label_9.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        label_9.setBounds(806, 689, 64, 24);
        contentPane.add(label_9);

    }

}