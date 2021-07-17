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

        JLabel lblCardNum = new JLabel("一卡通号");
        lblCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardNum.setBounds(5, 5, 100, 40);
        contentPane.add(lblCardNum);

        JLabel lblCurCardNum = new JLabel("213191111");
        lblCurCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCurCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardNum.setBounds(85, 5, 100, 40);
        contentPane.add(lblCurCardNum);

        JLabel lblCardStatus = new JLabel("一卡通状态");
        lblCardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardStatus.setBounds(200, 5, 100, 40);
        contentPane.add(lblCardStatus);

        JLabel lblCurCardStatus = new JLabel("正常");
        lblCurCardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCurCardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCurCardStatus.setBounds(260, 5, 100, 40);
        contentPane.add(lblCurCardStatus);

        JLabel lblCardBalance = new JLabel("一卡通余额");
        lblCardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardBalance.setBounds(360, 5, 100, 40);
        contentPane.add(lblCardBalance);

        JLabel lblCurCardBalance = new JLabel("230.58");
        lblCurCardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCurCardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCurCardBalance.setBounds(430, 5, 100, 40);
        contentPane.add(lblCurCardBalance);

        JLabel lblCardOp = new JLabel("一卡通业务");
        lblCardOp.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardOp.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardOp.setBounds(35, 55, 100, 40);
        contentPane.add(lblCardOp);

        JLabel lblCardRecharge = new JLabel("一卡通充值");
        lblCardRecharge.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardRecharge.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardRecharge.setBounds(35, 85, 100, 40);
        contentPane.add(lblCardRecharge);

        JLabel lblCardRechargeBankAccount = new JLabel("绑定的银行账号");
        lblCardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardRechargeBankAccount.setBounds(110, 85, 150, 40);
        contentPane.add(lblCardRechargeBankAccount);

        JLabel lblCurCardRechargeBankAccount = new JLabel("6216631200002070838");
        lblCurCardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCurCardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCurCardRechargeBankAccount.setBounds(230, 85, 200, 40);
        contentPane.add(lblCurCardRechargeBankAccount);

        JLabel lblCardRechargeBankAccountPassword = new JLabel("银行账号密码");
        lblCardRechargeBankAccountPassword.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardRechargeBankAccountPassword.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardRechargeBankAccountPassword.setBounds(110, 115, 150, 40);
        contentPane.add(lblCardRechargeBankAccountPassword);

        JPasswordField txtPassword=new JPasswordField();
        txtPassword.setText("");
        txtPassword.setBounds(250,122,160,30);
        contentPane.add(txtPassword);

        /*JLabel CardRechargeBankAccountPassword = new JLabel("●●●●●●");
        CardRechargeBankAccountPassword.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardRechargeBankAccountPassword.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardRechargeBankAccountPassword.setBounds(230, 115, 200, 40);
        contentPane.add(CardRechargeBankAccountPassword);
*/

        JLabel lblCardRechargeAmount = new JLabel("充值金额");
        lblCardRechargeAmount.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardRechargeAmount.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardRechargeAmount.setBounds(110, 145, 150, 40);
        contentPane.add(lblCardRechargeAmount);

        JTextField txtAmount=new JTextField();
        txtAmount.setText("请输入充值金额");
        txtAmount.setBounds(250,152,160,30);
        contentPane.add(txtAmount);

        JButton btnCardRecharge=new JButton("确认充值");
        contentPane.add(btnCardRecharge);
        btnCardRecharge.setBounds(220,190,90,25);

        JLabel lblCardLossReport = new JLabel("一卡通挂失");
        lblCardLossReport.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardLossReport.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardLossReport.setBounds(35, 235, 100, 40);
        contentPane.add(lblCardLossReport);

        JTextField txtLossReport=new JTextField();
        txtLossReport.setText("挂失说明（非必要）");
        txtLossReport.setBounds(145,242,160,30);
        contentPane.add(txtLossReport);

        JButton btnCardLossReport=new JButton("确认挂失");
        contentPane.add(btnCardLossReport);
        btnCardLossReport.setBounds(320,245,90,25);

        JLabel CardFoundReportLabel = new JLabel("一卡通解挂");
        CardFoundReportLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CardFoundReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardFoundReportLabel.setBounds(35, 285, 100, 40);
        contentPane.add(CardFoundReportLabel);

        JTextField txtFoundReport=new JTextField();
        txtFoundReport.setText("挂失说明（非必要）");
        txtFoundReport.setBounds(145,292,160,30);
        contentPane.add(txtFoundReport);

        JButton btnCardFoundReport=new JButton("确认解挂");
        contentPane.add(btnCardFoundReport);
        btnCardFoundReport.setBounds(320,295,90,25);

        JLabel lblWaterBillTable = new JLabel("一卡通交易记录");
        lblWaterBillTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblWaterBillTable.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblWaterBillTable.setBounds(520, 80, 150, 40);
        contentPane.add(lblWaterBillTable);

        JTable tblWaterBill=new JTable(10,3);
        tblWaterBill.setBounds(500,120,200,200);
        tblWaterBill.setRowHeight(20);
        tblWaterBill.getModel().setValueAt("时间",0,0);
        tblWaterBill.getModel().setValueAt("金额",0,1);
        tblWaterBill.getModel().setValueAt("属性",0,2);
        contentPane.add(tblWaterBill);
    }
}
