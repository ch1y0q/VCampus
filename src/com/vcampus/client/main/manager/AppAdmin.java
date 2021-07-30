package com.vcampus.client.main.manager;

import com.alee.managers.style.StyleId;
import com.vcampus.client.LoginUI;
import com.vcampus.client.main.*;
import com.vcampus.client.main.courseManage.AppAdminCourse;
import com.vcampus.client.main.dailyReport.AppDailyReportManage;
import com.vcampus.client.main.library.ManagerLibrary.ManLibrary;
import com.vcampus.client.main.shop.AppShop;
import com.vcampus.client.main.shop.AppShopAdmin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * 管理员登录界面
 * @author Dong Ruojing
 * @date 2021/7/16
 */
public class AppAdmin extends JFrame{
    private JPanel contentPane;
    //public static JLabel lblAdmin;

    public AppAdmin() {

        setResizable(true);
        setTitle("管理员主页");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(400, 200, 800, 550);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //System.out.println(d.width);1536
        //System.out.println(d.height);864
        //(true);
        setSize(d.width, d.height);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label =new JLabel();
        label.setText(" 欢迎您,"+ App.session.getAdmin().getName() );//App.session.getAdmin().getName()
        label.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(new Color(33, 117, 206));
        label.setBackground(new Color(33,177,206,80));
        label.setBounds(50, 5, 140, 30);
        contentPane.add(label);


//        JButton returnButton = new JButton("← 返回");
//        returnButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
//        returnButton.setBounds(10,5,80,30);
//        returnButton.setForeground(new Color(33, 117, 206,100));
//        contentPane.add(returnButton);
//        returnButton.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//            }
//        });

        JButton LogoutButton = new JButton("登出");
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

        AdminPanel adminPanel=new AdminPanel();
        adminPanel.setVisible(true);
        adminPanel.setBackground(new Color(240, 255, 240));
        adminPanel.setBounds(-50,10,1400,900);
        contentPane.add(adminPanel);


    }


}
