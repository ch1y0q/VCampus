package com.vcampus.client.main;

import com.vcampus.client.LoginUI;
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
    private static JPanel jp1,jp2,jp3;
    private List<Book> list = null;
    public StuLibrary() {
        setResizable(true);
        setTitle("东南大学图书馆");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕大小
        setSize(d.width, d.height);
        this.setLayout(null);
        contentPane = new JPanel();
        jp1=new JPanel();
        jp3=new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jp1.setLayout(null);
        jp1.setBackground(new Color(255, 255, 255));
        jp3.setLayout(null);
        jp3.setBackground(new Color(255, 255, 255));

        JTree jt= new StuCategory().init();
        jt.setBounds(0,50,200,600);
        contentPane.add(jt);

        JButton btnBack = new JButton("返回");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnBack)
                {
                    AppStudent app=new AppStudent();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnBack.setBounds(0, 25, 60, 30);
        contentPane.add(btnBack);

        String[] header = {"ISBN", "书名","作者","借阅时间","应当归还时间","备注","续借"};
        String[][] data = {{"", "","","","","",""},{"", "","","","","",""}};
        DefaultTableModel model = new DefaultTableModel(data,header);
        JTable table = new JTable(model)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.getSelectedColumn();
                int row = table.getSelectedRow();
                if (column == 6) {
                    table.setValueAt("<html><font color='rgb(110,110,110)'>成功续借</font></html>", row, column);
                }
            }
        });
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        table.setGridColor(Color.BLACK);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setBounds(0, 0, 980, 700);
        jp1.add(jScrollPane);

        jp2=new AppStuLibborrow();

        String[] header3 = {"ISBN", "书名","作者","借阅时间","归还时间"};
        String[][] data3 = {{"","","","",""}};
        DefaultTableModel model3 = new DefaultTableModel(data3,header3);
        JTable table3 = new JTable(model3);
        JScrollPane jScrollPane3 = new JScrollPane();
        jScrollPane3.setViewportView(table3);
        table3.setGridColor(Color.BLACK);
        table3.setEnabled(false);
        jScrollPane3.setBounds(0, 0, 980, 700);
        jp3.add(jScrollPane3);

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
        tabbedPane.add("已还图书",jp3);
        tabbedPane.setBounds(200,50,1000,700);
        contentPane.add(tabbedPane);

        list = ResponseUtils.getResponseByHash(
                new Request(App.connectionToServer, null, "com.vcampus.server.library.AddoneBook.getBorrowedBookList",
                        new Object[] { App.session.getStudent().getCardNumber() }).send())
                .getListReturn(Book.class);

        if (list == null || list.size() == 0) {
            System.out.println("error");
        } else {
            model.setRowCount(0);
            int len = list.size();
            for (int i = 0; i < len; i++) {
                Object[] toAdd = { list.get(i).getSerialVersionUID(), list.get(i).getName(), list.get(i).getAuthor(),
                        list.get(i).get_borrowTime(),"2020-01-01","000" };
                model.addRow(toAdd);
            }
        }

    }
}