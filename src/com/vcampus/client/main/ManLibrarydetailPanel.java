package com.vcampus.client.main;

import com.vcampus.entity.Book;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManLibrarydetailPanel extends JPanel {
    public JTextField txtISBN;
    public JTextField txtBook;
    public JTextField txtWriter;
    public JTextField txtCountry;
    public JTextField txtPrint;
    public JTextField txtClassify;
    public JTextField txtRemain;
    public JTextField txtPlace;
    public JTextField txtIntro;
    public JLabel detailicon;
    public ManLibrarydetailPanel(){
        setLayout(null);

        JButton bookadd = new JButton("添加书籍");
        bookadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        bookadd.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        bookadd.setBounds(0, 0, 150, 30);
        add(bookadd);

        JButton edit = new JButton("启动编辑");
        edit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        edit.setBounds(160, 0, 150, 30);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit();
            }
        });
        add(edit);

        JButton save = new JButton("保存");
        save.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        save.setBounds(320, 0, 150, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        add(save);
        JLabel detail=new JLabel("详细信息");
        detail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        detail.setBounds(0, 30, 100, 30);
        detail.setBorder(new EmptyBorder(0,0,0,0));
        add(detail);

        detailicon=new JLabel("");
        detailicon.setBounds(0,60,180,240);
        add(detailicon);

        JLabel ISBNnum=new JLabel("ISBN号");
        ISBNnum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        ISBNnum.setBounds(200, 70, 150, 30);
        ISBNnum.setBorder(new EmptyBorder(0,0,0,0));
        add(ISBNnum);
        txtISBN = new JTextField();    //创建文本框
        txtISBN.setBounds(360, 70, 100, 30);
        txtISBN.setEditable(false);
        add(txtISBN);
        JLabel Bookname=new JLabel("书名");
        Bookname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Bookname.setBounds(200, 100, 150, 30);
        Bookname.setBorder(new EmptyBorder(0,0,0,0));
        add(Bookname);
        txtBook = new JTextField();    //创建文本框
        txtBook.setBounds(360, 100, 100, 30);
        txtBook.setEditable(false);
        add(txtBook);
        JLabel Writer=new JLabel("作者");
        Writer.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Writer.setBounds(200, 130, 150, 30);
        Writer.setBorder(new EmptyBorder(0,0,0,0));
        add(Writer);
        txtWriter = new JTextField();    //创建文本框
        txtWriter.setBounds(360, 130, 100, 30);
        txtWriter.setEditable(false);
        add(txtWriter);
        JLabel Country=new JLabel("作者国籍");
        Country.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Country.setBounds(200, 160, 150, 30);
        Country.setBorder(new EmptyBorder(0,0,0,0));
        add(Country);
        txtCountry = new JTextField();    //创建文本框
        txtCountry.setBounds(360, 160, 100, 30);
        txtCountry.setEditable(false);
        add(txtCountry);
        JLabel Print=new JLabel("出版社");
        Print.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Print.setBounds(200, 190, 150, 30);
        Print.setBorder(new EmptyBorder(0,0,0,0));
        add(Print);
        txtPrint = new JTextField();    //创建文本框
        txtPrint.setBounds(360, 190, 100, 30);
        txtPrint.setEditable(false);
        add(txtPrint);
        JLabel Classify=new JLabel("分类");
        Classify.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Classify.setBounds(200, 220, 150, 30);
        Classify.setBorder(new EmptyBorder(0,0,0,0));
        add(Classify);
        txtClassify = new JTextField();    //创建文本框
        txtClassify.setBounds(360, 220, 100, 30);
        txtClassify.setEditable(false);
        add(txtClassify);

        JLabel RemainNum=new JLabel("剩余数量");
        RemainNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        RemainNum.setBounds(200, 250, 150, 30);
        RemainNum.setBorder(new EmptyBorder(0,0,0,0));
        add(RemainNum);
        txtRemain = new JTextField();    //创建文本框
        txtRemain.setBounds(360, 250, 100, 30);
        txtRemain.setEditable(false);
        add(txtRemain);
        JLabel Place=new JLabel("摆放位置");
        Place.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Place.setBounds(200, 280, 150, 30);
        Place.setBorder(new EmptyBorder(0,0,0,0));
        add(Place);
        txtPlace = new JTextField();    //创建文本框
        txtPlace.setBounds(360, 280, 100, 30);
        txtPlace.setEditable(false);
        add(txtPlace);
        JLabel Intro=new JLabel("介绍");
        Intro.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Intro.setBounds(200, 310, 150, 30);
        Intro.setBorder(new EmptyBorder(0,0,0,0));
        add(Intro);
        txtIntro = new JTextField();    //创建文本框
        txtIntro.setBounds(360, 310, 100, 30);
        txtIntro.setEditable(false);
        add(txtIntro);
    }
    public void init()
    {
        Book book;
        book= ResponseUtils.getResponseByHash(
                new Request(App.connectionToServer, null, "com.vcampus.server.library.BookServer.searchBookDetail",
                        new Object[] { "12345" }).send())
                .getReturn(Book.class);
        txtISBN.setText(book.getSerialVersionUID());
        txtBook.setText(book.getName());
        txtWriter.setText(book.getAuthor());
        txtCountry.setText(book.getAuthorCountry());
        txtPrint.setText(book.getPublishingHouse());
        txtClassify.setText(book.getTabs());
        txtRemain.setText(String.valueOf(book.getNumber()));
        txtPlace.setText(book.getPlace());
        txtIntro.setText(book.getIntroduction());
    }
    public void edit(){
        txtISBN.setEditable(true);
        txtBook.setEditable(true);
        txtWriter.setEditable(true);
        txtCountry.setEditable(true);
        txtPrint.setEditable(true);
        txtClassify.setEditable(true);
        txtRemain.setEditable(true);
        txtPlace.setEditable(true);
        txtIntro.setEditable(true);
    }
    public void save(){


    }
    public void addbook(){

    }
}
