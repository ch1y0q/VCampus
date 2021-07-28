package com.vcampus.client.main.shop;

import com.vcampus.client.main.App;
import com.vcampus.entity.Book;
import com.vcampus.entity.Goods;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLIntegrityConstraintViolationException;

public class AdminAddItemDiag extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNumber;
    private JTextField txtName;
    private JTextField txtPrice;
    private JTextField txtCategory;
    private JTextField txtQuantity;
    private JTextField txtStatus;
    private JLabel lblNumber;
    private JLabel lblName;
    private JLabel lblPrice;
    private JLabel lblQuantity;
    private JLabel lblCategory;
    private JLabel lblStatus;
    private JLabel lblPic;
    private JTextField txtPic;
    private JTextArea txtAreaDescription;
    private JLabel lblDescription;

    public AdminAddItemDiag() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("添加商品");
        setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 100,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 100,
                100, 200);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * 按下确认按钮，读取文本框内容，尝试添加记录。
     */
    private void onOK() {
        int id;
        Goods goods;
        Boolean result;
        try{
            id = Integer.parseInt(txtNumber.getText());
            goods = new Goods(id, txtName.getText(), Integer.parseInt(txtQuantity.getText()),
                    txtCategory.getText(), new BigDecimal(txtPrice.getText()),
                    txtAreaDescription.getText(), txtPic.getText(), txtStatus.getText());
            result = ResponseUtils.getResponseByHash(
                    new Request(App.connectionToServer, null, "com.vcampus.server.shop.ShopAdminServer.insertNewGoods",
                            new Object[]{goods}).send())
                    .getReturn(Boolean.class);
        }catch(NumberFormatException e){
            goods = new Goods(txtName.getText(), Integer.parseInt(txtQuantity.getText()),
                    txtCategory.getText(), new BigDecimal(txtPrice.getText()),
                    txtAreaDescription.getText(), txtPic.getText(), txtStatus.getText());
            result = ResponseUtils.getResponseByHash(
                    new Request(App.connectionToServer, null, "com.vcampus.server.shop.ShopAdminServer.insertNewGoodsWithoutId",
                            new Object[]{goods}).send())
                    .getReturn(Boolean.class);
        }
        catch(Exception e){
            e.printStackTrace();
	        result = false;
        }
        if (result == null) result = false; // 服务端出错（指定的商品id重复）会传递null

        if (result) {
            JOptionPane.showMessageDialog(null, "添加商品成功。", "成功", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "添加商品失败，请检查编号是否重复。", "失败", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        AdminAddItemDiag dialog = new AdminAddItemDiag();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
