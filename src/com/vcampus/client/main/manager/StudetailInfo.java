package com.vcampus.client.main.manager;

import com.vcampus.client.main.App;
import com.vcampus.client.main.library.ManagerLibrary.ManlibdetailHelper;
import com.vcampus.entity.Student;
import com.vcampus.net.Request;
import com.vcampus.net.Response;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * @author Xiao Kaijie
 * @date 2021-07-13
 */

public class StudetailInfo extends JPanel {
    String[] strText=new String[11];
    public JLabel detailicon;
    public JTextField txtname;
    public JTextField txtcard;
    public JTextField txtSex;
    public JTextField txtacademy;
    public JTextField Stunum;
    public JTextField Studorm;
    public JTextField txtbodynumber;
    public JTextField txtemail;
    public JTextField txtphone;
    public StudetailInfo()
    {
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        JLabel detail=new JLabel("详细信息");
        detail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        detail.setBounds(0, 0, 80, 30);
        detail.setBorder(new EmptyBorder(0,0,0,0));
        add(detail);

        detailicon=new JLabel("");
        detailicon.setIcon(new ImageIcon());
        detailicon.setBounds(0,40,80,100);
        add(detailicon);

        JLabel Teaname=new JLabel("姓名");
        Teaname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaname.setBounds(100, 10, 80, 30);
        Teaname.setBorder(new EmptyBorder(0,0,0,0));
        add(Teaname);
        txtname = new JTextField();    //创建文本框
        txtname.setBounds(190, 10, 100, 30);
        txtname.setEditable(false);
        add(txtname);
        JLabel cardnumber=new JLabel("一卡通号");
        cardnumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        cardnumber.setBounds(100, 40, 80, 30);
        cardnumber.setBorder(new EmptyBorder(0,0,0,0));
        add(cardnumber);
        txtcard = new JTextField();    //创建文本框
        txtcard.setBounds(190, 40, 100, 30);
        txtcard.setEditable(false);
        add(txtcard);
        JLabel Sex=new JLabel("性别");
        Sex.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Sex.setBounds(100,70 , 80, 30);
        Sex.setBorder(new EmptyBorder(0,0,0,0));
        add(Sex);
        txtSex = new JTextField();    //创建文本框
        txtSex.setBounds(190, 70, 100, 30);
        txtSex.setEditable(false);
        add(txtSex);
        JLabel Teaacademy=new JLabel("学院");
        Teaacademy.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaacademy.setBounds(100, 100, 80, 30);
        Teaacademy.setBorder(new EmptyBorder(0,0,0,0));
        add(Teaacademy);
        txtacademy = new JTextField();    //创建文本框
        txtacademy.setBounds(190, 100, 100, 30);
        txtacademy.setEditable(false);
        add(txtacademy);
        JLabel Stunumber=new JLabel("学号");
        Stunumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Stunumber.setBounds(100, 130, 90, 30);
        Stunumber.setBorder(new EmptyBorder(0,0,0,0));
        add(Stunumber);
        Stunum = new JTextField();    //创建文本框
        Stunum.setBounds(190, 130, 100, 30);
        Stunum.setEditable(false);
        add(Stunum);
        JLabel Studormad=new JLabel("宿舍");
        Studormad.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Studormad.setBounds(100, 160, 90, 30);
        Studormad.setBorder(new EmptyBorder(0,0,0,0));
        add(Studormad);
        Studorm = new JTextField();    //创建文本框
        Studorm.setBounds(190, 160, 100, 30);
        Studorm.setEditable(false);
        add(Studorm);
        JLabel bodynumber=new JLabel("银行卡号");
        bodynumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        bodynumber.setBounds(300, 10, 80, 30);
        bodynumber.setBorder(new EmptyBorder(0,0,0,0));
        add(bodynumber);
        txtbodynumber = new JTextField();    //创建文本框
        txtbodynumber.setBounds(390, 10, 200, 30);
        txtbodynumber.setEditable(false);
        add(txtbodynumber);
        JLabel Teaemail=new JLabel("邮箱");
        Teaemail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaemail.setBounds(300, 70, 80, 30);
        Teaemail.setBorder(new EmptyBorder(0,0,0,0));
        add(Teaemail);
        txtemail = new JTextField();    //创建文本框
        txtemail.setBounds(390, 70, 200, 30);
        txtemail.setEditable(false);
        add(txtemail);
        JLabel phone=new JLabel("电话");
        phone.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        phone.setBounds(300, 130, 80, 30);
        phone.setBorder(new EmptyBorder(0,0,0,0));
        add(phone);
        txtphone = new JTextField();    //创建文本框
        txtphone.setBounds(390, 130, 200, 30);
        txtphone.setEditable(false);
        add(txtphone);

        JButton edit = new JButton("添加编辑");
        edit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        edit.setBounds(600, 10, 200, 30);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==edit)
                {
                    txtname.setEditable(true);
                    txtcard.setEditable(true);
                    txtSex.setEditable(true);
                    Stunum.setEditable(true);
                    txtacademy.setEditable(true);
                    Studorm.setEditable(true);
                    txtbodynumber.setEditable(true);
                    txtemail.setEditable(true);
                    txtphone.setEditable(true);
                }
            }
        });
        add(edit);

        JButton save = new JButton("保存");
        save.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        save.setBounds(600, 50, 200, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==save)
                {
                    saveChange();
                }
            }
        });
        add(save);

        JButton Studelete = new JButton("删除该条学生信息");
        Studelete.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Studelete.setBounds(600, 90, 200, 30);
        Studelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==Studelete)
                {
                    deleteStu(txtcard.getText());
                }
            }
        });
        add(Studelete);

        JButton StuSureAdd = new JButton("确认添加学生");
        StuSureAdd.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        StuSureAdd.setBounds(600, 130, 200, 30);
        StuSureAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==StuSureAdd)
                {
                    Student student=new Student();
                    student.setName(txtname.getText());
                    student.setCardNumber(txtcard.getText());
                    student.setGender(txtSex.getText());
                    student.setStudentNumber(Stunum.getText());
                    student.setSchool(txtacademy.getText());
                    student.setDormAddress(Studorm.getText());
                    student.setBankAccount(txtbodynumber.getText());
                    student.setEmail(txtemail.getText());
                    student.setPhoneNumber(txtphone.getText());
                    AddStu(student);
                    closeedit();
                }
            }
        });
        add(StuSureAdd);

    }
    public void initnow(){
        txtname.setText("");
        txtcard.setText("");
        txtSex.setText("");
        txtacademy.setText("");
        Stunum.setText("");
        Studorm.setText("");
        txtbodynumber.setText("");
        txtemail.setText("");
        txtphone.setText("");
    }
    public void init(String cardNumber)
    {
        Student student=new Student();
        student= ResponseUtils.getResponseByHash(
                new Request(App.connectionToServer, null, "com.vcampus.server.StudentManage.getStudentDetailByCardNumber",
                        new Object[] { cardNumber }).send())
                .getReturn(Student.class);

        txtname.setText(student.getName());
        txtcard.setText(student.getCardNumber());
        txtSex.setText(student.getGender());
        txtacademy.setText(student.getSchool());
        Stunum.setText(student.getStudentNumber());
        Studorm.setText(student.getDormAddress());
        txtbodynumber.setText(student.getBankAccount());
        txtemail.setText(student.getEmail());
        txtphone.setText(student.getPhoneNumber());
    }
    public void deleteStu(String cardNumber)
    {
        Response resp = ResponseUtils.getResponseByHash(new Request(App.connectionToServer, null,
                "com.vcampus.server.StudentManage.deleteStudent", new Object[] { cardNumber }).send());
        if (resp.getReturn(Boolean.class)) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }
    public void AddStu(Student student)
    {
        Response resp = ResponseUtils.getResponseByHash(new Request(App.connectionToServer, null,
                "com.vcampus.server.StudentManage.insertStudent", new Object[] { student }).send());
        if (resp.getReturn(Boolean.class)) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }
    public void closeedit()
    {
        txtname.setEditable(false);
        txtcard.setEditable(false);
        txtSex.setEditable(false);
        Stunum.setEditable(false);
        txtacademy.setEditable(false);
        Studorm.setEditable(false);
        txtbodynumber.setEditable(false);
        txtemail.setEditable(false);
        txtphone.setEditable(false);
    }
    public void saveChange(){
        closeedit();
        String cardNumber=txtcard.getText();
        String studentNumber=Stunum.getText();
        String school=txtacademy.getText();
        String dormAddress=Studorm.getText();

        HashMap<String,String> mapResetTabs = new HashMap<String, String>();
        mapResetTabs.put("cardNumber", cardNumber );
        mapResetTabs.put("studentNumber",studentNumber);
        StuManageHelper.resetStudentNumberByCard(mapResetTabs);

        HashMap<String,String> mapResetNum = new HashMap<String, String>();
        mapResetNum.put("cardNumber", cardNumber);
        mapResetNum.put("school",school);
        StuManageHelper.resetSchoolByCard(mapResetNum);

        HashMap<String,String> mapResetPlace = new HashMap<String, String>();
        mapResetPlace.put("cardNumber", cardNumber);
        mapResetPlace.put("dormAddress",dormAddress);
        StuManageHelper.resetDormByCard(mapResetPlace);
    }

    public void changeedit()
    {
        closeedit();
        Stunum.setEditable(true);
        txtacademy.setEditable(true);
        Studorm.setEditable(true);
    }
}
