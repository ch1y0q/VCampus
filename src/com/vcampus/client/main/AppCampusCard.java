package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Y
 * @date 2021/7/14
 */
public class AppCampusCard extends JFrame {
    private JPanel contentPane;
    public static JLabel lblBalance;
    public AppCampusCard(){
        setResizable(true);
        setTitle("一卡通管理中心 - VCampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel CardNumLabel = new JLabel("一卡通号");
        CardNumLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardNumLabel.setBounds(5, 5, 100, 40);
        contentPane.add(CardNumLabel);

        JLabel CardNum = new JLabel("213191111");
        CardNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardNum.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardNum.setBounds(85, 5, 100, 40);
        contentPane.add(CardNum);

        JLabel CardStatusLabel = new JLabel("一卡通状态");
        CardStatusLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardStatusLabel.setBounds(200, 5, 100, 40);
        contentPane.add(CardStatusLabel);

        JLabel CardStatus = new JLabel("正常");
        CardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardStatus.setBounds(260, 5, 100, 40);
        contentPane.add(CardStatus);

        JLabel CardBalanceLabel = new JLabel("一卡通余额");
        CardBalanceLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardBalanceLabel.setBounds(360, 5, 100, 40);
        contentPane.add(CardBalanceLabel);

        JLabel CardBalance = new JLabel("230.58");
        CardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardBalance.setBounds(430, 5, 100, 40);
        contentPane.add(CardBalance);

        JLabel CardOpLabel = new JLabel("一卡通业务");
        CardOpLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardOpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardOpLabel.setBounds(35, 55, 100, 40);
        contentPane.add(CardOpLabel);

        JLabel CardRechargeLabel = new JLabel("一卡通充值");
        CardRechargeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardRechargeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardRechargeLabel.setBounds(35, 85, 100, 40);
        contentPane.add(CardRechargeLabel);

        JLabel CardRechargeBankAccountLabel = new JLabel("绑定的银行账号");
        CardRechargeBankAccountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardRechargeBankAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardRechargeBankAccountLabel.setBounds(110, 85, 150, 40);
        contentPane.add(CardRechargeBankAccountLabel);

        JLabel CardRechargeBankAccount = new JLabel("6216631200002070838");
        CardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardRechargeBankAccount.setBounds(230, 85, 200, 40);
        contentPane.add(CardRechargeBankAccount);

        JLabel CardRechargeBankAccountPasswordLabel = new JLabel("银行账号密码");
        CardRechargeBankAccountPasswordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardRechargeBankAccountPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardRechargeBankAccountPasswordLabel.setBounds(110, 115, 150, 40);
        contentPane.add(CardRechargeBankAccountPasswordLabel);

        JTextField passwordField=new JTextField();
        passwordField.setText("请输入密码");
        passwordField.setBounds(250,122,160,30);
        contentPane.add(passwordField);

        /*JLabel CardRechargeBankAccountPassword = new JLabel("●●●●●●");
        CardRechargeBankAccountPassword.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardRechargeBankAccountPassword.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardRechargeBankAccountPassword.setBounds(230, 115, 200, 40);
        contentPane.add(CardRechargeBankAccountPassword);
*/

        JLabel CardRechargeAmountLabel = new JLabel("充值金额");
        CardRechargeAmountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardRechargeAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardRechargeAmountLabel.setBounds(110, 145, 150, 40);
        contentPane.add(CardRechargeAmountLabel);

        JTextField amountField=new JTextField();
        amountField.setText("请输入充值金额");
        amountField.setBounds(250,152,160,30);
        contentPane.add(amountField);

        JButton CardRechargeButton=new JButton("确认充值");
        contentPane.add(CardRechargeButton);
        CardRechargeButton.setBounds(220,190,90,25);

        JLabel CardLossReportLabel = new JLabel("一卡通挂失");
        CardLossReportLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardLossReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardLossReportLabel.setBounds(35, 235, 100, 40);
        contentPane.add(CardLossReportLabel);

        JTextField lossReportField=new JTextField();
        lossReportField.setText("挂失说明（非必要）");
        lossReportField.setBounds(145,242,160,30);
        contentPane.add(lossReportField);

        JButton CardLossReportButton=new JButton("确认挂失");
        contentPane.add(CardLossReportButton);
        CardLossReportButton.setBounds(320,245,90,25);

        JLabel CardFoundReportLabel = new JLabel("一卡通解挂");
        CardFoundReportLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardFoundReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardFoundReportLabel.setBounds(35, 285, 100, 40);
        contentPane.add(CardFoundReportLabel);

        JTextField foundReportField=new JTextField();
        foundReportField.setText("挂失说明（非必要）");
        foundReportField.setBounds(145,292,160,30);
        contentPane.add(foundReportField);

        JButton CardFoundReportButton=new JButton("确认解挂");
        contentPane.add(CardFoundReportButton);
        CardFoundReportButton.setBounds(320,295,90,25);

        JTable table=new JTable(5,6);
        JScrollPane pane=new JScrollPane(table);

    }
}
