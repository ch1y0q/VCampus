package com.vcampus.client.main.shop;

import com.alee.managers.style.StyleId;
import com.vcampus.client.main.App;
import com.vcampus.entity.Goods;
import com.vcampus.entity.UserType;
import com.vcampus.entity.GoodsHistory;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;
import com.vcampus.util.SwingUtils;

import static com.vcampus.client.main.shop.AppShopHelper.*;
import static com.vcampus.entity.UserType.STUDENT;
import static com.vcampus.entity.UserType.TEACHER;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;

/**
 * 商店界面（学生、教师通用）
 * @author Y, Huang Qiyue, Franklin Yang
 * @date 2021/7/21
 */

public class AppShop extends JFrame {
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JComboBox cmbGoodsCategory;
    private static JTable tblGoodsList;
    private static JTextField txtGoodsNum;
    private static JLabel lblBalanceVal;
    private static JLabel goodsPic;
    private static JLabel lblGoodsInfo;
    private static JLabel lblTotalCost;
    private static List<Goods> list;
    private static JTextArea goodsDetail;
    private static DefaultTableModel tableModel;
    private static DefaultTableModel cartTableModel;
    private static JTable tblCart;
    private static Vector cartData;
    private static BigDecimal totalCost= BigDecimal.valueOf(0);;

