package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StuLibrary extends JFrame {
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1,jp2,jp3;
    public StuLibrary() {
        setResizable(true);
        setTitle("东南大学图书馆");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1151, 850);
        contentPane = new JPanel();
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        contentPane.setBackground(new Color(240, 255, 240));
        contentPane.setLocation(-871, -176);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jp1.setLayout(null);
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

        // 创建选项卡面板
        tabbedPane = new JTabbedPane();
        tabbedPane.add("已借图书",jp1);
        tabbedPane.add("图书查询借阅",jp2);
        tabbedPane.add("已还图书",jp3);
        tabbedPane.setBounds(0,20,1000,700);
        this.add(tabbedPane);

        String[] header = {"ISBN", "书名","作者","借阅时间","应当归还时间","备注","续借"};
        String[][] data = {{"", "","","","",""}};
        DefaultTableModel model = new DefaultTableModel(data,header);
        JTable table = new JTable(model);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        table.setGridColor(Color.BLACK);
        table.setEnabled(false);
        jScrollPane.setBounds(0, 0, 980, 800);
        jp1.add(jScrollPane);

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

        JButton addbook = new JButton("增加");
        addbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        addbook.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        addbook.setBounds(600, 750, 60, 18);
        contentPane.add(addbook);

        JButton changebook = new JButton("修改");
        changebook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        changebook.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        changebook.setBounds(700, 750, 60, 18);
        contentPane.add(changebook);

        JButton deletebook = new JButton("删除");
        deletebook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        deletebook.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        deletebook.setBounds(800, 750, 60, 18);
        contentPane.add(deletebook);
    }
}