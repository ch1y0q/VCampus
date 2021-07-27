package com.vcampus.client.main;

import com.vcampus.client.main.manager.ManCategory;

import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Y
 * @date 2021/7/22
 */

public class AppDormAdmin extends JFrame {
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1,jp2;
    public AppDormAdmin(){
        setResizable(false);
        setTitle("宿舍管理 - Vcampus");
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

        JTree jt=new ManCategory().init();
        jt.setBackground(new Color(240, 255, 240));
        jt.setBounds(0,60,200,400);
        contentPane.add(jt);

        jp1.setLayout(null);
        jp1.setBackground(new Color(240, 255, 240));
        jp2.setLayout(null);
        jp2.setBackground(new Color(240, 255, 240));

        tabbedPane = new JTabbedPane();
        tabbedPane.add("宿舍信息管理",jp1);
        tabbedPane.add("宿舍报修处理",jp2);
        tabbedPane.setBounds(200,0,2000,1100);
        this.add(tabbedPane);

        JLabel lblDormHygieneMarkEntering = new JLabel("宿舍卫生分数录入");
        lblDormHygieneMarkEntering.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormHygieneMarkEntering.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneMarkEntering.setBounds(80, 190, 250, 40);
        jp1.add(lblDormHygieneMarkEntering);

        JComboBox cmbDormHygieneMarkWeek=new JComboBox();
        for(int i=1;i<17;i++) {
            cmbDormHygieneMarkWeek.addItem("第"+i+"周");
        }
        cmbDormHygieneMarkWeek.setBounds(300,197,100,30);
        /*
        cmbDormHygieneMarkWeek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String weekText=cmbDormHygieneMarkWeek.getSelectedItem().toString();
                int weekNo=Integer.valueOf(weekText.substring(1,2));
                System.out.println(weekNo);
            }
        });
         */
        jp1.add(cmbDormHygieneMarkWeek);

        JLabel lblDormHygieneMarkEnteringDormAddress = new JLabel("宿舍号");
        lblDormHygieneMarkEnteringDormAddress.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormHygieneMarkEnteringDormAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneMarkEnteringDormAddress.setBounds(80, 260, 250, 40);
        jp1.add(lblDormHygieneMarkEnteringDormAddress);

        JTextField txtDormHygieneRateEnteringDormAddress = new JTextField();
        txtDormHygieneRateEnteringDormAddress.setBounds(300, 266, 100, 30);
        jp1.add(txtDormHygieneRateEnteringDormAddress);

        JTable tblDormHygieneMark=new JTable(2,3);
        tblDormHygieneMark.setBounds(60,420,400,100);
        tblDormHygieneMark.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        tblDormHygieneMark.setRowHeight(50);
        tblDormHygieneMark.getModel().setValueAt("宿舍号",0,0);
        tblDormHygieneMark.getModel().setValueAt("分数",0,1);
        tblDormHygieneMark.getModel().setValueAt("周数",0,2);
        DefaultTableCellRenderer rHygieneMark =new DefaultTableCellRenderer();
        rHygieneMark.setHorizontalAlignment(JLabel.CENTER);
        tblDormHygieneMark.setDefaultRenderer(Object.class,rHygieneMark);
        jp1.add(tblDormHygieneMark);

        JButton btnDormHygieneRateLookUp = new JButton("查询");
        btnDormHygieneRateLookUp.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        jp1.add(btnDormHygieneRateLookUp);
        btnDormHygieneRateLookUp.setBounds(220, 337, 100, 30);
        
        JLabel lblDormHygieneMarkEnteringMark = new JLabel("分数");
        lblDormHygieneMarkEnteringMark.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormHygieneMarkEnteringMark.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneMarkEnteringMark.setBounds(30, 580, 250, 40);
        jp1.add(lblDormHygieneMarkEnteringMark);

        JTextField txtDormHygieneRateEnteringMark = new JTextField();
        txtDormHygieneRateEnteringMark.setBounds(205, 586, 90, 30);
        jp1.add(txtDormHygieneRateEnteringMark);

        JButton btnDormHygieneRateEntering = new JButton("录入");
        btnDormHygieneRateEntering.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        jp1.add(btnDormHygieneRateEntering);
        btnDormHygieneRateEntering.setBounds(330, 586, 100, 30);
        



        JLabel lblDormBillEntering = new JLabel("宿舍水电费录入");
        lblDormBillEntering.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormBillEntering.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormBillEntering.setBounds(630, 190, 250, 40);
        jp1.add(lblDormBillEntering);

        JComboBox cmbDormBill=new JComboBox();
        for(int i=1;i<13;i++) {
            cmbDormBill.addItem("第"+i+"月");
        }
        cmbDormBill.setBounds(850,197,100,30);
        jp1.add(cmbDormBill);

        JLabel lblDormWaterElectricityRateEnteringDormAddress = new JLabel("宿舍号");
        lblDormWaterElectricityRateEnteringDormAddress.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormWaterElectricityRateEnteringDormAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormWaterElectricityRateEnteringDormAddress.setBounds(630, 260, 250, 40);
        jp1.add(lblDormWaterElectricityRateEnteringDormAddress);

        JTextField txtDormWaterElectricityRateEnteringDormAddress = new JTextField();
        txtDormWaterElectricityRateEnteringDormAddress.setBounds(850, 266, 100, 30);
        jp1.add(txtDormWaterElectricityRateEnteringDormAddress);

        JTable tblDormBill=new JTable(2,4);
        tblDormBill.setBounds(550,420,600,100);
        tblDormBill.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        tblDormBill.setRowHeight(50);
        tblDormBill.getModel().setValueAt("宿舍号",0,0);
        tblDormBill.getModel().setValueAt("水费",0,1);
        tblDormBill.getModel().setValueAt("电费",0,2);
        tblDormBill.getModel().setValueAt("月份",0,3);
        DefaultTableCellRenderer rDormBill =new DefaultTableCellRenderer();
        rDormBill.setHorizontalAlignment(JLabel.CENTER);
        tblDormBill.setDefaultRenderer(Object.class,rDormBill);
        jp1.add(tblDormBill);

        JButton btnDormWaterElectricityRateLookUp = new JButton("查询");
        btnDormWaterElectricityRateLookUp.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        jp1.add(btnDormWaterElectricityRateLookUp);
        btnDormWaterElectricityRateLookUp.setBounds(770, 337, 100, 30);

        JLabel lblDormWaterElectricityRateEntering = new JLabel("分数");
        lblDormWaterElectricityRateEntering.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormWaterElectricityRateEntering.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormWaterElectricityRateEntering.setBounds(580, 580, 250, 40);
        jp1.add(lblDormWaterElectricityRateEntering);

        JTextField txtDormWaterElectricityRateEntering = new JTextField();
        txtDormWaterElectricityRateEntering.setBounds(755, 586, 90, 30);
        jp1.add(txtDormWaterElectricityRateEntering);

        JButton btnDormWaterElectricityRateEntering = new JButton("录入");
        btnDormWaterElectricityRateEntering.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        jp1.add(btnDormWaterElectricityRateEntering);
        btnDormWaterElectricityRateEntering.setBounds(880, 586, 100, 30);

        //jp1结束

        JTable tblDormRepairState=new JTable(6,5);
        tblDormRepairState.setBounds(50,150,1000,300);
        tblDormRepairState.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        tblDormRepairState.setRowHeight(50);
        tblDormRepairState.getModel().setValueAt("宿舍号",0,0);
        tblDormRepairState.getModel().setValueAt("报修时间",0,1);
        tblDormRepairState.getModel().setValueAt("报修内容",0,2);
        tblDormRepairState.getModel().setValueAt("报修详细信息",0,3);
        tblDormRepairState.getModel().setValueAt("报修状态",0,4);
        DefaultTableCellRenderer rDormRepairState =new DefaultTableCellRenderer();
        rDormRepairState.setHorizontalAlignment(JLabel.CENTER);
        tblDormRepairState.setDefaultRenderer(Object.class,rDormRepairState);
        jp2.add(tblDormRepairState);

        JLabel lblDormRepairStateUpdate = new JLabel("修改表中第                          条的报修状态为");
        lblDormRepairStateUpdate.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormRepairStateUpdate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormRepairStateUpdate.setBounds(160, 520, 450, 40);
        jp2.add(lblDormRepairStateUpdate);

        JTextField txtDormRepairStateUpdateNoSelect = new JTextField();
        txtDormRepairStateUpdateNoSelect.setBounds(325, 526, 90, 30);
        jp2.add(txtDormRepairStateUpdateNoSelect);

        JComboBox cmbDormRepairStatus=new JComboBox();
        cmbDormRepairStatus.addItem("已修理");
        cmbDormRepairStatus.addItem("未修理");
        cmbDormRepairStatus.setBounds(600,526,100,30);
        jp2.add(cmbDormRepairStatus);

        JButton btnDormRepairStatusUpdate = new JButton("确认");
        btnDormRepairStatusUpdate.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        jp2.add(btnDormRepairStatusUpdate);
        btnDormRepairStatusUpdate.setBounds(780, 526, 100, 30);
    }
}
