package com.vcampus.client.main;

import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;


public class AppShopAdmin extends JFrame {
    private static JPanel contentPane;
    public AppShopAdmin(){
        setResizable(false);
        setTitle("商店管理系统 - Vcampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCommoditySearch = new JLabel("商品查询");
        lblCommoditySearch.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommoditySearch.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySearch.setBounds(70, 60, 100, 40);
        contentPane.add(lblCommoditySearch);

        JTextField txtCommoditySearch=new JTextField("输入商品编号...");
        txtCommoditySearch.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommoditySearch.setBounds(190,67,160,30);
        contentPane.add(txtCommoditySearch);

        JButton btnCommoditySearch=new JButton("查询");
        btnCommoditySearch.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnCommoditySearch);
        btnCommoditySearch.setBounds(385,67,100,30);

        JButton btnCommodityEntering=new JButton("商品信息录入...");
        btnCommodityEntering.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnCommodityEntering);
        btnCommodityEntering.setBounds(80,122,140,30);

        JTable tblCommodityList=new JTable(6,6);
        tblCommodityList.setBounds(130,200,1200,35*6);
        tblCommodityList.setRowHeight(35);
        tblCommodityList.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tblCommodityList.getModel().setValueAt("商品编号",0,0);
        tblCommodityList.getModel().setValueAt("商品名称",0,1);
        tblCommodityList.getModel().setValueAt("售价",0,2);
        tblCommodityList.getModel().setValueAt("成本",0,3);
        tblCommodityList.getModel().setValueAt("库存",0,4);
        tblCommodityList.getModel().setValueAt("是否下架",0,5);
        tblCommodityList.setPreferredScrollableViewportSize(new Dimension(200, 100));
        DefaultTableCellRenderer rCommodityList =new DefaultTableCellRenderer();
        rCommodityList.setHorizontalAlignment(JLabel.CENTER);
        tblCommodityList.setDefaultRenderer(Object.class,rCommodityList);
        //JScrollPane scrollPane=new JScrollPane(tblCommodityList);
        contentPane.add(tblCommodityList);


    }
}
