package com.vcampus.client.main.shop;

import com.alee.managers.style.StyleId;
import com.vcampus.client.main.App;
import com.vcampus.client.main.manager.ManCategory;
import com.vcampus.entity.Goods;
import com.vcampus.client.main.shop.AppShopHelper;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

/**
 * 管理员角色的商店
 * @author Franklin Yang, Huang Qiyue
 */
public class AppShopAdmin extends JFrame {
    private List<Goods> list = null;
    private DefaultTableModel tableModel=new DefaultTableModel();
    private static JPanel contentPane;
    private JTable tblCommodityList;
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
        /*
        JTree jt=new ManCategory().getJTree();
        jt.setBounds(0,60,200,400);
        jt.setBackground(new Color(240, 255, 240));
        contentPane.add(jt);


         */
        JLabel lblCommoditySearch = new JLabel("商品查询");
        lblCommoditySearch.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommoditySearch.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySearch.setBounds(270, 60, 100, 40);
        contentPane.add(lblCommoditySearch);

        JTextField txtCommoditySearch=new JTextField("输入商品名称...");
        txtCommoditySearch.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommoditySearch.setBounds(390,67,160,30);
        contentPane.add(txtCommoditySearch);

        JButton btnCommoditySearch=new JButton("查询");
        btnCommoditySearch.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnCommoditySearch);
        btnCommoditySearch.setBounds(585,67,100,30);

        JButton btnCommodityEntering=new JButton("商品信息录入...");
        btnCommodityEntering.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        btnCommodityEntering.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminAddItemDiag dialog = new AdminAddItemDiag();
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        contentPane.add(btnCommodityEntering);
        btnCommodityEntering.setBounds(280,122,140,30);

        String[] header = {"商品编号", "商品名称","售价","商品描述","库存数量","是否下架"};
        tblCommodityList = new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        tblCommodityList.putClientProperty ( StyleId.STYLE_PROPERTY, "table" );
        tblCommodityList.setAutoResizeMode ( JTable.AUTO_RESIZE_ALL_COLUMNS );
        tblCommodityList.setRowSelectionAllowed(true);
        tblCommodityList.setCellSelectionEnabled(false);
        tblCommodityList.setRowHeight(35);
        tblCommodityList.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tblCommodityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblCommodityList.setPreferredScrollableViewportSize(new Dimension(200, 100));
        DefaultTableCellRenderer rGoodsList = new DefaultTableCellRenderer();
        rGoodsList.setHorizontalAlignment(JLabel.CENTER);
        tblCommodityList.setDefaultRenderer(Object.class, rGoodsList);
        JScrollPane scrollPane=new JScrollPane(tblCommodityList);
        scrollPane.setBounds(330,200,1000,35*12);
        contentPane.add(scrollPane);

        JButton btnGoBack=new JButton("返回");
        btnGoBack.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnGoBack);
        btnGoBack.setBounds(685,67,100,30);
        btnGoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnCommoditySearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list= ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null,
                                "com.vcampus.server.shop.ShopServer.searchGoods",
                                new Object[] {txtCommoditySearch.getText()}).send())
                        .getListReturn(Goods.class);
                String[][] listData = new String[list.size()][6];
                tableModel.setRowCount(0);
                if (list == null) {
                    System.out.println("error");
                } else {
                    for (int i = 0; i < list.size(); i++)
                    {
                        listData[i][0]= String.valueOf(list.get(i).getId());
                        listData[i][1]=list.get(i).getName();
                        listData[i][2]= String.valueOf(list.get(i).getPrice());
                        listData[i][3]=list.get(i).getDescription();
                        listData[i][4]=String.valueOf(list.get(i).getRemaining());
                        listData[i][5]=list.get(i).getStatus();
                    }
                    tableModel = new DefaultTableModel(listData, header){
                        public boolean isCellEditable(int a, int b) {
                            return false;
                        }
                    };
                    tblCommodityList.setModel(tableModel);
                }
            }
        });

/*
        cmbCommoditySaleInfoMonth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String item=e.getItem().toString();
                switch (item){
                    case "第1月":
                       txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(1)));
                       txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(1)));
                    case "第2月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(2)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(2)));
                    case "第3月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(3)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(3)));
                    case "第4月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(4)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(4)));
                    case "第5月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(5)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(5)));
                    case "第6月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(6)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(6)));
                    case "第7月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(7)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(7)));
                    case "第8月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(8)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(8)));
                    case "第9月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(9)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(9)));
                    case "第10月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(10)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(10)));
                    case "第11月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(11)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(11)));
                    case "第12月":
                        txtCommoditySaleInfoMonthAmount.setText(String.valueOf(AppShopHelper.getMonthSum(12)));
                        txtCommoditySaleInfoMonthIncome.setText(String.valueOf(AppShopHelper.getMonthSaleMoney(12)));
                }
            }
        });

 */
    }
}
