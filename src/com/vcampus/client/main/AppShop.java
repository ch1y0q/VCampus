package com.vcampus.client.main;

import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * @author Y
 * @date 2021/7/21
 */

public class AppShop extends JFrame {
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1,jp2;
    public AppShop(){
        setResizable(false);
        setTitle("商店 - Vcampus");
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

        JTextField txtCommoditySearch=new JTextField();
        txtCommoditySearch.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommoditySearch.setBounds(190,67,160,30);
        contentPane.add(txtCommoditySearch);

        JLabel lblCommodityKind = new JLabel("商品种类");
        lblCommodityKind.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommodityKind.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityKind.setBounds(420, 60, 100, 40);
        contentPane.add(lblCommodityKind);

        JComboBox cmbCommodityKind=new JComboBox();
        cmbCommodityKind.addItem("食品");
        cmbCommodityKind.addItem("日化");
        cmbCommodityKind.addItem("文具");
        cmbCommodityKind.setBounds(570,67,100,30);
        contentPane.add(cmbCommodityKind);

        JTable tblCommodityList=new JTable(12,2);
        tblCommodityList.setBounds(130,150,500,600);
        tblCommodityList.setRowHeight(50);
        tblCommodityList.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tblCommodityList.getModel().setValueAt("商品名称",0,0);
        tblCommodityList.getModel().setValueAt("价格",0,1);
        tblCommodityList.setPreferredScrollableViewportSize(new Dimension(200, 100));
        DefaultTableCellRenderer rCommodityList =new DefaultTableCellRenderer();
        rCommodityList.setHorizontalAlignment(JLabel.CENTER);
        tblCommodityList.setDefaultRenderer(Object.class,rCommodityList);
        //JScrollPane scrollPane=new JScrollPane(tblCommodityList);
        contentPane.add(tblCommodityList);

        JLabel lblCommodityPic = new JLabel("商品图片");
        lblCommodityPic.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommodityPic.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityPic.setBounds(1050, 150, 100, 40);
        contentPane.add(lblCommodityPic);

        JLabel commodityPic = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/bg/bg3.jpg")));
        contentPane.add(commodityPic);
        commodityPic.setBounds(1000, 200, 100, 100);

        JLabel lblCommodityInfo = new JLabel("商品信息");
        lblCommodityInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommodityInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityInfo.setBounds(1050, 345, 100, 40);
        contentPane.add(lblCommodityInfo);

        JLabel lblCommoditySpInfo = new JLabel("商品详细信息");
        lblCommoditySpInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommoditySpInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySpInfo.setBounds(850, 410, 200, 40);
        contentPane.add(lblCommoditySpInfo);

        JTextArea commodityDetail= new JTextArea("这里应该是商品详细信息",8,30);
        commodityDetail.setLineWrap(true);
        commodityDetail.setFont(new Font("微软雅黑",Font.PLAIN,18));
        commodityDetail.setBounds(1050,420,300,150);
        contentPane.add(commodityDetail);

        JLabel lblCommodityNum = new JLabel("购买数量");
        lblCommodityNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommodityNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityNum.setBounds(900, 610, 100, 40);
        contentPane.add(lblCommodityNum);

        JTextField txtCommodityNum=new JTextField();
        txtCommodityNum.setBounds(1100,615,160,30);
        contentPane.add(txtCommodityNum);

        JButton btnAddToCart=new JButton("确认购买");
        btnAddToCart.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnAddToCart);
        btnAddToCart.setBounds(1050,700,110,35);
    }
}
