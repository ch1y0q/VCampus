package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ManLibrarydetailPanel extends JPanel {
    public JPanel ManLibdetail=new JPanel();
    public JPanel init(){
        ManLibdetail.setLayout(null);
        JLabel ISBNnum=new JLabel("ISBN号");
        ISBNnum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        ISBNnum.setBounds(0, 10, 150, 30);
        ISBNnum.setBorder(new EmptyBorder(0,0,0,0));
        ManLibdetail.add(ISBNnum);
        JTextField txtISBN = new JTextField();    //创建文本框
        txtISBN.setText("ISBN号");
        txtISBN.setBounds(160, 10, 100, 30);
        ManLibdetail.add(txtISBN);
        JLabel Bookname=new JLabel("书名");
        Bookname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Bookname.setBounds(0, 40, 150, 30);
        Bookname.setBorder(new EmptyBorder(0,0,0,0));
        ManLibdetail.add(Bookname);
        JTextField txtBook = new JTextField();    //创建文本框
        txtBook.setText("书名");
        txtBook.setBounds(160, 40, 100, 30);
        ManLibdetail.add(txtBook);
        JLabel Writer=new JLabel("作者");
        Writer.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Writer.setBounds(0, 70, 150, 30);
        Writer.setBorder(new EmptyBorder(0,0,0,0));
        ManLibdetail.add(Writer);
        JTextField txtWriter = new JTextField();    //创建文本框
        txtWriter.setText("作者");
        txtWriter.setBounds(160, 70, 100, 30);
        ManLibdetail.add(txtWriter);
        JLabel Country=new JLabel("作者国籍");
        Country.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Country.setBounds(0, 100, 150, 30);
        Country.setBorder(new EmptyBorder(0,0,0,0));
        ManLibdetail.add(Country);
        JTextField txtCountry = new JTextField();    //创建文本框
        txtCountry.setText("作者国籍");
        txtCountry.setBounds(160, 100, 100, 30);
        ManLibdetail.add(txtCountry);
        JLabel Print=new JLabel("出版社");
        Print.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Print.setBounds(0, 130, 150, 30);
        Print.setBorder(new EmptyBorder(0,0,0,0));
        ManLibdetail.add(Print);
        JTextField txtPrint = new JTextField();    //创建文本框
        txtPrint.setText("出版社");
        txtPrint.setBounds(160, 130, 100, 30);
        ManLibdetail.add(txtPrint);
        JLabel Classify=new JLabel("分类");
        Classify.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Classify.setBounds(0, 160, 150, 30);
        Classify.setBorder(new EmptyBorder(0,0,0,0));
        ManLibdetail.add(Classify);
        JTextField txtClassify = new JTextField();    //创建文本框
        txtClassify.setText("分类");
        txtClassify.setBounds(160, 160, 100, 30);
        ManLibdetail.add(txtClassify);
        JLabel RemainNum=new JLabel("剩余数量");
        RemainNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        RemainNum.setBounds(0, 190, 150, 30);
        RemainNum.setBorder(new EmptyBorder(0,0,0,0));
        ManLibdetail.add(RemainNum);
        JTextField txtRemain = new JTextField();    //创建文本框
        txtRemain.setText("剩余数量");
        txtRemain.setBounds(160, 190, 100, 30);
        ManLibdetail.add(txtRemain);
        JLabel Place=new JLabel("摆放位置");
        Place.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Place.setBounds(0, 220, 150, 30);
        Place.setBorder(new EmptyBorder(0,0,0,0));
        ManLibdetail.add(Place);
        JTextField txtPlace = new JTextField();    //创建文本框
        txtPlace.setText("摆放位置");
        txtPlace.setBounds(160, 220, 100, 30);
        ManLibdetail.add(txtPlace);
        JLabel Intro=new JLabel("介绍");
        Intro.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Intro.setBounds(0, 250, 150, 30);
        Intro.setBorder(new EmptyBorder(0,0,0,0));
        ManLibdetail.add(Intro);
        JTextField txtIntro = new JTextField();    //创建文本框
        txtIntro.setText("介绍");
        txtIntro.setBounds(160, 250, 100, 30);
        ManLibdetail.add(txtIntro);

        return ManLibdetail;
    }
}