    private static final String EMPTY_GOODS_PIC = "/resources/assets/bg/bg3.jpg";
    private static final String EMPTY_GOODS_DESCRIPTION = "这里应该是商品详细信息";
    private static final String CATEGORY_UNFILTERED = "所有商品";
    private static final int PIC_WIDTH = 100,
                             PIC_HEIGHT = 100;
    public void handleCategorySelection(String category) {
        tableModel.setRowCount(0);   // remove all rows
        if(category.equals(CATEGORY_UNFILTERED)){
            list = ResponseUtils
                    .getResponseByHash(new Request(App.connectionToServer, null,
                            "com.vcampus.server.shop.ShopServer.listAllGoods", new Object[]{}).send())
                    .getListReturn(Goods.class);
        }
        else {
            list = ResponseUtils
                    .getResponseByHash(new Request(App.connectionToServer, null,
                            "com.vcampus.server.shop.ShopServer.listGoodsByType", new Object[]{category}).send())
                    .getListReturn(Goods.class);
        }
        if (list == null) {
            SwingUtils.showMessage(null, "抱歉，没有搜到符合条件的商品，管理员正在努力备货中...", "提示");
        } else {
            for (int i = 0; i < list.size(); i++) {
                tableModel.addRow(new Object[]{
                        list.get(i).getId(),
                        list.get(i).getName(),
                        list.get(i).getCategory(),
                        list.get(i).getRemaining(),
                        list.get(i).getStatus(),
                        list.get(i).getPrice()
                });

            }

        }
        // 滚动到顶端
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* TODO
                jsp_List.getVerticalScrollBar().setValue(0);
                lblDefaultHint.setVisible(false);
                jsp_List.setVisible(true);
                */
            }
        });
    }

    /**
     * 购买已选中的商品，并进行一系列初步检测。
     */
    private void purchase() {

        String cardNumber;
        switch (App.session.getUserType()) {
            case STUDENT:
                cardNumber = App.session.getStudent().getCardNumber();
                break;
            case TEACHER:
                cardNumber = App.session.getTeacher().getCardNumber();
                break;
            default:
                System.err.println("Neither student nor teacher...");
                return;
        }
        BigDecimal prevBalance=getBalance(cardNumber,App.session.getUserType());
        System.out.println(prevBalance);
        System.out.println(totalCost);
        if (prevBalance.compareTo(totalCost)==-1)
        {
            JOptionPane.showMessageDialog(null, "余额不足", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int checker=0;
        for (int i=0;i<tblCart.getRowCount();i++)
        {
            int result=submitPurchase(cardNumber, App.session.getUserType(),
                    tblCart.getValueAt(i, 0) + "@" + tblCart.getValueAt(i,2)+"@" + tblCart.getValueAt(i,3));
            if (result==0)
            {
                int num= (int) tblCart.getValueAt(i,2);BigDecimal per=(BigDecimal) tblCart.getValueAt(i,3);
                GoodsHistory thistime=new GoodsHistory(tblCart.getValueAt(i, 0).toString(),num,per.multiply(BigDecimal.valueOf(num)));
                insertPurchaseHistory(thistime);
            }
            checker+=result;
        }
        if (checker==0)
        {
            JOptionPane.showMessageDialog(null, "成功支付。", "成功", JOptionPane.INFORMATION_MESSAGE);
            // update balance label
            lblBalanceVal.setText(getBalance(cardNumber,App.session.getUserType()).toString());
            // update object of App.session
            switch (App.session.getUserType()) {
                case STUDENT:
                    App.session.getStudent().setBalance(getBalance(cardNumber,STUDENT));
                    break;
                case TEACHER:
                    App.session.getTeacher().setBalance(getBalance(cardNumber,TEACHER));
                    break;
                default:
                    System.err.println("Neither student nor teacher...");
                    return;
            }
            // update table
            handleCategorySelection(cmbGoodsCategory.getSelectedItem().toString());
            //clear cart
            while(tblCart.getRowCount()!=0)
            {cartTableModel.removeRow(0);}
            //clear cost
            totalCost= BigDecimal.valueOf(0);
            lblTotalCost.setText(totalCost.toString());
        }
        else{
            JOptionPane.showMessageDialog(null, "发生错误", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 向购物车加入商品
     */
    private void addToCart(int x)
    {
        int row = tblGoodsList.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "未选中商品", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String targetId= tblGoodsList.getValueAt(row,0).toString();
        String targetName=tblGoodsList.getValueAt(row,1).toString();
        int leftNum= (int) tblGoodsList.getValueAt(row,3);
        BigDecimal targetPrice= (BigDecimal) tblGoodsList.getValueAt(row,5);
        if (leftNum-x<0){
            JOptionPane.showMessageDialog(null, "剩余数量不足", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean flag=false;
        int index=0;
        for (int i=0;i<tblCart.getRowCount();i++)
        {
            if (targetId.equals(tblCart.getValueAt(i, 0))) {flag=true;index=i;}
        }
        if (flag)
        {
            int legacy= (int) tblCart.getValueAt(index,2);
            if (legacy+x>leftNum) {
                JOptionPane.showMessageDialog(null, "剩余数量不足", "错误", JOptionPane.ERROR_MESSAGE);
                return;}
            tblCart.setValueAt(legacy+x,index,2);
            BigDecimal total= targetPrice.multiply(BigDecimal.valueOf(legacy+x));
            tblCart.setValueAt(total,index,4);
            totalCost=totalCost.add(targetPrice.multiply(BigDecimal.valueOf(x)));
            lblTotalCost.setText(totalCost.toString());
        }
        else
        {
            Vector newEntry=new Vector();
            newEntry.add(targetId);newEntry.add(targetName);newEntry.add(x);newEntry.add(targetPrice);newEntry.add(targetPrice.multiply(BigDecimal.valueOf(x)));
            cartTableModel.addRow(newEntry);
            tblCart.setModel(cartTableModel);
            totalCost=totalCost.add(targetPrice.multiply(BigDecimal.valueOf(x)));
            System.out.println(totalCost);
            lblTotalCost.setText(totalCost.toString());
        }
    }

    /**
     * 从购物车移除商品
     */
    private void removeFromCart(int x)
    {
        int row = tblGoodsList.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "未选中商品", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String targetId= tblGoodsList.getValueAt(row,0).toString();
        String targetName=tblGoodsList.getValueAt(row,1).toString();
        int leftNum= (int) tblGoodsList.getValueAt(row,3);
        BigDecimal targetPrice= (BigDecimal) tblGoodsList.getValueAt(row,5);
        boolean flag=false;
        int index=0;
        for (int i=0;i<tblCart.getRowCount();i++)
        {
            if (targetId.equals(tblCart.getValueAt(i, 0))) {flag=true;index=i;}
        }
        if (flag)
        {
            int legacy= (int) tblCart.getValueAt(index,2);
            if (legacy-x<1){
                cartTableModel.removeRow(index);
                tblCart.setModel(cartTableModel);
                totalCost=totalCost.subtract(targetPrice.multiply(BigDecimal.valueOf(legacy)));
                lblTotalCost.setText(totalCost.toString());
            }
            else {
                tblCart.setValueAt(legacy - x, index, 2);
                BigDecimal total = targetPrice.multiply(BigDecimal.valueOf(legacy - x));
                tblCart.setValueAt(total, index, 4);
                totalCost=totalCost.subtract(targetPrice.multiply(BigDecimal.valueOf(x)));
                lblTotalCost.setText(totalCost.toString());
            }
        }
        else
        {
            return;
        }
    }

    public AppShop() {
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

        /* left category panel, deprecated
        JTree jt = new StuCategory().getJTree();
        jt.setBackground(new Color(240, 255, 240));
        jt.setBounds(0, 50, 200, 600);
        contentPane.add(jt);
        */
/*
        JLabel lblGoodsSearch = new JLabel("商品查询");
        lblGoodsSearch.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsSearch.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsSearch.setBounds(270, 60, 100, 40);
        contentPane.add(lblGoodsSearch);

        JTextField txtGoodsSearch = new JTextField();
        txtGoodsSearch.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtGoodsSearch.setBounds(390, 67, 160, 30);
        contentPane.add(txtGoodsSearch);
*/
        JLabel lblGoodsKind = new JLabel("商品种类");
        lblGoodsKind.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsKind.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsKind.setBounds(620, 60, 100, 40);
        contentPane.add(lblGoodsKind);

        cmbGoodsCategory = new JComboBox();
        cmbGoodsCategory.addItem(CATEGORY_UNFILTERED);
        cmbGoodsCategory.addItem("食品");
        cmbGoodsCategory.addItem("日用");
        cmbGoodsCategory.addItem("文具");
        cmbGoodsCategory.setBounds(770, 67, 100, 30);
        contentPane.add(cmbGoodsCategory);
        cmbGoodsCategory.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ItemEvent.SELECTED == e.getStateChange()){
                    String selectedItem = e.getItem().toString();
                    handleCategorySelection(selectedItem);
                    //System.out.printf("new selected item : %s%n",selectedItem);
                }
                if(ItemEvent.DESELECTED == e.getStateChange()){
                    //String selectedItem = e.getItem().toString();
                    //System.out.printf("deselected item : %s%n",selectedItem);
                }
            }

        });

        JLabel lblBalance = new JLabel("账户余额");
        lblBalance.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblBalance.setBounds(900, 60, 100, 40);
        contentPane.add(lblBalance);

        lblBalanceVal = new JLabel();
        switch(App.session.getUserType()){
            case STUDENT:
                lblBalanceVal.setText(getBalance(App.session.getStudent().getCardNumber(), STUDENT).toString());
                break;
            case TEACHER:
                lblBalanceVal.setText(getBalance(App.session.getTeacher().getCardNumber(), TEACHER).toString());
                break;
        }

        lblBalanceVal.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblBalanceVal.setBounds(1050, 67, 160, 30);
        contentPane.add(lblBalanceVal);

        /* BE CAREFUL CHANGING columnIndex! */
        // Check purchase()
        tableModel = new DefaultTableModel();
        String[] columnNames={
                "商品编号",
                "商品名称",
                "类别",
                "剩余数量",
                "状态",
                "价格"};
        String[][] tableValues = {};
        tableModel=new DefaultTableModel(tableValues, columnNames);
        tblGoodsList = new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        tblGoodsList.putClientProperty ( StyleId.STYLE_PROPERTY, "table" );
        tblGoodsList.setAutoResizeMode ( JTable.AUTO_RESIZE_ALL_COLUMNS );
        tblGoodsList.setRowSelectionAllowed(true);
        tblGoodsList.setCellSelectionEnabled(false);
        tblGoodsList.setRowHeight(40);
        tblGoodsList.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tblGoodsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblGoodsList.setPreferredScrollableViewportSize(new Dimension(200, 100));
        tblGoodsList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tblGoodsList.getSelectedRow();
                if(row != -1)
                {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(getClass().getResource("/resources/assets/goods/"
                                + list.get(row).getPic()));
                    } catch (IOException ee) {
                        ee.printStackTrace();
                    }
                    Image dimg = img.getScaledInstance(PIC_WIDTH, PIC_HEIGHT,
                            Image.SCALE_SMOOTH);
                    goodsPic.setIcon(new ImageIcon(dimg));

                    goodsDetail.setText(list.get(row).getDescription());
                }
                else{
                    goodsPic.setIcon(new ImageIcon(getClass().getResource(EMPTY_GOODS_PIC)));
                    goodsDetail.setText(EMPTY_GOODS_DESCRIPTION);
                }
            }
        });
        DefaultTableCellRenderer rGoodsList = new DefaultTableCellRenderer();
        rGoodsList.setHorizontalAlignment(JLabel.CENTER);
        tblGoodsList.setDefaultRenderer(Object.class, rGoodsList);
        JScrollPane scrollPane=new JScrollPane(tblGoodsList);
        scrollPane.setBounds(330, 150, 500, 300);
        contentPane.add(scrollPane);

        JLabel lblGoodsPic = new JLabel("商品图片");
        lblGoodsPic.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsPic.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsPic.setBounds(1050, 120, 100, 40);
        contentPane.add(lblGoodsPic);


        goodsPic = new JLabel();
        goodsPic.setBounds(1050, 130, 200, 200);
        contentPane.add(goodsPic);

        /* load initial goods img */
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource(EMPTY_GOODS_PIC));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(PIC_WIDTH, PIC_HEIGHT,
                Image.SCALE_SMOOTH);
        goodsPic.setIcon(new ImageIcon(dimg));

        lblGoodsInfo = new JLabel("商品信息");
        lblGoodsInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsInfo.setBounds(1050, 345, 100, 40);
        //contentPane.add(lblGoodsInfo);

        JLabel lblGoodsDescription = new JLabel("商品详细信息");
        lblGoodsDescription.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsDescription.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsDescription.setBounds(850, 300, 200, 40);
        contentPane.add(lblGoodsDescription);

        goodsDetail = new JTextArea(EMPTY_GOODS_DESCRIPTION, 8, 30);
        goodsDetail.setLineWrap(true);
        goodsDetail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        goodsDetail.setBounds(1050, 300, 300, 60);
        contentPane.add(goodsDetail);

        JLabel lblGoodsNum = new JLabel("购买数量");
        lblGoodsNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsNum.setBounds(900, 400, 100, 40);
        contentPane.add(lblGoodsNum);

        txtGoodsNum = new JTextField();
        txtGoodsNum.setText("1");
        txtGoodsNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        txtGoodsNum.setBounds(1100, 415, 160, 30);
        contentPane.add(txtGoodsNum);

        JButton btnAddToCart = new JButton("确认购买");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                purchase();
            }
        });
        btnAddToCart.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnAddToCart);
        btnAddToCart.setBounds(1050, 580, 110, 35);

        /* show all goods upon show-up */
        handleCategorySelection(CATEGORY_UNFILTERED);

        /* 购物车 */
        String[] cartColumnNames={
                "商品编号",
                "商品名称",
                "购买数量",
                "单价",
                "总价"
        };
        //Vector cartData=new Vector();
        cartTableModel =new DefaultTableModel(null,cartColumnNames);
        tblCart=new JTable(cartTableModel){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        tblCart.setRowSelectionAllowed(true);
        tblCart.setCellSelectionEnabled(false);
        tblCart.setRowHeight(40);
        tblCart.setFont(new Font("微软雅黑",Font.PLAIN,16));
        tblCart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //tblCart.setBounds(300, 800, 500, 80);
        JScrollPane cartScrollPane=new JScrollPane(tblCart);
        cartScrollPane.setBounds(330, 500, 500, 160);
        //contentPane.add(tblCart);
        contentPane.add(cartScrollPane);

        JButton btnAddOne = new JButton("添加一件");
        btnAddOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart(1);
            }
        });
        btnAddOne.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnAddOne);
        btnAddOne.setBounds(1050, 500, 110, 35);

        JButton btnAddSome = new JButton("添加上记数量");
        btnAddSome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart(Integer.parseInt(txtGoodsNum.getText()));
            }
        });
        btnAddSome.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnAddSome);
        btnAddSome.setBounds(1200, 500, 160, 35);

        JButton btnRemoveOne = new JButton("删除一件");
        btnRemoveOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFromCart(1);
            }
        });
        btnRemoveOne.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnRemoveOne);
        btnRemoveOne.setBounds(1050, 540, 110, 35);

        JButton btnRemoveSome = new JButton("删除上记数量");
        btnRemoveSome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFromCart(Integer.parseInt(txtGoodsNum.getText()));
            }
        });
        btnRemoveSome.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        contentPane.add(btnRemoveSome);
        btnRemoveSome.setBounds(1200, 540, 160, 35);

        /* 购物车内总价 */
        lblTotalCost=new JLabel("共需付款");
        lblTotalCost.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblTotalCost.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalCost.setBounds(1200, 580, 100, 40);
        contentPane.add(lblTotalCost);

        lblTotalCost.setText(totalCost.toString());
    }
}
