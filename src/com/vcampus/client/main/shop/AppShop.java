package com.vcampus.client.main.shop;

import com.vcampus.client.main.App;
import com.vcampus.client.main.Student.StuCategory;

import static com.vcampus.client.main.shop.AppShopHelper.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 * @author Y
 * @date 2021/7/21
 */

public class AppShop extends JFrame {
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1, jp2;
    private static JComboBox cmbGoodsKind;
    private static JTable tblGoodsList;
    private static JTextField txtGoodsNum;
    private static JLabel lblBalanceVal;

    private void loadGoods(){
        //TODO
    }

    /**
     * 购买已选中的商品，并进行一系列初步检测。
     */
    private void purchase() {
        int row = tblGoodsList.getSelectedRow();
        int amount = Integer.parseInt(txtGoodsNum.getText());
        // has selection
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "未选中商品", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int remaining = (int) tblGoodsList.getValueAt(row, 2);
        // has remaining
        if (amount > remaining) {
            JOptionPane.showMessageDialog(null, "商品剩余数量不足", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // has money
        BigDecimal totalPrice = new BigDecimal(0);
        totalPrice = (BigDecimal) tblGoodsList.getValueAt(row, 4);
        totalPrice = totalPrice.multiply(new BigDecimal(amount));
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
        BigDecimal balance = getBalance(cardNumber, App.session.getUserType());
        if (balance.compareTo(totalPrice) == -1) { // < , no enough money
            JOptionPane.showMessageDialog(null, "余额不足", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // TODO check parameter
        submitPurchase(cardNumber, App.session.getUserType(),
                tblGoodsList.getValueAt(row, 4) + "@" + amount);
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
        JTree jt = new StuCategory().init();
        jt.setBackground(new Color(240, 255, 240));
        jt.setBounds(0, 50, 200, 600);
        contentPane.add(jt);

        JLabel lblGoodsSearch = new JLabel("商品查询");
        lblGoodsSearch.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsSearch.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsSearch.setBounds(270, 60, 100, 40);
        contentPane.add(lblGoodsSearch);

        JTextField txtGoodsSearch = new JTextField();
        txtGoodsSearch.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtGoodsSearch.setBounds(390, 67, 160, 30);
        contentPane.add(txtGoodsSearch);

        JLabel lblGoodsKind = new JLabel("商品种类");
        lblGoodsKind.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsKind.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsKind.setBounds(620, 60, 100, 40);
        contentPane.add(lblGoodsKind);

        cmbGoodsKind = new JComboBox();
        cmbGoodsKind.addItem("所有商品");
        //cmbGoodsKind.addItem("食品");
        //cmbGoodsKind.addItem("日用");
        //cmbGoodsKind.addItem("文具");
        cmbGoodsKind.setBounds(770, 67, 100, 30);
        contentPane.add(cmbGoodsKind);

        JLabel lblBalance = new JLabel("账户余额");
        lblBalance.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblBalance.setBounds(900, 60, 100, 40);
        contentPane.add(lblBalance);

        lblBalanceVal = new JLabel();
        lblBalanceVal.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblBalanceVal.setBounds(1050, 67, 160, 30);
        contentPane.add(lblBalanceVal);

        tblGoodsList = new JTable(12, 5);
        tblGoodsList.setBounds(330, 150, 500, 600);
        tblGoodsList.setRowHeight(50);
        tblGoodsList.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        /* BE CAREFUL CHANGING columnIndex! */
        tblGoodsList.getModel().setValueAt("商品名称", 0, 0);
        tblGoodsList.getModel().setValueAt("类别", 0, 1);
        tblGoodsList.getModel().setValueAt("剩余数量", 0, 2);
        tblGoodsList.getModel().setValueAt("状态", 0, 3);
        tblGoodsList.getModel().setValueAt("价格", 0, 4);
        tblGoodsList.setPreferredScrollableViewportSize(new Dimension(200, 100));
        DefaultTableCellRenderer rGoodsList = new DefaultTableCellRenderer();
        rGoodsList.setHorizontalAlignment(JLabel.CENTER);
        tblGoodsList.setDefaultRenderer(Object.class, rGoodsList);
        //JScrollPane scrollPane=new JScrollPane(tblGoodsList);
        contentPane.add(tblGoodsList);

        JLabel lblGoodsPic = new JLabel("商品图片");
        lblGoodsPic.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsPic.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsPic.setBounds(1050, 150, 100, 40);
        contentPane.add(lblGoodsPic);

        JLabel goodsPic = new JLabel(new ImageIcon(getClass().getResource("/resources/assets/bg/bg3.jpg")));
        contentPane.add(goodsPic);
        goodsPic.setBounds(1000, 200, 100, 100);

        JLabel lblGoodsInfo = new JLabel("商品信息");
        lblGoodsInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsInfo.setBounds(1050, 345, 100, 40);
        contentPane.add(lblGoodsInfo);

        JLabel lblGoodsSpInfo = new JLabel("商品详细信息");
        lblGoodsSpInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsSpInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsSpInfo.setBounds(850, 410, 200, 40);
        contentPane.add(lblGoodsSpInfo);

        JTextArea goodsDetail = new JTextArea("这里应该是商品详细信息", 8, 30);
        goodsDetail.setLineWrap(true);
        goodsDetail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        goodsDetail.setBounds(1050, 420, 300, 150);
        contentPane.add(goodsDetail);

        JLabel lblGoodsNum = new JLabel("购买数量");
        lblGoodsNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblGoodsNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblGoodsNum.setBounds(900, 610, 100, 40);
        contentPane.add(lblGoodsNum);

        txtGoodsNum = new JTextField();
        txtGoodsNum.setText("1");
        txtGoodsNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        txtGoodsNum.setBounds(1100, 615, 160, 30);
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
        btnAddToCart.setBounds(1050, 700, 110, 35);
    }
}
