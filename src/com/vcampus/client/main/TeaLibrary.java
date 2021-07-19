package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Xiao Kaijie
 * @date 2021-07-16
 */

public class TeaLibrary extends JFrame {
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1, jp2, jp3;

    public TeaLibrary() {
        setResizable(true);
        setTitle("东南大学图书馆");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1151, 1000);
        this.setLayout(null);
        contentPane = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setBounds(0, 0, 1151, 1000);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jp1.setLayout(null);
        jp1.setBounds(0, 40, 1151, 900);
        contentPane.add(jp1);
        jp2.setLayout(null);
        jp3.setLayout(null);
        JButton back = new JButton("返回");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        back.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        back.setBounds(0, 25, 60, 18);
        contentPane.add(back);

        String[] header = {"ISBN", "书名", "作者", "借阅时间", "应当归还时间", "备注", "续借"};
        String[][] data = {{"", "", "", "", "", ""}};
        DefaultTableModel model = new DefaultTableModel(data, header);
        JTable table = new JTable(model);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        table.setGridColor(Color.BLACK);
        table.setEnabled(false);
        jScrollPane.setBounds(0, 0, 980, 600);
        jp1.add(jScrollPane);

        JTextField txtfield1 = new JTextField();    //创建文本框
        txtfield1.setText("输入书名或者ISBN号");
        txtfield1.setBounds(0, 20, 400, 30);
        JButton search = new JButton("查询");
        search.setBounds(420, 30, 60, 18);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        String[] header2 = {"ISBN", "书名", "作者", "作者国籍", "剩余数量", "出版社", "介绍", "分类", "借阅"};
        String[][] data2 = {{"", "", "", "", "", "", "", "", "", "", ""}};
        DefaultTableModel model2 = new DefaultTableModel(data2, header2);
        JTable table2 = new JTable(model2);
        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(table2);
        table2.setGridColor(Color.BLACK);
        table2.setEnabled(false);
        jScrollPane2.setBounds(0, 50, 980, 500);
        jp2.add(search);
        jp2.add(txtfield1);
        jp2.add(jScrollPane2);

        String[] header3 = {"ISBN", "书名", "作者", "借阅时间", "归还时间"};
        String[][] data3 = {{"", "", "", "", ""}};
        DefaultTableModel model3 = new DefaultTableModel(data3, header3);
        JTable table3 = new JTable(model3);
        JScrollPane jScrollPane3 = new JScrollPane();
        jScrollPane3.setViewportView(table3);
        table3.setGridColor(Color.BLACK);
        table3.setEnabled(false);
        jScrollPane3.setBounds(0, 0, 980, 600);
        jp3.add(jScrollPane3);

        JButton logout = new JButton("登出");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        logout.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        logout.setBounds(1000, 25, 60, 18);
        contentPane.add(logout);

        // 创建选项卡面板
        tabbedPane = new JTabbedPane();
        tabbedPane.add("已借图书", jp1);
        tabbedPane.add("图书查询借阅", jp2);
        tabbedPane.add("已还图书", jp3);
        tabbedPane.setBounds(0, 50, 1000, 700);
        this.add(tabbedPane);

    }
}
