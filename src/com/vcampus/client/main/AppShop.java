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

        JLabel lblCommoditySearch = new JLabel("商品查询");
        lblCommoditySearch.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommoditySearch.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySearch.setBounds(15, 15, 100, 40);
        contentPane.add(lblCommoditySearch);

        JTextField txtCommoditySearch=new JTextField();
        txtCommoditySearch.setBounds(110,21,160,30);
        contentPane.add(txtCommoditySearch);

        JLabel lblCommodityKind = new JLabel("商品种类");
        lblCommodityKind.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommodityKind.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityKind.setBounds(300, 15, 100, 40);
        contentPane.add(lblCommodityKind);

        JComboBox cmbCommodityKind=new JComboBox();
        cmbCommodityKind.addItem("食品");
        cmbCommodityKind.addItem("日化");
        cmbCommodityKind.addItem("文具");
        cmbCommodityKind.setBounds(400,21,100,30);
        contentPane.add(cmbCommodityKind);

        JTable tblCommodityList=new JTable(10,2);
        tblCommodityList.setBounds(50,100,200,200);
        tblCommodityList.setRowHeight(20);
        tblCommodityList.getModel().setValueAt("商品名称",0,0);
        tblCommodityList.getModel().setValueAt("价格",0,1);
        tblCommodityList.setPreferredScrollableViewportSize(new Dimension(200, 100));
        JScrollPane scrollPane=new JScrollPane(tblCommodityList);
        contentPane.add(tblCommodityList);

        JLabel lblCommodityPic = new JLabel("商品图片");
        lblCommodityPic.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommodityPic.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityPic.setBounds(300, 80, 100, 40);
        contentPane.add(lblCommodityPic);

        JLabel commodityPic = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/bg/bg3.jpg")));
        contentPane.add(commodityPic);
        commodityPic.setBounds(500, 120, 100, 100);

        JLabel lblCommodityInfo = new JLabel("商品信息");
        lblCommodityInfo.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommodityInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityInfo.setBounds(300, 225, 100, 40);
        contentPane.add(lblCommodityInfo);

        JLabel lblCommoditySpInfo = new JLabel("商品详细信息");
        lblCommoditySpInfo.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommoditySpInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySpInfo.setBounds(350, 275, 100, 40);
        contentPane.add(lblCommoditySpInfo);

        JTextArea commodityDetail= new JTextArea("这里应该是商品详细信息",8,30);
        commodityDetail.setLineWrap(true);
        commodityDetail.setFont(new Font("微软雅黑",Font.PLAIN,14));
        commodityDetail.setBounds(475,285,150,75);
        contentPane.add(commodityDetail);

        JLabel lblCommodityNum = new JLabel("购买数量");
        lblCommodityNum.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblCommodityNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityNum.setBounds(350, 370, 100, 40);
        contentPane.add(lblCommodityNum);

        JTextField txtCommodityNum=new JTextField();
        txtCommodityNum.setBounds(470,375,160,30);
        contentPane.add(txtCommodityNum);

        JButton btnAddToCart=new JButton("添加到购物车");
        contentPane.add(btnAddToCart);
        btnAddToCart.setBounds(500,420,90,25);
    }
}
