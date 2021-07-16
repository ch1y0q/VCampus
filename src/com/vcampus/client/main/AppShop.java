package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Y
 * @date 2021/7/14
 */

public class AppShop extends JFrame {
    private JPanel contentPane;
    public static JLabel lblBalance;
    public AppShop(){
        JFrame jf=new JFrame();
        setResizable(true);
        setTitle("在线商店 - VCampus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel CommoditySearchLabel = new JLabel("商品查询");
        CommoditySearchLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CommoditySearchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        CommoditySearchLabel.setBounds(15, 15, 100, 40);
        contentPane.add(CommoditySearchLabel);

        JTextField CommoditySearchField=new JTextField();
        CommoditySearchField.setBounds(110,21,160,30);
        contentPane.add(CommoditySearchField);

        JLabel CommodityKindLabel = new JLabel("商品种类");
        CommodityKindLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CommodityKindLabel.setHorizontalAlignment(SwingConstants.CENTER);
        CommodityKindLabel.setBounds(300, 15, 100, 40);
        contentPane.add(CommodityKindLabel);

        JComboBox CommodityKindCB=new JComboBox();
        CommodityKindCB.addItem("食品");
        CommodityKindCB.addItem("日化");
        CommodityKindCB.addItem("文具");
        CommodityKindCB.setBounds(400,21,100,30);
        contentPane.add(CommodityKindCB);

        JTable CommodityListTable=new JTable(10,2);
        CommodityListTable.setBounds(50,100,200,200);
        CommodityListTable.setRowHeight(20);
        CommodityListTable.getModel().setValueAt("商品名称",0,0);
        CommodityListTable.getModel().setValueAt("价格",0,1);
        CommodityListTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
        JScrollPane scrollPane=new JScrollPane(CommodityListTable);
        contentPane.add(CommodityListTable);

        JLabel CommodityPicLabel = new JLabel("商品图片");
        CommodityPicLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CommodityPicLabel.setHorizontalAlignment(SwingConstants.CENTER);
        CommodityPicLabel.setBounds(300, 80, 100, 40);
        contentPane.add(CommodityPicLabel);

        JLabel CommodityPic = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/bg/bg3.jpg")));
        contentPane.add(CommodityPic);
        CommodityPic.setBounds(500, 120, 100, 100);

        JLabel CommodityInfoLabel = new JLabel("商品信息");
        CommodityInfoLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CommodityInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        CommodityInfoLabel.setBounds(300, 225, 100, 40);
        contentPane.add(CommodityInfoLabel);

        JLabel CommoditySpInfoLabel = new JLabel("商品详细信息");
        CommoditySpInfoLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CommoditySpInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        CommoditySpInfoLabel.setBounds(350, 275, 100, 40);
        contentPane.add(CommoditySpInfoLabel);

        JTextArea CommoditySpInfo= new JTextArea("这里应该是商品详细信息",8,30);
        CommoditySpInfo.setLineWrap(true);
        CommoditySpInfo.setFont(new Font("微软雅黑",Font.PLAIN,14));
        CommoditySpInfo.setBounds(475,285,150,75);
        contentPane.add(CommoditySpInfo);

        JLabel CommodityNumLabel = new JLabel("购买数量");
        CommodityNumLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        CommodityNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        CommodityNumLabel.setBounds(350, 370, 100, 40);
        contentPane.add(CommodityNumLabel);

        JTextField CommodityNumField=new JTextField();
        CommodityNumField.setBounds(470,375,160,30);
        contentPane.add(CommodityNumField);

        JButton AddToCartButton=new JButton("添加到购物车");
        contentPane.add(AddToCartButton);
        AddToCartButton.setBounds(500,420,90,25);
    }
}
