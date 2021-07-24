package com.vcampus.client.main;

import com.vcampus.client.administrator.main.AppAdmin;
import com.vcampus.entity.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Xiao Kaijie
 * @date 2021-07-19
 */

public class ManLibrary extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);

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

        JTree jt=new ManCategory().init();
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

        JButton bookadd = new JButton(res.getString("bookadd"));
        bookadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==bookadd)
                {

                }
            }
        });
        bookadd.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        bookadd.setBounds(800, 20, 200, 30);
        contentPane.add(bookadd);

        JLabel tf = new JLabel();
        tf.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf.setText("欢迎你:" + "XXX");
        tf.setBounds(1000, 20, 180, 30);
        tf.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(tf);

        JButton logout = new JButton(res.getString("logout"));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==logout)
                {

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
        txtfield.setText("输入书名或者ISBN号");
        txtfield.setBounds(470, 50, 300, 30);
        JButton search = new JButton("查询");
        search.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        search.setBounds(770, 50, 60, 18);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==search)
                {

                }
            }
        });
        contentPane.add(txtfield);
        contentPane.add(search);

        JLabel recall=new JLabel("按分类检索");
        recall.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        recall.setBounds(850, 50, 200, 30);
        recall.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(recall);
        JComboBox jc=new JComboBox();
        String[] recalltxt={"","中国文学","外国文学","小说诗歌"};
        for(String s :recalltxt){
            jc.addItem(s);
        }
        jc.setBounds(1000,50,150,30);
        contentPane.add(jc);

        ManLibrarydetailPanel Bookdetail=new ManLibrarydetailPanel();
        Bookdetail.setBackground(new Color(255, 255, 255));
        Bookdetail.setBounds(1000,210,800,300);
        Bookdetail.setVisible(true);
        Bookdetail.init();
        contentPane.add(Bookdetail);

        String[] header = {"序号","ISBN号", "书籍名称", "剩余数量", "作者","详细信息"};
        String[][] data = {{"", "", "", "", "", ""}};
        DefaultTableModel model = new DefaultTableModel(data, header);
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
                 * 点击逻辑
                 */
                if (column == 6) {
                    table.setValueAt("<html><font color='rgb(110,110,110)'>查看</font></html>", row, column);
                }
            }
        });
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        table.setGridColor(Color.BLACK);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setBounds(260, 120, 500, 630);
        contentPane.add(jScrollPane);

        JButton edit = new JButton("启动编辑");
        edit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        edit.setBounds(800, 120, 150, 30);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contentPane.add(edit);

        JButton save = new JButton("保存");
        save.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        save.setBounds(960, 120, 150, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contentPane.add(save);

        JLabel detail=new JLabel("详细信息");
        detail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        detail.setBounds(800, 180, 100, 30);
        detail.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(detail);

        JLabel detailicon=new JLabel("");
        detailicon.setIcon(new ImageIcon());
        detailicon.setBounds(800,230,180,200);
        contentPane.add(detailicon);

        JLabel Borrow=new JLabel("借书记录");
        Borrow.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Borrow.setBounds(800, 500, 150, 30);
        Borrow.setBorder(new EmptyBorder(0,0,0,0));
        String[] header2 = {"一卡通号","借书时间", "是否归还", "应还时间"};
        String[][] data2 = {{"", "", "", ""}};
        DefaultTableModel model2 = new DefaultTableModel(data2, header2);
        JTable table2 = new JTable(model2);
        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(table2);
        table2.setGridColor(Color.BLACK);
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setBounds(800, 550, 500, 200);
        contentPane.add(jScrollPane2);

    }
}