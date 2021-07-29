package com.vcampus.client.main.library.ManagerLibrary;

import com.vcampus.client.LoginUI;
import com.vcampus.client.administrator.main.AppAdmin;
import com.vcampus.client.main.App;
import com.vcampus.client.main.manager.ManCategory;
import com.vcampus.entity.Book;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Xiao Kaijie
 * @date 2021-07-19
 */

public class ManLibrary extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private List<Book> list = null;
    private List<Book> list1 = null;
    public ManLibrary() {
        setResizable(true);
        setTitle("图书馆管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTree jt=new ManCategory().getJTree();
        jt.setBounds(0,60,100,400);
        contentPane.add(jt);

        JButton back = new JButton("返回");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==back)
                {
                    AppAdmin app=new AppAdmin();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        back.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        back.setBounds(0, 20, 100, 30);
        contentPane.add(back);

        JLabel tf = new JLabel();
        tf.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf.setText("欢迎你:" + "234");
        tf.setBounds(1000, 20, 180, 30);
        tf.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(tf);

        JButton logout = new JButton(res.getString("logout"));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==logout)
                {
                    LoginUI app=new LoginUI();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        logout.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        logout.setBounds(1200, 20, 100, 30);
        contentPane.add(logout);

        JLabel bookmanage=new JLabel("书籍信息管理");
        bookmanage.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        bookmanage.setBounds(260, 55, 200, 30);
        bookmanage.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(bookmanage);

        JTextField txtfield = new JTextField();    //创建文本框
        txtfield.setText("输入书名");
        txtfield.setBounds(470, 50, 300, 30);
        JButton search = new JButton("查询");
        search.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        search.setBounds(770, 50, 60, 30);
        contentPane.add(txtfield);
        contentPane.add(search);

        JLabel recall=new JLabel("按分类检索");
        recall.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        recall.setBounds(850, 50, 200, 30);
        recall.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(recall);
        String[] recalltxt={"","计算机用书","数学用书","文学艺术"};
        JComboBox jc=new JComboBox(recalltxt);
        jc.setBounds(1000,50,150,30);
        contentPane.add(jc);

        ManLibrarydetailPanel Bookdetail=new ManLibrarydetailPanel();
        Bookdetail.setBackground(new Color(255, 255, 255));
        Bookdetail.setBounds(800,120,600,350);
        Bookdetail.setVisible(false);
        contentPane.add(Bookdetail);

        String[] header = {"序号","ISBN号", "书籍名称", "剩余数量", "作者","详细信息"};
        model = new DefaultTableModel(null, header);
        JTable table = new JTable(model)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        JTable table2 = new JTable(model2);
        JLabel Borrow=new JLabel("借书记录");
        Borrow.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Borrow.setBounds(800, 500, 150, 30);
        Borrow.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(Borrow);
        String[] header2 = {"一卡通号","书名","借书时间", "应还时间"};
        model2 = new DefaultTableModel(null, header2);
        table2.setModel(model2);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==search)
                {
                    String str=jc.getSelectedItem().toString();
                    list = ResponseUtils
                            .getResponseByHash(new Request(App.connectionToServer, null,
                                    "com.vcampus.server.library.BookServer.fuzzySearchByTitleAndTabs",
                                    new Object[] { txtfield.getText(),str}).send())
                            .getListReturn(Book.class);
                    model.setRowCount(0);
                    String[][] listData = new String[list.size()][6];
                    if (list == null || list.size() == 0) {
                        System.out.println("error");
                    } else {
                        model.setRowCount(0);
                        int len = list.size();
                        for (int i = 0; i < len; i++) {
                            listData[i][0]=String.valueOf(i);
                            listData[i][1]=list.get(i).getISBN();
                            listData[i][2]=list.get(i).getName();
                            listData[i][3]=String.valueOf(list.get(i).getNumber());
                            listData[i][4]=list.get(i).getAuthor();
                            listData[i][5]="<html><font color='rgb(110,110,110)'>查看</font></html>";
                        }
                        model = new DefaultTableModel(listData, header){
                            public boolean isCellEditable(int a, int b) {
                                return false;
                            }
                        };
                        table.setModel(model);
                    }
                    model2 = new DefaultTableModel(null, header2);
                    table2.setModel(model2);
                    list1 = ResponseUtils.getResponseByHash(
                            new Request(App.connectionToServer, null, "com.vcampus.server.library.AddoneBook.getBorrowedBookFromtitle",
                                    new Object[] { txtfield.getText() }).send())
                            .getListReturn(Book.class);
                    String[][] listData1 = new String[list1.size()][4];
                    if (list1 == null || list1.size() == 0) {
                        System.out.println("error");
                    } else {
                        model2.setRowCount(0);
                        int len = list1.size();
                        for (int i = 0; i < len; i++) {
                            listData1[i][0]=list1.get(i).getborrower();
                            listData1[i][1]=list1.get(i).getName();
                            listData1[i][2]=list1.get(i).getBorrowtime();
                            listData1[i][3]=list1.get(i).getSrTime();
                        }
                        model2 = new DefaultTableModel(listData1, header2){
                            public boolean isCellEditable(int a, int b) {
                                return false;
                            }
                        };
                        table2.setModel(model2);
                    }
                }
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.getSelectedColumn();
                int row = table.getSelectedRow();
                if (column == 5) {
                    Bookdetail.initnow();
                    Bookdetail.init(table.getValueAt(row,1).toString());
                    Bookdetail.setVisible(true);
                }
            }
        });
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        table.setGridColor(Color.BLACK);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setBounds(260, 120, 500, 630);
        contentPane.add(jScrollPane);

        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(table2);
        table2.setGridColor(Color.BLACK);
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setBounds(800, 530, 500, 220);
        contentPane.add(jScrollPane2);

    }
}