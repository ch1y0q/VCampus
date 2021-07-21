package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Xiao Kaijie
 * @date 2021-07-14
 */

public class StuLibrary extends JFrame {
    private static JPanel contentPane;
    private static JTabbedPane tabbedPane;
    private static JPanel jp1,jp2,jp3;
    public StuLibrary() {
        setResizable(true);
        setTitle("东南大学图书馆");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        this.setLayout(null);
        contentPane = new JPanel();
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jp1.setLayout(null);
        jp1.setBackground(new Color(255, 255, 255));
        contentPane.add(jp1);
        jp2.setLayout(null);
        jp2.setBackground(new Color(255, 255, 255));
        jp3.setLayout(null);
        jp3.setBackground(new Color(255, 255, 255));

        DefaultMutableTreeNode login= new DefaultMutableTreeNode("学生登陆");
        DefaultMutableTreeNode information = new DefaultMutableTreeNode("个人信息");
        DefaultMutableTreeNode library = new DefaultMutableTreeNode("图书馆");
        DefaultMutableTreeNode Class = new DefaultMutableTreeNode("课程管理");
        DefaultMutableTreeNode life = new DefaultMutableTreeNode(   "生活服务");
        DefaultMutableTreeNode shop = new DefaultMutableTreeNode(   "网上商店");
        login.add(information);
        login.add(Class);
        login.add(library);
        login.add(life);
        login.add(shop);

        DefaultMutableTreeNode inforLook = new DefaultMutableTreeNode("个人信息查询");
        DefaultMutableTreeNode informanage = new DefaultMutableTreeNode("个人信息维护");
        information.add(inforLook);
        information.add(informanage);
        DefaultMutableTreeNode BorrowLook = new DefaultMutableTreeNode("借阅查询");
        DefaultMutableTreeNode BookLook = new DefaultMutableTreeNode("书籍查询");
        DefaultMutableTreeNode BorrowHistory = new DefaultMutableTreeNode("借阅历史");
        library.add(BorrowLook);
        library.add(BookLook);
        library.add(BorrowHistory);
        DefaultMutableTreeNode timetable = new DefaultMutableTreeNode("课表");
        DefaultMutableTreeNode Grades = new DefaultMutableTreeNode("成绩查询");
        DefaultMutableTreeNode Classchoose = new DefaultMutableTreeNode("选课");
        Class.add(timetable);
        Class.add(Grades);
        Class.add(Classchoose);
        DefaultMutableTreeNode card = new DefaultMutableTreeNode("一卡通");
        DefaultMutableTreeNode living = new DefaultMutableTreeNode("宿舍管理");
        life.add(card);
        life.add(living);
        DefaultMutableTreeNode goods = new DefaultMutableTreeNode("商品列表");
        DefaultMutableTreeNode shopcar = new DefaultMutableTreeNode("购物车");
        DefaultMutableTreeNode histoty = new DefaultMutableTreeNode("购买历史");
        shop.add(goods);
        shop.add(shopcar);
        shop.add(histoty);

        JTree jt = new JTree(login);
        jt.setBounds(0,50,200,600);
        contentPane.add(jt);

        TreeSelectionModel treeSelectionModel;
        treeSelectionModel=jt.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if (!jt.isSelectionEmpty()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                    String name = node.toString();
                    System.out.println(name);
                }
            }
        });


        JButton back = new JButton("返回");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back)
                {
                    AppStudent app=new AppStudent();
                    setVisible(false);
                    app.setVisible(true);
                }
            }
        });
        back.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        back.setBounds(0, 25, 60, 30);
        contentPane.add(back);

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
                /**需增加
                 * 判断逻辑
                 */
                if (column == 6) {
                    table.setValueAt("<html><font color='rgb(110,110,110)'>无法续借</font></html>", row, column);
                }
            }
        });
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        table.setGridColor(Color.BLACK);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setBounds(0, 0, 980, 700);
        jp1.add(jScrollPane);

        JTextField txtfield1=new JTextField();    //创建文本框
        txtfield1.setText("输入书名或者ISBN号");
        txtfield1.setBounds(0,10,400,30);
        JButton search=new JButton("查询");
        search.setBounds(420,10,60,30);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                /**需增加
                 * 判断逻辑
                */
                if (column == 6) {
                    table2.setValueAt("<html><font color='rgb(110,110,110)'>已借</font></html>", row, column);
                }
            }
        });
        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(table2);
        table2.setGridColor(Color.BLACK);
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setBounds(0, 50, 980, 700);
        jp2.add(search);
        jp2.add(txtfield1);
        jp2.add(jScrollPane2);

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
        logout.setBounds(1200, 25, 60, 30);
        contentPane.add(logout);

        // 创建选项卡面板
        tabbedPane = new JTabbedPane();
        tabbedPane.add("已借图书",jp1);
        tabbedPane.add("图书查询借阅",jp2);
        tabbedPane.add("已还图书",jp3);
        tabbedPane.setBounds(200,50,1000,700);
        contentPane.add(tabbedPane);

    }
}