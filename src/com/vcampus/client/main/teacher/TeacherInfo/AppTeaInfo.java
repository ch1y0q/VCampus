package com.vcampus.client.main.teacher.TeacherInfo;

import com.vcampus.client.LoginUI;
import com.vcampus.client.main.App;
import com.vcampus.client.main.teacher.AppTeacher;
import com.vcampus.client.main.teacher.TeaCategory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

/**
 * 教师信息界面
 * @author Dong Ruojing
 * @date 2021/7/23
 */
public class AppTeaInfo  extends JFrame {
    private JPanel contentPane;

    public AppTeaInfo() {
        setResizable(true);//允许窗口大小更改
        setTitle("个人信息管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTree jt=new TeaCategory().init();
        jt.setBackground(new Color(240, 255, 240));
        jt.setBounds(0,50,200,600);
        contentPane.add(jt);

        JButton returnButton = new JButton("← 返回");//返回按钮
        returnButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        returnButton.setBounds(220,5,80,30);
        returnButton.setForeground(new Color(33, 117, 206,100));
        contentPane.add(returnButton);
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==returnButton)
                {
                    AppTeacher app=new AppTeacher();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });

        JButton LogoutButton = new JButton("登出");//登出按钮
        LogoutButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        LogoutButton.setBounds(1450,5,50,30);
        LogoutButton.setForeground(new Color(33, 117, 206,100));
        LogoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==returnButton)
                {
                    LoginUI app=new LoginUI();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        contentPane.add(LogoutButton);

        JButton EditButton = new JButton("启动编辑");//编辑按钮
        EditButton.setFont(new Font("微软雅黑", Font.BOLD, 17));
        EditButton.setBounds(1150,695,90,40);
        EditButton.setForeground(new Color(58, 51, 168,100));
        contentPane.add(EditButton);

        JButton btnLoadPortrait = new JButton("上传头像");//上传头像按钮
        btnLoadPortrait.setFont(new Font("微软雅黑", Font.BOLD, 14));
        btnLoadPortrait.setBounds(690,375,80,30);
        btnLoadPortrait.setForeground(new Color(58, 51, 168,100));
        contentPane.add(btnLoadPortrait);


        JButton SaveButton = new JButton("保存");//保存按钮
        SaveButton.setFont(new Font("微软雅黑", Font.BOLD, 17));
        SaveButton.setBounds(1270,695,60,40);
        SaveButton.setForeground(new Color(58, 51, 168,100));
        contentPane.add(SaveButton);

        String teacherName = App.session.getTeacher().getName();//获取姓名
        String teacherCardNumber = App.session.getTeacher().getCardNumber();//获取一卡通号
        String teacherGender = App.session.getTeacher().getGender();//获取性别
        String teacherSchool = App.session.getTeacher().getSchoolByteacherNumber();//获取学院
        String teacherEmail = App.session.getTeacher().getEmail();//获取邮箱
        String teacherPassword = App.session.getTeacher().getPassword();//获取登录密码
        String teacherPhoneNumber = App.session.getTeacher().getPhoneNumber();//获取电话号码
        String teacherBankAccount = App.session.getTeacher().getTeacherNumber();
        BigDecimal studentBalance = App.session.getTeacher().getBalance();//获取存款

        //输入框
        JTextField txt_1=new JTextField();
        txt_1.setBounds(1130,100,170,40);
        contentPane.add(txt_1);
        JTextField txt_2=new JTextField();
        txt_2.setBounds(1130,160,170,40);
        contentPane.add(txt_2);
        JTextField txt_3=new JTextField();
        txt_3.setBounds(1130,220,170,40);
        contentPane.add(txt_3);
        JTextField txt_4=new JTextField();
        txt_4.setBounds(1130,280,170,40);
        contentPane.add(txt_4);
        JTextField txt_5=new JTextField();
        txt_5.setBounds(1130,340,170,40);
        contentPane.add(txt_5);
        JTextField txt_6=new JTextField();
        txt_6.setBounds(1130,400,170,40);
        contentPane.add(txt_6);
        JTextField txt_7=new JTextField();
        txt_7.setBounds(1130,460,170,40);
        contentPane.add(txt_7);
        JTextField txt_8=new JTextField();
        txt_8.setBounds(1130,520,170,40);
        contentPane.add(txt_8);
        JTextField txt_9=new JTextField();
        txt_9.setBounds(1130,580,170,40);
        contentPane.add(txt_9);


        JLabel label = new JLabel("姓名：");
        label.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label.setOpaque(true);
        label.setForeground(new Color(19, 188, 210));
        label.setBackground(new Color(255,255,255,80));
        label.setBounds(945, 100, 100, 40);
        contentPane.add(label);

        JLabel label_1 = new JLabel("一卡通号：");
        label_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_1.setOpaque(true);
        label_1.setForeground(new Color(19, 188, 210));
        label_1.setBackground(new Color(255,255,255,80));
        label_1.setBounds(945, 160, 100, 40);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("性别：");
        label_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_2.setOpaque(true);
        label_2.setForeground(new Color(19, 188, 210));
        label_2.setBackground(new Color(255,255,255,80));
        label_2.setBounds(945, 220, 100, 40);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("学院：");
        label_3.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_3.setOpaque(true);
        label_3.setForeground(new Color(19, 188, 210));
        label_3.setBackground(new Color(255,255,255,80));
        label_3.setBounds(945, 280, 100, 40);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("银行账户：");
        label_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_4.setOpaque(true);
        label_4.setForeground(new Color(19, 188, 210));
        label_4.setBackground(new Color(255,255,255,80));
        label_4.setBounds(945, 340, 100, 40);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("账户存款：");
        label_5.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_5.setOpaque(true);
        label_5.setForeground(new Color(19, 188, 210));
        label_5.setBackground(new Color(255,255,255,80));
        label_5.setBounds(945, 400, 100, 40);
        contentPane.add(label_5);

        JLabel label_6 = new JLabel("电话：");
        label_6.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_6.setOpaque(true);
        label_6.setForeground(new Color(19, 188, 210));
        label_6.setBackground(new Color(255,255,255,80));
        label_6.setBounds(945, 460, 100, 40);
        contentPane.add(label_6);

        JLabel label_7 = new JLabel("邮箱：");
        label_7.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_7.setOpaque(true);
        label_7.setForeground(new Color(19, 188, 210));
        label_7.setBackground(new Color(255,255,255,80));
        label_7.setBounds(945, 520, 100, 40);
        contentPane.add(label_7);

        JLabel label_8 = new JLabel("登录密码：");
        label_8.setFont(new Font("微软雅黑", Font.BOLD, 18));
        label_8.setOpaque(true);
        label_8.setForeground(new Color(19, 188, 210));
        label_8.setBackground(new Color(255,255,255,80));
        label_8.setBounds(945, 580, 100, 40);
        contentPane.add(label_8);


        JLabel HeadPortrait= new JLabel(new ImageIcon(getClass().getResource("/resources/assets/Teacher/TeaInfo.jpg")));
        HeadPortrait.setOpaque(true);
        HeadPortrait.setBorder(BorderFactory.createMatteBorder(8,8,8,8,
                new Color(255, 255, 255, 255)));
        HeadPortrait.setBounds(500, 90, 280, 280);
        contentPane.add(HeadPortrait);

        JLabel TransLabel = new JLabel("");//半透明效果
        TransLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel.setOpaque(true);
        TransLabel.setBackground(new Color(255,255,255,120));
        TransLabel.setBounds(220, 50, 602, 700);
        contentPane.add(TransLabel);//先添加的label在最上层

        JLabel TransLabel2 = new JLabel("");//半透明效果
        TransLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        TransLabel2.setOpaque(true);
        TransLabel2.setBackground(new Color(255,255,255,70));
        TransLabel2.setBounds(1100, 98, 230, 525);
        contentPane.add(TransLabel2);//先添加的label在最上层

        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/Teacher/TeaInfo.jpg")));
        bg.setOpaque(true);
        bg.setBounds(220, 50, 600, 700);
        contentPane.add(bg);//背景

        JLabel underLabel= new JLabel();
        underLabel.setOpaque(true);
        underLabel.setForeground(new Color(33, 117, 206));
        underLabel.setBackground(new Color(34, 189, 176,50));
        underLabel.setBounds(880, 50, 500, 700);
        contentPane.add(underLabel);//总在最底层，代码段写在最后


    }

}

