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
    private DefaultTableModel model2;
    public AppStuLibborrow()
    {
        setLayout(null);
        setBackground(new Color(255, 255, 255));
        JTextField txtBookOrIsbn=new JTextField();    //创建文本框
        txtBookOrIsbn.setText("输入书名");
        txtBookOrIsbn.setBounds(0,10,400,30);
        JButton btnQuery=new JButton("查询");
        btnQuery.setBounds(420,10,60,30);

        String[] header2 = {"ISBN", "书名","作者","作者国籍","剩余数量","出版社","介绍","分类","借阅"};
        model2 = new DefaultTableModel(null,header2);
        JTable table2 = new JTable(model2)
        {
            public boolean isCellEditable(int a, int b) {
            this.setRowSelectionAllowed(false);
            this.setColumnSelectionAllowed(false);
            return false;
            }
        };
        btnQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str="";
                list = ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null,
                                "com.vcampus.server.library.BookServer.fuzzySearchByTitleAndAuthor",
                                new Object[] { txtBookOrIsbn.getText(),str}).send())
                        .getListReturn(Book.class);
                String[][] listData = new String[list.size()][9];
                model2.setRowCount(0);
                if (list == null) {
                    System.out.println("error");
                } else {
                    for (int i = 0; i < list.size(); i++)
                    {
                        listData[i][0]=list.get(i).getSerialVersionUID();
                        listData[i][1]=list.get(i).getName();
                        listData[i][2]=list.get(i).getAuthor();
                        listData[i][3]=list.get(i).getAuthorCountry();
                        listData[i][4]=String.valueOf(list.get(i).getNumber());
                        listData[i][5]=list.get(i).getPublishingHouse();
                        listData[i][6]= list.get(i).getIntroduction();
                        listData[i][7]=list.get(i).getTabs();
                        listData[i][8]="<html><font color='rgb(110,110,110)'>借阅</font></html>";
                    }
                    model2 = new DefaultTableModel(listData, header2){
                        public boolean isCellEditable(int a, int b) {
                            return false;
                        }
                    };
                    table2.setModel(model2);
                }
            }
        });
        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table2.getSelectedColumn();
                int row = table2.getSelectedRow();
                if (column == 8) {
                    table2.setValueAt("<html><font color='rgb(110,110,110)'>已借</font></html>", row, column);
                    int result = ResponseUtils
                            .getResponseByHash(
                                    new Request(App.connectionToServer, null, "com.vcampus.server.library.BookServer.borrowBook",
                                            new Object[] { App.session.getStudent().getCardNumber(), "12345"}).send())
                            .getReturn(Integer.class);
                    if (result >0 ) {
                        System.out.println("success");
                    }
                    if (result == 0) {
                        System.out.println("error");
                    }
                }
            }
        });
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
