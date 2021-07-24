package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
    public ManLibrarydetailPanel(){
        setLayout(null);
        JLabel ISBNnum=new JLabel("ISBN号");
        ISBNnum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        ISBNnum.setBounds(0, 10, 150, 30);
        ISBNnum.setBorder(new EmptyBorder(0,0,0,0));
        add(ISBNnum);
        txtISBN = new JTextField();    //创建文本框
        txtISBN.setBounds(160, 10, 100, 30);
        txtISBN.setEditable(false);
        add(txtISBN);
        JLabel Bookname=new JLabel("书名");
        Bookname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Bookname.setBounds(0, 40, 150, 30);
        Bookname.setBorder(new EmptyBorder(0,0,0,0));
        add(Bookname);
        txtBook = new JTextField();    //创建文本框
        txtBook.setBounds(160, 40, 100, 30);
        txtBook.setEditable(false);
        add(txtBook);
        JLabel Writer=new JLabel("作者");
        Writer.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Writer.setBounds(0, 70, 150, 30);
        Writer.setBorder(new EmptyBorder(0,0,0,0));
        add(Writer);
        txtWriter = new JTextField();    //创建文本框
        txtWriter.setBounds(160, 70, 100, 30);
        txtWriter.setEditable(false);
        add(txtWriter);
        JLabel Country=new JLabel("作者国籍");
        Country.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Country.setBounds(0, 100, 150, 30);
        Country.setBorder(new EmptyBorder(0,0,0,0));
        add(Country);
        txtCountry = new JTextField();    //创建文本框
        txtCountry.setBounds(160, 100, 100, 30);
        txtCountry.setEditable(false);
        add(txtCountry);
        JLabel Print=new JLabel("出版社");
        Print.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Print.setBounds(0, 130, 150, 30);
        Print.setBorder(new EmptyBorder(0,0,0,0));
        add(Print);
        txtPrint = new JTextField();    //创建文本框
        txtPrint.setBounds(160, 130, 100, 30);
        txtPrint.setEditable(false);
        add(txtPrint);
        JLabel Classify=new JLabel("分类");
        Classify.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Classify.setBounds(0, 160, 150, 30);
        Classify.setBorder(new EmptyBorder(0,0,0,0));
        add(Classify);
        txtClassify = new JTextField();    //创建文本框
        txtClassify.setBounds(160, 160, 100, 30);
        txtClassify.setEditable(false);
        add(txtClassify);
        JLabel RemainNum=new JLabel("剩余数量");
        RemainNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        RemainNum.setBounds(0, 190, 150, 30);
        RemainNum.setBorder(new EmptyBorder(0,0,0,0));
        add(RemainNum);
        txtRemain = new JTextField();    //创建文本框
        txtRemain.setBounds(160, 190, 100, 30);
        txtRemain.setEditable(false);
        add(txtRemain);
        JLabel Place=new JLabel("摆放位置");
        Place.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Place.setBounds(0, 220, 150, 30);
        Place.setBorder(new EmptyBorder(0,0,0,0));
        add(Place);
        txtPlace = new JTextField();    //创建文本框
        txtPlace.setBounds(160, 220, 100, 30);
        txtPlace.setEditable(false);
        add(txtPlace);
        JLabel Intro=new JLabel("介绍");
        Intro.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Intro.setBounds(0, 250, 150, 30);
        Intro.setBorder(new EmptyBorder(0,0,0,0));
        add(Intro);
        txtIntro = new JTextField();    //创建文本框
        txtIntro.setBounds(160, 250, 100, 30);
        txtIntro.setEditable(false);
        add(txtIntro);
    }
    public void init()
    {
        txtISBN.setText("");
        txtBook.setText("");
        txtWriter.setText("");
        txtCountry.setText("");
        txtPrint.setText("");
        txtClassify.setText("");
        txtRemain.setText("");
        txtPlace.setText("");
        txtIntro.setText("");
    }
    public void edit(){

    }
    public void save(){

    }
    public void addbook(){

    }
}
