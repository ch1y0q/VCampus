package com.vcampus.client.main.manager;

import com.vcampus.client.main.App;
import com.vcampus.entity.Student;
import com.vcampus.entity.Teacher;
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
 * 教师信息详情面板
 * @author Xiao Kaijie
 * @date 2021-07-14
 */
public class TeaMandetailPanel extends JPanel {
    public JTextField txtname;
    public JTextField txtcard;
    public JTextField txtSex;
    public JTextField txtacademy;
    public JTextField txtlevel;
    public JTextField txtemail;
    public JTextField txtEntry;
    public JTextField txtphone;
    public JTextField txtTeaNum;
    public TeaMandetailPanel(){
        setLayout(null);
        JLabel detail=new JLabel("详细信息");
        detail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        detail.setBounds(0, 0, 80, 30);
        detail.setBorder(new EmptyBorder(0,0,0,0));
        add(detail);

        JLabel detailicon=new JLabel("");
        detailicon.setIcon(new ImageIcon());
        detailicon.setBounds(0,40,80,100);
        add(detailicon);

        JLabel Teaname=new JLabel("姓名");
        Teaname.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaname.setBounds(100, 10, 80, 30);
        Teaname.setBorder(new EmptyBorder(0,0,0,0));
        add(Teaname);
        txtname = new JTextField();    //创建文本框
        txtname.setText("姓名");
        txtname.setBounds(190, 10, 150, 30);
        txtname.setEditable(false);
        add(txtname);
        JLabel cardnumber=new JLabel("一卡通号");
        cardnumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        cardnumber.setBounds(100, 40, 80, 30);
        cardnumber.setBorder(new EmptyBorder(0,0,0,0));
        add(cardnumber);
        txtcard = new JTextField();    //创建文本框
        txtcard.setText("一卡通号");
        txtcard.setBounds(190, 40, 150, 30);
        txtcard.setEditable(false);
        add(txtcard);
        JLabel Sex=new JLabel("性别");
        Sex.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Sex.setBounds(100,70 , 80, 30);
        Sex.setBorder(new EmptyBorder(0,0,0,0));
        add(Sex);
        txtSex = new JTextField();    //创建文本框
        txtSex.setText("性别");
        txtSex.setBounds(190, 70, 150, 30);
        txtSex.setEditable(false);
        add(txtSex);
        JLabel Teaacademy=new JLabel("学院");
        Teaacademy.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaacademy.setBounds(100, 100, 80, 30);
        Teaacademy.setBorder(new EmptyBorder(0,0,0,0));
        add(Teaacademy);
        txtacademy = new JTextField();    //创建文本框
        txtacademy.setText("学院");
        txtacademy.setBounds(190, 100, 150, 30);
        txtacademy.setEditable(false);
        add(txtacademy);
        JLabel Tealevel=new JLabel("职称");
        Tealevel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Tealevel.setBounds(100, 130, 90, 30);
        Tealevel.setBorder(new EmptyBorder(0,0,0,0));
        add(Tealevel);
        txtlevel = new JTextField();    //创建文本框
        txtlevel.setText("职称");
        txtlevel.setBounds(190, 130, 150, 30);
        txtlevel.setEditable(false);
        add(txtlevel);
        JLabel Teaemail=new JLabel("邮箱");
        Teaemail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        Teaemail.setBounds(400, 10, 150, 30);
        Teaemail.setBorder(new EmptyBorder(0,0,0,0));
        add(Teaemail);
        txtemail = new JTextField();    //创建文本框
        txtemail.setText("邮箱");
        txtemail.setBounds(560, 10, 150, 30);
        txtemail.setEditable(false);
        add(txtemail);
        JLabel selfEntry=new JLabel("个人主页链接");
        selfEntry.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        selfEntry.setBounds(400, 40, 150, 30);
        selfEntry.setBorder(new EmptyBorder(0,0,0,0));
        add(selfEntry);
        txtEntry = new JTextField();    //创建文本框
        txtEntry.setText("个人主页链接");
        txtEntry.setBounds(560, 40, 150, 30);
        txtEntry.setEditable(false);
        add(txtEntry);
        JLabel phone=new JLabel("电话");
        phone.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        phone.setBounds(400, 70, 150, 30);
        phone.setBorder(new EmptyBorder(0,0,0,0));
        add(phone);
        txtphone = new JTextField();    //创建文本框
        txtphone.setText("电话");
        txtphone.setBounds(560, 70, 150, 30);
        txtphone.setEditable(false);
        add(txtphone);
        JLabel TeaNumber=new JLabel("工号");
        TeaNumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        TeaNumber.setBounds(400, 100, 150, 30);
        TeaNumber.setBorder(new EmptyBorder(0,0,0,0));
        add(TeaNumber);
        txtTeaNum = new JTextField();    //创建文本框
        txtTeaNum.setText("工号");
        txtTeaNum.setBounds(560, 100, 150, 30);
        txtTeaNum.setEditable(false);
        add(txtTeaNum);
        JButton nodTeaSureAdd = new JButton("确认添加老师");
        nodTeaSureAdd.setEnabled(false);
        JButton save = new JButton("保存");
        JButton nodTeaedit = new JButton("编辑添加教师信息");
        nodTeaedit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        nodTeaedit.setBounds(800, 10, 200, 30);
        /**
         * 教师信息编辑启动
         */
        nodTeaedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(e.getSource()==nodTeaedit)
            {
                txtname.setEditable(true);
                txtcard.setEditable(true);
                txtSex.setEditable(true);
                txtacademy.setEditable(true);
                txtlevel.setEditable(true);
                txtemail.setEditable(true);
                txtTeaNum.setEditable(true);
                txtEntry.setEditable(true);
                txtphone.setEditable(true);
                nodTeaSureAdd.setEnabled(true);
                save.setEnabled(false);
            }
            }
        });
        add(nodTeaedit);

        save.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        save.setBounds(800, 50, 200, 30);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChange();
            }
        });
        add(save);

        JButton nodTeadelete = new JButton("删除该条教师信息");
        nodTeadelete.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        nodTeadelete.setBounds(800, 90, 200, 30);
        /**
         * 教师信息删除
         */
        nodTeadelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTea(txtcard.getText());
            }
        });
        add(nodTeadelete);


        nodTeaSureAdd.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        nodTeaSureAdd.setBounds(800, 130, 200, 30);
        /**
         * 教师信息添加
         */
        nodTeaSureAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==nodTeaSureAdd)
                {
                    Teacher teacher=new Teacher();
                    teacher.setName(txtname.getText());
                    teacher.setCardNumber(txtcard.getText());
                    teacher.setGender(txtSex.getText());
                    teacher.setSchool(txtacademy.getText());
                    teacher.setTeacherRank(txtlevel.getText());
                    teacher.setTeacherNumber(txtTeaNum.getText());
                    teacher.setEmail(txtemail.getText());
                    teacher.setHomepage(txtEntry.getText());
                    teacher.setPhoneNumber(txtphone.getText());
                    AddTea(teacher);
                    nodTeaSureAdd.setEnabled(false);
                    save.setEnabled(true);
                    closeedit();
                }
            }
        });
        add(nodTeaSureAdd);

    }
    /**
     * 教师信息设空
     */
    public void initnow(){
        txtname.setText("");
        txtcard.setText("");
        txtSex.setText("");
        txtacademy.setText("");
        txtlevel.setText("");
        txtTeaNum.setText("");
        txtEntry.setText("");
        txtemail.setText("");
        txtphone.setText("");
    }
    /**
     * 教师信息初始化
     */
    public void init(String cardNumber)
    {
        Teacher teacher=new Teacher();
        teacher= ResponseUtils.getResponseByHash(
                new Request(App.connectionToServer, null, "com.vcampus.server.TeacherManage.getTeacherDetailByCardNumber",
                        new Object[] { cardNumber }).send())
                .getReturn(Teacher.class);

        txtname.setText(teacher.getName());
        txtcard.setText(teacher.getCardNumber());
        txtSex.setText(teacher.getGender());
        txtacademy.setText(teacher.getSchool());
        txtlevel.setText(teacher.getTeacherRank());
        txtTeaNum.setText(teacher.getTeacherNumber());
        txtEntry.setText(teacher.getHomepage());
        txtemail.setText(teacher.getEmail());
        txtphone.setText(teacher.getPhoneNumber());
    }
    /**
     * 教师信息删除
     */
    public void deleteTea(String cardNumber)
    {
        Response resp = ResponseUtils.getResponseByHash(new Request(App.connectionToServer, null,
                "com.vcampus.server.TeacherManage.deleteTeacher", new Object[] { cardNumber }).send());
        if (resp.getReturn(Boolean.class)) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }
    /**
     * 教师信息添加
     */
    public void AddTea(Teacher teacher)
    {
        Response resp = ResponseUtils.getResponseByHash(new Request(App.connectionToServer, null,
                "com.vcampus.server.TeacherManage.insertTeacher", new Object[] { teacher }).send());
        if (resp.getReturn(Boolean.class)) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }
    /**
     * 教师信息关闭编辑
     */
    public void closeedit()
    {
        txtname.setEditable(false);
        txtcard.setEditable(false);
        txtSex.setEditable(false);
        txtacademy.setEditable(false);
        txtlevel.setEditable(false);
        txtTeaNum.setEditable(false);
        txtEntry.setEditable(false);
        txtemail.setEditable(false);
        txtphone.setEditable(false);
    }
    /**
     * 教师信息保存
     */
    public void saveChange(){
        closeedit();
        String cardNumber=txtcard.getText();
        String teacherNumber=txtTeaNum.getText();
        String school=txtacademy.getText();
        String teacherRank=txtlevel.getText();

        HashMap<String,String> mapResetTabs = new HashMap<String, String>();
        mapResetTabs.put("cardNumber", cardNumber );
        mapResetTabs.put("teacherNumber",teacherNumber);
        TeaManageHelper.resetTeacherNumberByCard(mapResetTabs);

        HashMap<String,String> mapResetNum = new HashMap<String, String>();
        mapResetNum.put("cardNumber", cardNumber);
        mapResetNum.put("school",school);
        TeaManageHelper.resetSchoolByCard(mapResetNum);

        HashMap<String,String> mapResetPlace = new HashMap<String, String>();
        mapResetPlace.put("cardNumber", cardNumber);
        mapResetPlace.put("teacherRank",teacherRank);
        TeaManageHelper.resetTeacherRankByCard(mapResetPlace);
    }
    /**
     * 教师信息改变编辑
     */
    public void changeedit(){
        closeedit();
        txtacademy.setEditable(true);
        txtlevel.setEditable(true);
        txtTeaNum.setEditable(true);
    }
}
