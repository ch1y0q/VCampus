package com.vcampus.client.main;

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

public class ManLibrary extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);

    public ManLibrary() {
        setResizable(true);
        setTitle("图书馆管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1151, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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
        back.setBounds(0, 20, 100, 30);
        contentPane.add(back);

        JButton bookadd = new JButton(res.getString("bookadd"));
        bookadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        bookadd.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        bookadd.setBounds(200, 20, 100, 30);
        contentPane.add(bookadd);

        JLabel tf = new JLabel();
        tf.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        tf.setText("欢迎你:" + "XXX");
        tf.setBounds(450, 20, 180, 30);
        tf.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(tf);

        JButton logout = new JButton(res.getString("logout"));
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
        logout.setBounds(1000, 20, 100, 30);
        contentPane.add(logout);

        JLabel bookmanage=new JLabel("书籍信息管理");
        bookmanage.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        bookmanage.setBounds(60, 55, 200, 30);
        bookmanage.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(bookmanage);

        JTextField txtfield = new JTextField();    //创建文本框
        txtfield.setText("输入书名或者ISBN号");
        txtfield.setBounds(270, 50, 300, 30);
        JButton search = new JButton("查询");
        search.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        search.setBounds(570, 50, 60, 18);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contentPane.add(txtfield);
        contentPane.add(search);

        JLabel recall=new JLabel("按分类检索");
        recall.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        recall.setBounds(650, 50, 200, 30);
        recall.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(recall);
        JComboBox jc=new JComboBox();
        String[] recalltxt={"","中国文学","外国文学","小说诗歌"};
        for(String s :recalltxt){
            jc.addItem(s);
        }
        jc.setBounds(900,50,150,30);
        contentPane.add(jc);

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
        jScrollPane.setBounds(60, 120, 500, 630);
        contentPane.add(jScrollPane);

        JButton edit = new JButton("启动编辑");
        edit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        edit.setBounds(600, 120, 150, 30);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contentPane.add(edit);

        JButton save = new JButton("保存");
        save.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        save.setBounds(760, 120, 150, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        contentPane.add(save);

        JLabel detail=new JLabel("详细信息");
        detail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        detail.setBounds(600, 180, 150, 30);
        detail.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(detail);

        JLabel detailicon=new JLabel("");
        detailicon.setIcon(new ImageIcon(getClass().getResource("/resources/assets/icon/teainformation.jpg")));
        detailicon.setBounds(600,230,200,300);
        contentPane.add(detailicon);

        JLabel ISBNnum=new JLabel("ISBN号");
        ISBNnum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        ISBNnum.setBounds(800, 220, 150, 30);
        ISBNnum.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(ISBNnum);
        JTextField txtISBN = new JTextField();    //创建文本框
        txtISBN.setText("ISBN号");
        txtISBN.setBounds(1000, 220, 100, 30);
        contentPane.add(txtISBN);
        JLabel Bookname=new JLabel("书名");
        Bookname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Bookname.setBounds(800, 250, 150, 30);
        Bookname.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(Bookname);
        JTextField txtBook = new JTextField();    //创建文本框
        txtBook.setText("书名");
        txtBook.setBounds(1000, 250, 100, 30);
        contentPane.add(txtBook);
        JLabel Writer=new JLabel("作者");
        Writer.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Writer.setBounds(800, 280, 150, 30);
        Writer.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(Writer);
        JTextField txtWriter = new JTextField();    //创建文本框
        txtWriter.setText("作者");
        txtWriter.setBounds(1000, 280, 100, 30);
        contentPane.add(txtWriter);
        JLabel Country=new JLabel("作者国籍");
        Country.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Country.setBounds(800, 310, 150, 30);
        Country.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(Country);
        JTextField txtCountry = new JTextField();    //创建文本框
        txtCountry.setText("作者国籍");
        txtCountry.setBounds(1000, 310, 100, 30);
        contentPane.add(txtCountry);
        JLabel Print=new JLabel("出版社");
        Print.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Print.setBounds(800, 340, 150, 30);
        Print.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(Print);
        JTextField txtPrint = new JTextField();    //创建文本框
        txtPrint.setText("出版社");
        txtPrint.setBounds(1000, 340, 100, 30);
        contentPane.add(txtPrint);
        JLabel Classify=new JLabel("分类");
        Classify.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Classify.setBounds(800, 370, 150, 30);
        Classify.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(Classify);
        JTextField txtClassify = new JTextField();    //创建文本框
        txtClassify.setText("分类");
        txtClassify.setBounds(1000, 370, 100, 30);
        contentPane.add(txtClassify);
        JLabel RemainNum=new JLabel("剩余数量");
        RemainNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        RemainNum.setBounds(800, 400, 150, 30);
        RemainNum.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(RemainNum);
        JTextField txtRemain = new JTextField();    //创建文本框
        txtRemain.setText("剩余数量");
        txtRemain.setBounds(1000, 400, 100, 30);
        contentPane.add(txtRemain);
        JLabel Place=new JLabel("摆放位置");
        Place.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Place.setBounds(800, 430, 150, 30);
        Place.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(Place);
        JTextField txtPlace = new JTextField();    //创建文本框
        txtPlace.setText("摆放位置");
        txtPlace.setBounds(1000, 430, 100, 30);
        contentPane.add(txtPlace);
        JLabel Intro=new JLabel("介绍");
        Intro.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Intro.setBounds(800, 460, 150, 30);
        Intro.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.add(Intro);
        JTextField txtIntro = new JTextField();    //创建文本框
        txtIntro.setText("介绍");
        txtIntro.setBounds(1000, 460, 100, 30);
        contentPane.add(txtIntro);

        JLabel Borrow=new JLabel("借书记录");
        Borrow.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Borrow.setBounds(600, 500, 150, 30);
        Borrow.setBorder(new EmptyBorder(0,0,0,0));
        String[] header2 = {"一卡通号","借书时间", "是否归还", "应还时间"};
        String[][] data2 = {{"", "", "", ""}};
        DefaultTableModel model2 = new DefaultTableModel(data2, header2);
        JTable table2 = new JTable(model2);
        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(table);
        table2.setGridColor(Color.BLACK);
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setBounds(600, 550, 500, 200);
        contentPane.add(jScrollPane2);

    }
}