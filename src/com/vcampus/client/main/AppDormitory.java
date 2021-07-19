package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Y
 * @date 2021/7/14
 */
public class AppDormitory extends JFrame{
    private JPanel contentPane;
    public static JLabel lblBalance;
    public AppDormitory(){
        setResizable(true);
        setTitle("宿舍管理中心 - VCampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCardNum = new JLabel("宿舍号");
        lblCardNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCardNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCardNum.setBounds(5, 5, 100, 40);
        contentPane.add(lblCardNum);

        JLabel lblCurDormNum = new JLabel("M5C2412");
        lblCurDormNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCurDormNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurDormNum.setBounds(75, 5, 100, 40);
        contentPane.add(lblCurDormNum);

        JLabel lblDormInfo = new JLabel("宿舍信息查询");
        lblDormInfo.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormInfo.setBounds(40, 60, 100, 40);
        contentPane.add(lblDormInfo);

        JLabel lblDormHygieneRate = new JLabel("卫生分数查询");
        lblDormHygieneRate.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormHygieneRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneRate.setBounds(40, 105, 100, 40);
        contentPane.add(lblDormHygieneRate);

        JComboBox cmbDormHygieneRateWeek=new JComboBox();
        for(int i=1;i<17;i++) {
            cmbDormHygieneRateWeek.addItem("第"+i+"周");
        }
        cmbDormHygieneRateWeek.setBounds(150,111,100,30);
        contentPane.add(cmbDormHygieneRateWeek);

        JTextField txtDormHygieneRate=new JTextField();
        txtDormHygieneRate.setBounds(265,111,60,30);
        contentPane.add(txtDormHygieneRate);

        JLabel lblDormWaterRate = new JLabel("水费查询");
        lblDormWaterRate.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormWaterRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormWaterRate.setBounds(40, 150, 100, 40);
        contentPane.add(lblDormWaterRate);

        JComboBox cmbDormWaterRateMonth=new JComboBox();
        for(int i=1;i<13;i++) {
            cmbDormWaterRateMonth.addItem("第"+i+"月");
        }
        cmbDormWaterRateMonth.setBounds(150,156,100,30);
        contentPane.add(cmbDormWaterRateMonth);

        JTextField txtDormWaterRate=new JTextField();
        txtDormWaterRate.setBounds(265,156,60,30);
        contentPane.add(txtDormWaterRate);

        JLabel lblDormElectricityRate = new JLabel("电费查询");
        lblDormElectricityRate.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormElectricityRate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormElectricityRate.setBounds(40, 195, 100, 40);
        contentPane.add(lblDormElectricityRate);

        JComboBox cmbDormElectricityRateMonth=new JComboBox();
        for(int i=1;i<13;i++) {
            cmbDormElectricityRateMonth.addItem("第"+i+"月");
        }
        cmbDormElectricityRateMonth.setBounds(150,201,100,30);
        contentPane.add(cmbDormElectricityRateMonth);

        JTextField txtDormElectricityRate=new JTextField();
        txtDormElectricityRate.setBounds(265,201,60,30);
        contentPane.add(txtDormElectricityRate);

        JLabel lblDormRepairReport = new JLabel("宿舍报修");
        lblDormRepairReport.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormRepairReport.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReport.setBounds(390, 60, 100, 40);
        contentPane.add(lblDormRepairReport);

        JLabel lblDormRepairReportThing = new JLabel("报修内容");
        lblDormRepairReportThing.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormRepairReportThing.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportThing.setBounds(390, 100, 100, 40);
        contentPane.add(lblDormRepairReportThing);

        JTextField txtDormRepairReport=new JTextField();
        txtDormRepairReport.setBounds(500,106,150,30);
        contentPane.add(txtDormRepairReport);

        JLabel lblDormRepairReportDate = new JLabel("报修日期");
        lblDormRepairReportDate.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormRepairReportDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportDate.setBounds(390, 140, 100, 40);
        contentPane.add(lblDormRepairReportDate);

        JTextField txtDormRepairReportDate=new JTextField();
        txtDormRepairReportDate.setBounds(500,146,150,30);
        contentPane.add(txtDormRepairReportDate);

        JLabel lblDormRepairReportDetail = new JLabel("具体信息");
        lblDormRepairReportDetail.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormRepairReportDetail.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportDetail.setBounds(390, 180, 100, 40);
        contentPane.add(lblDormRepairReportDetail);

        JTextField txtDormRepairReportDetail=new JTextField();
        txtDormRepairReportDetail.setBounds(500,186,150,30);
        contentPane.add(txtDormRepairReportDetail);

        JButton btnCardLossReport=new JButton("确认报修");
        contentPane.add(btnCardLossReport);
        btnCardLossReport.setBounds(490,230,90,25);

        JLabel lblDormRepairReportHistory = new JLabel("报修历史");
        lblDormRepairReportHistory.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblDormRepairReportHistory.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairReportHistory.setBounds(390, 260, 100, 40);
        contentPane.add(lblDormRepairReportHistory);

        JTable tblWaterBill=new JTable(6,3);
        tblWaterBill.setBounds(430,310,300,120);
        tblWaterBill.setRowHeight(20);
        tblWaterBill.getModel().setValueAt("时间",0,0);
        tblWaterBill.getModel().setValueAt("内容",0,1);
        tblWaterBill.getModel().setValueAt("状态",0,2);
        contentPane.add(tblWaterBill);
        

    }
}
