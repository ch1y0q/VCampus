package com.vcampus.client.main.dailyReport;

import com.alee.managers.style.StyleId;
import com.vcampus.UI.labels.MyJLabel2;
import com.vcampus.client.main.App;
import com.vcampus.client.main.student.AppStudent;
import com.vcampus.entity.PersonWhoReport;
import com.vcampus.net.Request;
import com.vcampus.net.Response;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Hashtable;

/**
 * 学生教师每日上报的panel
 * @author Dong Ruojing
 * @date 2021/7/28
 */

public class DailyReportPanel extends JPanel {
    public DailyReportPanel(){
        setLayout(null);
        setBackground(new Color(240, 255, 240));

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);

        //返回按钮
        JButton back = new JButton("返回主页");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==back)
                {
                    setVisible(false);//合并的时候这一块不需要，这只能做到jpanel消失
                }
            }
        });
        back.setBounds(0, 20, 100, 30);
        back.setFont(new Font("微软雅黑", Font.BOLD, 14));
        back.setForeground(new Color(33, 117, 206,100));
        add(back);


        JPanel paneDetail=new JPanel();
        add(paneDetail);
        paneDetail.setLayout(null);
        paneDetail.setBounds(0,70,300,220);
        paneDetail.setBackground(new Color(0xC0C0F6));
        MyJLabel2 lblBasicInfo = new MyJLabel2();
        lblBasicInfo.setText("基本信息");
        lblBasicInfo.setFont(new Font("微软雅黑", Font.BOLD, 18));
        lblBasicInfo.setBounds(0,0,100,50);
        lblBasicInfo.setForeground(Color.WHITE);
        paneDetail.add(lblBasicInfo);
        JLabel lblCardNumber = new JLabel();
        lblCardNumber.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblCardNumber.setText("一卡通号:  "+" "+ App.session.getPersonBelongsToSchool().getCardNumber());
        lblCardNumber.setBounds(10, 50, 180, 30);
        lblCardNumber.setBorder(new EmptyBorder(0,0,0,0));
        paneDetail.add(lblCardNumber);

        JLabel jlName = new JLabel();
        jlName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jlName.setText("姓名:        "+" "+App.session.getPersonBelongsToSchool().getName());
        jlName.setBounds(10, 100, 180, 30);
        jlName.setBorder(new EmptyBorder(0,0,0,0));
        paneDetail.add(jlName);

        JLabel lblSchool = new JLabel();
        lblSchool.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblSchool.setText("学院:        "+" "+App.session.getPersonBelongsToSchool().getSchool());
        lblSchool.setBounds(10, 150, 250, 30);
        lblSchool.setBorder(new EmptyBorder(0,0,0,0));
        paneDetail.add(lblSchool);

        JPanel paneDaily=new JPanel();
        paneDaily.setLayout(null);
        add(paneDaily);
        paneDaily.setBounds(330,70,350,470);
        paneDaily.setBackground(new Color(0xE0CDFA));
        MyJLabel2 lblDailyInfo = new MyJLabel2();
        lblDailyInfo.setText("每日情况");
        lblDailyInfo.setForeground(Color.WHITE);
        lblDailyInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblDailyInfo.setBounds(0,0,100,50);
        paneDaily.add(lblDailyInfo);

        JLabel lblTemperature =new JLabel("当日晨检温度");
        lblTemperature.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblTemperature.setBounds(10, 50,150,30);
        paneDaily.add(lblTemperature);

        JTextField txtTemperature=new JTextField();
        txtTemperature.setBounds(170,50,60,30);
        txtTemperature.setFont(new Font("微软雅黑", Font.BOLD, 16));
        txtTemperature.setEditable(false);
        paneDaily.add(txtTemperature);

        JLabel lblLocation=new JLabel("目前所在位置");
        lblLocation.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblLocation.setBounds(10,90,150,30);
        paneDaily.add(lblLocation);
        String[]onOrOffCampus={"在校内","在校外"};
        JComboBox cmbLocal=new JComboBox(onOrOffCampus);
        cmbLocal.setBounds(170,90,150,30);
        paneDaily.add(cmbLocal);

        MyJLabel2 lblHealth= new MyJLabel2();//设置健康标签
        lblHealth.setText("今日体温：37℃");
        lblHealth.setBounds(800,90,280,60);
        lblHealth.setFont(new Font("微软雅黑", Font.BOLD, 23));
        lblHealth.setOpaque(true);
        lblHealth.setBackground(new Color(0xC9B6F3F1, true));
        lblHealth.setForeground(new Color(0xF22D8B4C, true));
        lblHealth.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblHealth);

        MyJLabel2 lblAdvice= new MyJLabel2();//设置建议标签
        lblAdvice.setText("体温正常");
        lblAdvice.setBounds(800,170,280,60);
        lblAdvice.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblAdvice.setOpaque(true);
        lblAdvice.setBackground(new Color(0x53ADA2));
        lblAdvice.setForeground(new Color(0xF2FFFFFF));
        lblAdvice.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblAdvice);

        MyJLabel2 lblAdvice2= new MyJLabel2();//设置建议标签
        lblAdvice2.setText("开启快乐学习生活(≧∇≦)ﾉ");
        lblAdvice2.setBounds(800,250,280,60);
        lblAdvice2.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblAdvice2.setOpaque(true);
        lblAdvice2.setBackground(new Color(0x357171));
        lblAdvice2.setForeground(new Color(0xF2FFFFFF));
        lblAdvice2.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblAdvice2);

        //slider
        //设置小数，需要计算
        Hashtable labelTable = new Hashtable();
        for (int i=0;i<=40;i+=5){
            labelTable.put(i,new JLabel(String.valueOf(36+(double)i/10+" ")));

        }
        final JSlider slider = new JSlider(0, 40, 10);//40个格子，开始的时候在37度位置，也就是10
        // 设置主刻度间隔
        slider.setLabelTable(labelTable);
        slider.setMajorTickSpacing(5);
        // 设置次刻度间隔
        slider.setMinorTickSpacing(1);
        // 绘制 刻度 和 标签
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        // 不对齐到刻度
        slider.setSnapToTicks(false);
        //设置垂直
        slider.setOrientation(SwingConstants.VERTICAL);
        // 添加刻度改变监听器

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double temperature=36+(double)(slider.getValue())/10;
                //System.out.println("当前值: " + slider.getValue());
                txtTemperature.setText(String.valueOf(temperature));
                lblHealth.setText("今日体温："+String.valueOf(temperature)+"℃");
                if(temperature<37.3)
                {
                    txtTemperature.setForeground(new Color(0xF22D8B4C, true));
                    lblHealth.setForeground(new Color(0xF22D8B4C, true));
                    lblAdvice.setText("体温正常");
                    lblAdvice2.setText("开启快乐学习生活(≧∇≦)ﾉ");
                    lblHealth.setBackground(new Color(0xC9B6F3F1, true));
                    lblAdvice.setBackground(new Color(0x53ADA2));
                    lblAdvice2.setBackground(new Color(0x357171));
                } else if(temperature<37.9){
                    txtTemperature.setForeground(new Color(0xD4733F));
                    lblHealth.setForeground(new Color(0xD4733F));
                    lblAdvice.setText("体温较高");
                    lblAdvice2.setText("需要注意身体QAQ");
                    lblHealth.setBackground(new Color(0xFDECE581, true));
                    lblAdvice.setBackground(new Color(0xE3A75F));
                    lblAdvice2.setBackground(new Color(0xE78C5B));
                } else{
                    txtTemperature.setForeground(new Color(0xEA0909));
                    lblHealth.setForeground(new Color(0xEA0909));
                    lblAdvice.setText("发烧啦！");
                    lblAdvice2.setText("请快去医院o(╥﹏╥)o");
                    lblHealth.setBackground(new Color(0xC9E78D8A, true));
                    lblAdvice.setBackground(new Color(0xDC6757));
                    lblAdvice2.setBackground(new Color(0xEA3423));
                }
                txtTemperature.repaint();
                lblHealth.repaint();
                lblAdvice.repaint();
                lblAdvice2.repaint();
            }

        });
        slider.setBounds(720,70,60,600);
        add(slider);

        JLabel lblCampus=new JLabel("目前所在校区");
        lblCampus.setBounds(10,130,150,30);
        lblCampus.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        String[] campuses={"九龙湖校区","四牌楼校区","丁家桥校区"};
        JComboBox cmbCampus=new JComboBox(campuses);
        cmbCampus.setBounds(170,130,150,30);

        JLabel lblExactLocation=new JLabel("具体所在城市");
        lblExactLocation.setBounds(10,170,150,30);
        lblExactLocation.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        JTextField txtExact=new JTextField();
        txtExact.setBounds(170,170,150,30);

        cmbLocal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==cmbLocal) {
                    if (cmbLocal.getSelectedItem().toString() == "在校外") {
                        paneDaily.add(lblExactLocation);
                        paneDaily.add(txtExact);
                        paneDaily.remove(cmbCampus);
                        paneDaily.remove(lblCampus);
                        paneDaily.repaint();
                    }
                    else if(cmbLocal.getSelectedItem().toString() == "在校内"){
                        paneDaily.add(cmbCampus);
                        paneDaily.add(lblCampus);
                        paneDaily.remove(lblExactLocation);
                        paneDaily.remove(txtExact);
                        paneDaily.repaint();
                    }
                }
            }
        });

        JLabel lblQuarantined=new JLabel("今天是否还在隔离期");
        lblQuarantined.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblQuarantined.setBounds(10,210,150,30);
        paneDaily.add(lblQuarantined);
        String[] strYN={"是","否"};
        JComboBox cmbQuarantined=new JComboBox(strYN);
        cmbQuarantined.setBounds(170,210,150,30);
        paneDaily.add(cmbQuarantined);

        JLabel lblSuspectedCase=new JLabel("目前是否为疑似病例");
        lblSuspectedCase.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblSuspectedCase.setBounds(10,250,150,30);
        paneDaily.add(lblSuspectedCase);
        JComboBox cmbSuspectedCase=new JComboBox(strYN);
        cmbSuspectedCase.setBounds(170,250,150,30);
        paneDaily.add(cmbSuspectedCase);

        JLabel lblDiagnosed=new JLabel("目前是否为确诊病例");
        lblDiagnosed.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblDiagnosed.setBounds(10,290,150,30);
        paneDaily.add(lblDiagnosed);
        JComboBox cmbDiagnosed=new JComboBox(strYN);
        cmbDiagnosed.setBounds(170,290,150,30);
        paneDaily.add(cmbDiagnosed);

        JLabel lblRiskyVisit=new JLabel("存在风险区旅居史");
        lblRiskyVisit.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblRiskyVisit.setBounds(10,330,150,30);
        paneDaily.add(lblRiskyVisit);
        JComboBox cmbRiskyVisit=new JComboBox(strYN);
        cmbRiskyVisit.setBounds(170,330,150,30);
        paneDaily.add(cmbRiskyVisit);


        //上传
        final JButton btnUpload = new JButton("上传");
        btnUpload.putClientProperty( StyleId.STYLE_PROPERTY, StyleId.buttonHover);
        btnUpload.setBounds(250, 430, 80, 30);
        btnUpload.setOpaque(true);
        btnUpload.setFont( new Font("微软雅黑", Font.BOLD, 18));
        btnUpload.setForeground(new Color(0xD5B8B8));
        btnUpload.setBackground(new Color(0xDA61A4B8, true));
        btnUpload.setBorder(BorderFactory.createMatteBorder(2,2,2,2,
                new Color(255,255,255,255)));
        btnUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnUpload)
                {
                    PersonWhoReport person=new PersonWhoReport();
                    //person.setIdReport();
                    person.setCardNumber(App.session.getPersonBelongsToSchool().getCardNumber());//获取一卡通
                    person.setName(App.session.getPersonBelongsToSchool().getName());
                    person.setSchool(App.session.getPersonBelongsToSchool().getSchool());
                    person.setCampus(cmbCampus.getSelectedItem().toString());//获取combobox当前值
                    person.setTemperature(36+(double)(slider.getValue())/10);
                     Date date= new Date(System.currentTimeMillis());
                    //SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    person.setDate(date);
                    person.setCity(txtExact.getText());
                    person.setIsQuarantined(cmbQuarantined.getSelectedItem().toString());
                    person.setIsDefinite(cmbDiagnosed.getSelectedItem().toString());
                    person.setIsSuspected(cmbRiskyVisit.getSelectedItem().toString());
                    person.setIsHistoryOfRiskyArea(cmbRiskyVisit.getSelectedItem().toString());

                    upload(person);
                    JOptionPane.showMessageDialog(null, "上传成功");
                    btnUpload.setText("已上传");
                    btnUpload.setEnabled(false);//按钮无法再次点击
                    btnUpload.repaint();
                }
            }
        });
        paneDaily.add(btnUpload);
    }
    //上传信息
    public void upload(PersonWhoReport personWhoReport)
    {
        Response resp = ResponseUtils.getResponseByHash(new Request(App.connectionToServer, null,
                "com.vcampus.server.dailyReport.DailyReportServer.insertPerson", new Object[] { personWhoReport }).send());
        if (resp.getReturn(Boolean.class)) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }

}
