package com.vcampus.client.main;

import com.vcampus.entity.Book;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class AppStuLibborrow extends JPanel {
    private List<Book> list = null;
    public AppStuLibborrow()
    {
        setLayout(null);
        setBackground(new Color(255, 255, 255));
        JTextField txtBookOrIsbn=new JTextField();    //创建文本框
        txtBookOrIsbn.setText("输入书名或者ISBN号");
        txtBookOrIsbn.setBounds(0,10,400,30);
        JButton btnQuery=new JButton("查询");
        btnQuery.setBounds(420,10,60,30);
        btnQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        String[] header2 = {"ISBN", "书名","作者","作者国籍","剩余数量","出版社","介绍","分类","借阅"};
        String[][] data2 = {{"", "","","","","", "","","","",""}};
        DefaultTableModel model2 = new DefaultTableModel(data2,header2);
        JTable table2 = new JTable(model2)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table2.getSelectedColumn();
                int row = table2.getSelectedRow();
                if (column == 6) {
                    table2.setValueAt("<html><font color='rgb(110,110,110)'>已借</font></html>", row, column);
                }
            }
        });
        String str="xkk";
        list = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null,
                        "com.vcampus.server.library.BookServer.searchAuthorByTitle",
                        new Object[] { txtBookOrIsbn.getText().trim()}).send())
                .getListReturn(Book.class);
        model2.setRowCount(0);
        if (list == null) {
            System.out.println("error");
        } else {
            for (int i = 0; i < list.size(); i++)
            {
                Object[] toAdd = { list.get(i).getSerialVersionUID(), list.get(i).getName(), list.get(i).getAuthor(),
                        list.get(i).getAuthorCountry(),list.get(i).getNumber(),list.get(i).getPublishingHouse(),
                        list.get(i).getIntroduction(),list.get(i).getTabs()};
                model2.addRow(toAdd);
                System.out.println("666");
            }
            table2.setModel(model2);
            System.out.println("123");
        }
        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(table2);
        table2.setGridColor(Color.BLACK);
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setBounds(0, 50, 980, 700);
        add(btnQuery);
        add(txtBookOrIsbn);
        add(jScrollPane2);
    }
}
