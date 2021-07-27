package com.vcampus.client.main.library;

import com.vcampus.client.LoginUI;
import com.vcampus.client.main.App;
import com.vcampus.client.main.student.AppStudent;
import com.vcampus.client.main.student.StuCategory;
import com.vcampus.entity.Book;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * @author Xiao Kaijie
 * @date 2021-07-14
 */

public class StuLibrary extends JFrame {
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1,jp2;
    private List<Book> list = null;
    private DefaultTableModel model;
    public StuLibrary() {
        setResizable(true);
        setTitle("东南大学图书馆");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕大小
        setSize(d.width, d.height);
        this.setLayout(null);
        contentPane = new JPanel();
        jp1=new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jp1.setLayout(null);
        jp1.setBackground(new Color(255, 255, 255));

        JTree jt= new StuCategory().init();
        jt.setBounds(0,60,200,600);
        contentPane.add(jt);

        JButton btnBack = new JButton("返回");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnBack)
                {
                    AppStudent app=new AppStudent();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnBack.setBounds(0, 25, 60, 30);
        contentPane.add(btnBack);

        JButton btnSerchborrowed = new JButton("查询");

        btnSerchborrowed.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnSerchborrowed.setBounds(500, 0, 60, 30);
        jp1.add(btnSerchborrowed);

        String[] header = {"ISBN", "书名","作者","借阅时间","应当归还时间","备注","续借"};
        model = new DefaultTableModel(null,header);
        JTable table = new JTable(model)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };

        btnSerchborrowed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnSerchborrowed)
                {
                    list = ResponseUtils.getResponseByHash(
                            new Request(App.connectionToServer, null, "com.vcampus.server.library.AddoneBook.getBorrowedBookList",
                                    new Object[] { App.session.getStudent().getCardNumber() }).send())
                            .getListReturn(Book.class);
                    String[][] listData = new String[list.size()][7];
                    if (list == null || list.size() == 0) {
                        System.out.println("error");
                    } else {
                        model.setRowCount(0);
                        int len = list.size();
                        for (int i = 0; i < len; i++) {
                            listData[i][0]=list.get(i).getISBN();
                            listData[i][1]=list.get(i).getName();
                            listData[i][2]=list.get(i).getAuthor();
                            listData[i][3]=list.get(i).getBorrowtime();
                            listData[i][4]=list.get(i).getSrTime();
                            listData[i][5]="无";
                            listData[i][6]="<html><font color='rgb(110,110,110)'>续借</font></html>";
                        }
                        model = new DefaultTableModel(listData, header){
                            public boolean isCellEditable(int a, int b) {
                                return false;
                            }
                        };
                        table.setModel(model);
                    }
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.getSelectedColumn();
                int row = table.getSelectedRow();
                if (column == 6) {
                    int result = ResponseUtils
                            .getResponseByHash(new Request(App.connectionToServer, null,
                                    "com.vcampus.server.library.BookServer.renewBook", new Object[] { table.getValueAt(row,0) }).send())
                            .getReturn(Integer.class);
                    if (result == 0)
                    {   System.out.println("error");
                        JOptionPane.showMessageDialog(null,"超时还书 无法续借 请至图书馆及时还书");
                    }
                    else
                    {
                        System.out.println("noerror");
                        table.setValueAt("<html><font color='rgb(110,110,110)'>成功续借</font></html>", row, column);
                    }
                }
            }
        });
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        table.setGridColor(Color.BLACK);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setBounds(0, 30, 980, 700);
        jp1.add(jScrollPane);

        jp2=new AppStuLibborrow();

        JButton btnLogout = new JButton("登出");
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnLogout)
                {
                    LoginUI app=new LoginUI();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        btnLogout.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnLogout.setBounds(1200, 25, 60, 30);
        contentPane.add(btnLogout);

        // 创建选项卡面板
        tabbedPane = new JTabbedPane();
        tabbedPane.add("已借图书",jp1);
        tabbedPane.add("图书查询借阅",jp2);
        tabbedPane.setBounds(200,50,1000,700);
        contentPane.add(tabbedPane);
    }
}