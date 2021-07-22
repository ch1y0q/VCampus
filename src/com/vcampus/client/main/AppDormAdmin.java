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
        jp1.setLayout(null);
        jp1.setBackground(new Color(240, 255, 240));
        jp2.setLayout(null);
        jp2.setBackground(new Color(240, 255, 240));

        tabbedPane = new JTabbedPane();
        tabbedPane.add("宿舍信息管理",jp1);
        tabbedPane.add("宿舍报修处理",jp2);
        tabbedPane.setBounds(0,0,2000,1100);
        this.add(tabbedPane);

        JLabel lblDormHygieneMarkEntering = new JLabel("宿舍卫生分数录入");
        lblDormHygieneMarkEntering.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormHygieneMarkEntering.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormHygieneMarkEntering.setBounds(210, 70, 250, 40);
        jp1.add(lblDormHygieneMarkEntering);

        JComboBox cmbDormHygieneMarkWeek=new JComboBox();
        for(int i=1;i<17;i++) {
            cmbDormHygieneMarkWeek.addItem("第"+i+"周");
        }
        cmbDormHygieneMarkWeek.setBounds(430,77,100,30);
        jp1.add(cmbDormHygieneMarkWeek);

        JTable tblDormHygieneMark=new JTable(10,3);
        tblDormHygieneMark.setBounds(210,170,400,500);
        tblDormHygieneMark.setFont((new Font("微软雅黑", Font.PLAIN, 16)));
        tblDormHygieneMark.setRowHeight(50);
        tblDormHygieneMark.getModel().setValueAt("宿舍号",0,0);
        tblDormHygieneMark.getModel().setValueAt("分数",0,1);
        tblDormHygieneMark.getModel().setValueAt("周数",0,2);
        DefaultTableCellRenderer rHygieneMark =new DefaultTableCellRenderer();
        rHygieneMark.setHorizontalAlignment(JLabel.CENTER);
        tblDormHygieneMark.setDefaultRenderer(Object.class,rHygieneMark);
        jp1.add(tblDormHygieneMark);

        JLabel lblDormBillEntering = new JLabel("宿舍水电费录入");
        lblDormBillEntering.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDormBillEntering.setHorizontalAlignment(SwingConstants.CENTER);
        lblDormBillEntering.setBounds(830, 70, 250, 40);
        jp1.add(lblDormBillEntering);

        JComboBox cmbDormBill=new JComboBox();
        for(int i=1;i<13;i++) {
            cmbDormBill.addItem("第"+i+"月");
        }
        cmbDormBill.setBounds(1050,77,100,30);
        jp1.add(cmbDormBill);

        JTable tblDormBill=new JTable(10,4);
        tblDormBill.setBounds(750,170,600,500);
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

        //jp1结束

        JTable tblDormRepairState=new JTable(10,5);
        tblDormRepairState.setBounds(250,150,1000,500);
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
    }
}
