package com.vcampus.client.main;

import org.apache.ibatis.jdbc.Null;

import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

/**
 * @author Y
 * @date 2021/7/21
 */

public class AppLife extends JFrame{
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1,jp2;
    public AppLife(){
        setResizable(false);
        setTitle("生活服务 - Vcampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        jp1=new JPanel();
        jp2=new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jp1.setLayout(null);
        jp1.setBackground(new Color(240, 255, 240));
        jp2.setLayout(null);
        jp2.setBackground(new Color(240, 255, 240));

        tabbedPane = new JTabbedPane();
        tabbedPane.add("一卡通",jp1);
        tabbedPane.add("宿舍",jp2);
        tabbedPane.setBounds(0,0,2000,1100);
        this.add(tabbedPane);



        /*
        JLabel commodityPic = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/icon/bgcolor2.png")));
        jp1.add(commodityPic);
        commodityPic.setBounds(200, 200, 50, 50);
         */

        //一卡通部分开始 - jp1

        JLabel lblCardNum = new JLabel("一卡通号");
        lblCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardNum.setBounds(205, 30, 100, 40);
        jp1.add(lblCardNum);

        JLabel lblCurCardNum = new JLabel("213191111");
        lblCurCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardNum.setBounds(305, 30, 100, 40);
        jp1.add(lblCurCardNum);

        JLabel lblCardStatus = new JLabel("一卡通状态");
        lblCardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardStatus.setBounds(420, 30, 100, 40);
        jp1.add(lblCardStatus);

        JLabel lblCurCardStatus = new JLabel("正常");
        lblCurCardStatus.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardStatus.setBounds(500, 30, 100, 40);
        jp1.add(lblCurCardStatus);

        JLabel lblCardBalance = new JLabel("一卡通余额");
        lblCardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardBalance.setBounds(610, 30, 100, 40);
        jp1.add(lblCardBalance);

        JLabel lblCurCardBalance = new JLabel("230.58");
        lblCurCardBalance.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardBalance.setBounds(700, 30, 100, 40);
        jp1.add(lblCurCardBalance);

        JLabel lblCardOp = new JLabel("一卡通业务");
        lblCardOp.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardOp.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardOp.setBounds(450, 130, 100, 40);
        jp1.add(lblCardOp);



        JLabel lblCardRecharge = new JLabel("一卡通充值");
        lblCardRecharge.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRecharge.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRecharge.setBounds(235, 210, 100, 40);
        jp1.add(lblCardRecharge);

        JLabel lblCardRechargeBankAccount = new JLabel("绑定的银行账号");
        lblCardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRechargeBankAccount.setBounds(340, 210, 150, 40);
        jp1.add(lblCardRechargeBankAccount);

        JLabel lblCurCardRechargeBankAccount = new JLabel("6216631200002070838");
        lblCurCardRechargeBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurCardRechargeBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurCardRechargeBankAccount.setBounds(500, 210, 200, 40);
        jp1.add(lblCurCardRechargeBankAccount);

        JLabel lblCardRechargeBankAccountPassword = new JLabel("银行账号密码");
        lblCardRechargeBankAccountPassword.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRechargeBankAccountPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRechargeBankAccountPassword.setBounds(340, 260, 150, 40);
        jp1.add(lblCardRechargeBankAccountPassword);

        JPasswordField txtPassword=new JPasswordField();
        txtPassword.setText("");
        txtPassword.setBounds(515,267,160,30);
        jp1.add(txtPassword);

        JLabel lblCardRechargeAmount = new JLabel("充值金额");
        lblCardRechargeAmount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardRechargeAmount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardRechargeAmount.setBounds(340, 310, 150, 40);
        jp1.add(lblCardRechargeAmount);

        JTextField txtAmount=new JTextField();
        txtAmount.setText("");
        txtAmount.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        txtAmount.setBounds(515,317,160,30);
        jp1.add(txtAmount);

        JButton btnCardRecharge=new JButton("确认充值");
        btnCardRecharge.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        jp1.add(btnCardRecharge);
        btnCardRecharge.setBounds(460,380,110,35);

        JLabel lblCardLossReport = new JLabel("一卡通挂失");
        lblCardLossReport.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCardLossReport.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblCardLossReport.setBounds(235, 500, 100, 40);
        jp1.add(lblCardLossReport);

        JTextField txtLossReport=new JTextField();
        txtLossReport.setText("挂失说明（非必要）");
        txtLossReport.setFont((new Font("微软雅黑", Font.PLAIN, 14)));
        txtLossReport.setBounds(365,507,160,30);
        jp1.add(txtLossReport);

        JButton btnCardLossReport=new JButton("确认挂失");
        btnCardLossReport.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        jp1.add(btnCardLossReport);
        btnCardLossReport.setBounds(560,507,110,30);

        JLabel CardFoundReportLabel = new JLabel("一卡通解挂");
        CardFoundReportLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        CardFoundReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        CardFoundReportLabel.setBounds(235, 550, 100, 40);
        jp1.add(CardFoundReportLabel);

        JTextField txtFoundReport=new JTextField();
        txtFoundReport.setText("解挂说明（非必要）");
        txtFoundReport.setFont((new Font("微软雅黑", Font.PLAIN, 14)));
        txtFoundReport.setBounds(365,557,160,30);
        jp1.add(txtFoundReport);

        JButton btnCardFoundReport=new JButton("确认解挂");
        btnCardFoundReport.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        jp1.add(btnCardFoundReport);
        btnCardFoundReport.setBounds(560,557,110,30);

        JLabel lblWaterBillTable = new JLabel("一卡通交易记录");
        lblWaterBillTable.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblWaterBillTable.setHorizontalAlignment(SwingConstants.CENTER);
        //lblNewLabel_1.setIcon(new ImageIcon(AppStudent.class.getResource("/resources/assets/icon/aboutme.png")));
        lblWaterBillTable.setBounds(1020, 130, 150, 40);
        jp1.add(lblWaterBillTable);

        JTable tblWaterBill=new JTable(10,3);
        tblWaterBill.setBounds(800,180,600,500);
        tblWaterBill.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        tblWaterBill.setRowHeight(50);
        tblWaterBill.getModel().setValueAt("时间",0,0);
        tblWaterBill.getModel().setValueAt("金额",0,1);
        tblWaterBill.getModel().setValueAt("属性",0,2);
        DefaultTableCellRenderer rWaterBill =new DefaultTableCellRenderer();
        rWaterBill.setHorizontalAlignment(JLabel.CENTER);
        tblWaterBill.setDefaultRenderer(Object.class,rWaterBill);
        jp1.add(tblWaterBill);

        //一卡通部分结束

        //宿舍部分开始 - jp2

        JLabel lblDormNum = new JLabel("宿舍号");
        lblDormNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormNum.setBounds(225, 30, 100, 40);
        jp2.add(lblDormNum);

        JLabel lblCurDormNum = new JLabel("M5C2412");
        lblCurDormNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCurDormNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurDormNum.setBounds(315, 30, 100, 40);
        jp2.add(lblCurDormNum);

        JLabel lblDormInfo = new JLabel("宿舍信息查询");
        lblDormInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormInfo.setBounds(380, 100, 150, 40);
        jp2.add(lblDormInfo);

        JLabel lblDormHygieneRate = new JLabel("卫生分数查询");
        lblDormHygieneRate.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormHygieneRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneRate.setBounds(250, 160, 150, 40);
        jp2.add(lblDormHygieneRate);

        JComboBox cmbDormHygieneRateWeek=new JComboBox();
        for(int i=1;i<17;i++) {
            cmbDormHygieneRateWeek.addItem("第"+i+"周");
        }
        cmbDormHygieneRateWeek.setBounds(420,166,100,30);
        jp2.add(cmbDormHygieneRateWeek);

        JTextField txtDormHygieneRate=new JTextField();
        txtDormHygieneRate.setBounds(560,166,70,30);
        jp2.add(txtDormHygieneRate);

        JLabel lblDormWaterRate = new JLabel("水费查询");
        lblDormWaterRate.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormWaterRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormWaterRate.setBounds(275, 210, 100, 40);
        jp2.add(lblDormWaterRate);

        JComboBox cmbDormWaterRateMonth=new JComboBox();
        for(int i=1;i<13;i++) {
            cmbDormWaterRateMonth.addItem("第"+i+"月");
        }
        cmbDormWaterRateMonth.setBounds(420,216,100,30);
        jp2.add(cmbDormWaterRateMonth);

        JTextField txtDormWaterRate=new JTextField();
        txtDormWaterRate.setBounds(560,216,70,30);
        jp2.add(txtDormWaterRate);

        JLabel lblDormElectricityRate = new JLabel("电费查询");
        lblDormElectricityRate.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormElectricityRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormElectricityRate.setBounds(275, 260, 100, 40);
        jp2.add(lblDormElectricityRate);

        JComboBox cmbDormElectricityRateMonth=new JComboBox();
        for(int i=1;i<13;i++) {
            cmbDormElectricityRateMonth.addItem("第"+i+"月");
        }
        cmbDormElectricityRateMonth.setBounds(420,266,100,30);
        jp2.add(cmbDormElectricityRateMonth);

        JTextField txtDormElectricityRate=new JTextField();
        txtDormElectricityRate.setBounds(560,266,70,30);
        jp2.add(txtDormElectricityRate);

        JLabel lblDormRepairReport = new JLabel("宿舍报修");
        lblDormRepairReport.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairReport.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReport.setBounds(405, 350, 100, 40);
        jp2.add(lblDormRepairReport);

        JLabel lblDormRepairReportThing = new JLabel("报修内容");
        lblDormRepairReportThing.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairReportThing.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportThing.setBounds(275, 420, 100, 40);
        jp2.add(lblDormRepairReportThing);

        JTextField txtDormRepairReport=new JTextField();
        txtDormRepairReport.setBounds(395,426,150,30);
        jp2.add(txtDormRepairReport);

        JLabel lblDormRepairReportDate = new JLabel("报修日期");
        lblDormRepairReportDate.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairReportDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportDate.setBounds(275, 470, 100, 40);
        jp2.add(lblDormRepairReportDate);

        JTextField txtDormRepairReportDate=new JTextField();
        txtDormRepairReportDate.setBounds(395,476,150,30);
        jp2.add(txtDormRepairReportDate);

        JLabel lblDormRepairReportDetail = new JLabel("具体信息");
        lblDormRepairReportDetail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairReportDetail.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportDetail.setBounds(275, 520, 100, 40);
        jp2.add(lblDormRepairReportDetail);

        JTextField txtDormRepairReportDetail=new JTextField();
        txtDormRepairReportDetail.setBounds(395,526,150,30);
        jp2.add(txtDormRepairReportDetail);

        JButton btnDormRepairReport=new JButton("确认报修");
        btnDormRepairReport.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jp2.add(btnDormRepairReport);
        btnDormRepairReport.setBounds(580,479,110,35);

        JLabel lblDormRepairReportHistory = new JLabel("报修历史");
        lblDormRepairReportHistory.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairReportHistory.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportHistory.setBounds(1000, 100, 100, 40);
        jp2.add(lblDormRepairReportHistory);

        JTable tblDormRepairHistory=new JTable(9,3);
        tblDormRepairHistory.setBounds(800,150,500,450);
        tblDormRepairHistory.setRowHeight(50);
        tblDormRepairHistory.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tblDormRepairHistory.getModel().setValueAt("时间",0,0);
        tblDormRepairHistory.getModel().setValueAt("内容",0,1);
        tblDormRepairHistory.getModel().setValueAt("状态",0,2);
        DefaultTableCellRenderer rDormRepairHistory =new DefaultTableCellRenderer();
        rDormRepairHistory.setHorizontalAlignment(JLabel.CENTER);
        tblDormRepairHistory.setDefaultRenderer(Object.class,rDormRepairHistory);
        jp2.add(tblDormRepairHistory);

        //宿舍部分结束



    }
}
