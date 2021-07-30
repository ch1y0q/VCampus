package com.vcampus.client.main.shop;

import com.alee.managers.style.StyleId;
import com.vcampus.client.main.App;
import com.vcampus.client.main.manager.ManCategory;
import com.vcampus.entity.Goods;
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

        JTree jt=new ManCategory().getJTree();
        jt.setBounds(0,60,200,400);
        jt.setBackground(new Color(240, 255, 240));
        contentPane.add(jt);

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

        /*
        JTable tblCommodityList=new JTable(6,6);
        tblCommodityList.setBounds(330,200,1000,35*6);
        tblCommodityList.setRowHeight(35);
        tblCommodityList.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tblCommodityList.getModel().setValueAt("商品编号",0,0);
        tblCommodityList.getModel().setValueAt("商品名称",0,1);
        tblCommodityList.getModel().setValueAt("售价",0,2);
        tblCommodityList.getModel().setValueAt("库存数量",0,4);
        tblCommodityList.getModel().setValueAt("是否下架",0,5);
        tblCommodityList.getModel().setValueAt("商品描述",0,3);
        tblCommodityList.setPreferredScrollableViewportSize(new Dimension(200, 100));
        DefaultTableCellRenderer rCommodityList =new DefaultTableCellRenderer();
        rCommodityList.setHorizontalAlignment(JLabel.CENTER);
        tblCommodityList.setDefaultRenderer(Object.class,rCommodityList);
        //JScrollPane scrollPane=new JScrollPane(tblCommodityList);
        contentPane.add(tblCommodityList);
        */
        /*
        JButton btnCommodityDelete=new JButton("删除选中商品");
        btnCommodityDelete.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnCommodityDelete);
        btnCommodityDelete.setBounds(1180,430,150,35);
         */
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
        scrollPane.setBounds(330,200,1000,35*6);
        contentPane.add(scrollPane);

        JLabel lblCommodityInfoDetail = new JLabel("商品详细信息");
        lblCommodityInfoDetail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommodityInfoDetail.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityInfoDetail.setBounds(180, 460, 190, 40);
        contentPane.add(lblCommodityInfoDetail);

        JLabel lblCommodityInfoNum = new JLabel("商品编号");
        lblCommodityInfoNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommodityInfoNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityInfoNum.setBounds(370, 460, 190, 40);
        contentPane.add(lblCommodityInfoNum);

        JTextField txtCommodityInfoNum=new JTextField();
        txtCommodityInfoNum.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommodityInfoNum.setBounds(520,467,160,30);
        contentPane.add(txtCommodityInfoNum);

        JLabel lblCommodityInfoName = new JLabel("名称");
        lblCommodityInfoName.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommodityInfoName.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityInfoName.setBounds(370, 510, 190, 40);
        contentPane.add(lblCommodityInfoName);

        JTextField txtCommodityInfoName=new JTextField();
        txtCommodityInfoName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommodityInfoName.setBounds(520,517,160,30);
        contentPane.add(txtCommodityInfoName);

        JLabel lblCommodityInfoPrice = new JLabel("售价");
        lblCommodityInfoPrice.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommodityInfoPrice.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityInfoPrice.setBounds(370, 560, 190, 40);
        contentPane.add(lblCommodityInfoPrice);

        JTextField txtCommodityInfoPrice=new JTextField();
        txtCommodityInfoPrice.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommodityInfoPrice.setBounds(520,567,160,30);
        contentPane.add(txtCommodityInfoPrice);

        JLabel lblCommodityInfoAmount = new JLabel("库存数量");
        lblCommodityInfoAmount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommodityInfoAmount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityInfoAmount.setBounds(370, 610, 190, 40);
        contentPane.add(lblCommodityInfoAmount);

        JTextField txtCommodityInfoAmount=new JTextField();
        txtCommodityInfoAmount.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommodityInfoAmount.setBounds(520,617,160,30);
        contentPane.add(txtCommodityInfoAmount);

        JLabel lblCommodityInfoSaleState = new JLabel("是否下架");
        lblCommodityInfoSaleState.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommodityInfoSaleState.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommodityInfoSaleState.setBounds(370, 660, 190, 40);
        contentPane.add(lblCommodityInfoSaleState);

        JTextField txtCommoditySaleState=new JTextField();
        txtCommoditySaleState.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommoditySaleState.setBounds(520,667,160,30);
        contentPane.add(txtCommoditySaleState);

        JLabel commodityPic = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/bg/bg3.jpg")));
        contentPane.add(commodityPic);
        commodityPic.setBounds(250, 500, 100, 100);

        JLabel lblCommoditySaleInfo = new JLabel("商品销售情况查询");
        lblCommoditySaleInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommoditySaleInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySaleInfo.setBounds(750, 460, 190, 40);
        contentPane.add(lblCommoditySaleInfo);

        JLabel lblCommoditySaleInfoMonth = new JLabel("月份选择");
        lblCommoditySaleInfoMonth.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommoditySaleInfoMonth.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySaleInfoMonth.setBounds(750, 510, 190, 40);
        contentPane.add(lblCommoditySaleInfoMonth);

        JComboBox cmbCommoditySaleInfoMonth=new JComboBox();
        for(int i=1;i<13;i++) {
            cmbCommoditySaleInfoMonth.addItem("第"+i+"月");
        }
        cmbCommoditySaleInfoMonth.setBounds(930,516,100,30);
        contentPane.add(cmbCommoditySaleInfoMonth);

        JLabel lblCommoditySaleInfoMonthAmount = new JLabel("月销售数");
        lblCommoditySaleInfoMonthAmount.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommoditySaleInfoMonthAmount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySaleInfoMonthAmount.setBounds(750, 560, 190, 40);
        contentPane.add(lblCommoditySaleInfoMonthAmount);

        JTextField txtCommoditySaleInfoMonthAmount=new JTextField();
        txtCommoditySaleInfoMonthAmount.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommoditySaleInfoMonthAmount.setBounds(900,567,160,30);
        contentPane.add(txtCommoditySaleInfoMonthAmount);

        JLabel lblCommoditySaleInfoMonthIncome = new JLabel("月销售额");
        lblCommoditySaleInfoMonthIncome.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommoditySaleInfoMonthIncome.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySaleInfoMonthIncome.setBounds(750, 610, 190, 40);
        contentPane.add(lblCommoditySaleInfoMonthIncome);

        JTextField txtCommoditySaleInfoMonthIncome=new JTextField();
        txtCommoditySaleInfoMonthIncome.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommoditySaleInfoMonthIncome.setBounds(900,617,160,30);
        contentPane.add(txtCommoditySaleInfoMonthIncome);

        JLabel lblCommoditySaleInfoMonthBenefit = new JLabel("月盈利");
        lblCommoditySaleInfoMonthBenefit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblCommoditySaleInfoMonthBenefit.setHorizontalAlignment(SwingConstants.CENTER);
        lblCommoditySaleInfoMonthBenefit.setBounds(750, 660, 190, 40);
        contentPane.add(lblCommoditySaleInfoMonthBenefit);

        JTextField txtCommoditySaleInfoMonthBenefit=new JTextField();
        txtCommoditySaleInfoMonthBenefit.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtCommoditySaleInfoMonthBenefit.setBounds(900,667,160,30);
        contentPane.add(txtCommoditySaleInfoMonthBenefit);

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

    }
}
