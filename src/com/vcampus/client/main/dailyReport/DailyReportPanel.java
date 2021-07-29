package com.vcampus.client.main.dailyReport;

import com.alee.managers.style.StyleId;
import com.vcampus.UI.myJLabel;
import com.vcampus.UI.myJLabel2;
import com.vcampus.client.main.App;
import com.vcampus.client.main.AppLife;
import com.vcampus.entity.PersonWhoReport;
import com.vcampus.entity.Student;
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
import java.text.SimpleDateFormat;
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
                    AppStudent app=new AppStudent();
                    app.setVisible(true);
                    setVisible(false);//合并的时候这一块不需要，这只能做到jpanel消失
                }
            }
        });
        back.setBounds(0, 20, 100, 30);
        back.setFont(new Font("微软雅黑", Font.BOLD, 14));
        back.setForeground(new Color(33, 117, 206,100));
        add(back);


        JPanel jplDetail=new JPanel();
        add(jplDetail);
        jplDetail.setLayout(null);
        jplDetail.setBounds(0,70,300,220);
        jplDetail.setBackground(new Color(0xC0C0F6));
        myJLabel2 jlBasicInfo = new myJLabel2();
        jlBasicInfo.setText("基本信息");
        jlBasicInfo.setFont(new Font("微软雅黑", Font.BOLD, 18));
        jlBasicInfo.setBounds(0,0,100,50);
        jlBasicInfo.setForeground(Color.WHITE);
        jplDetail.add(jlBasicInfo);
        JLabel jlCardnumber = new JLabel();
        jlCardnumber.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jlCardnumber.setText("一卡通号:  "+" "+ App.session.getStudent().getCardNumber());
        jlCardnumber.setBounds(10, 50, 180, 30);
        jlCardnumber.setBorder(new EmptyBorder(0,0,0,0));
        jplDetail.add(jlCardnumber);

        JLabel jlName = new JLabel();
        jlName.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jlName.setText("姓名:        "+" "+App.session.getStudent().getName());
        jlName.setBounds(10, 100, 180, 30);
        jlName.setBorder(new EmptyBorder(0,0,0,0));
        jplDetail.add(jlName);

        JLabel jlAcademy = new JLabel();
        jlAcademy.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jlAcademy.setText("学院:        "+" "+App.session.getStudent().getSchool());
        jlAcademy.setBounds(10, 150, 250, 30);
        jlAcademy.setBorder(new EmptyBorder(0,0,0,0));
        jplDetail.add(jlAcademy);

        JPanel jplDaily=new JPanel();
        jplDaily.setLayout(null);
        add(jplDaily);
        jplDaily.setBounds(330,70,350,470);
        jplDaily.setBackground(new Color(0xE0CDFA));
        myJLabel2 jlDailyInfo = new myJLabel2();
        jlDailyInfo.setText("每日情况");
        jlDailyInfo.setForeground(Color.WHITE);
        jlDailyInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        jlDailyInfo.setBounds(0,0,100,50);
        jplDaily.add(jlDailyInfo);

        JLabel jlTemper =new JLabel("当日晨检温度");
        jlTemper.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jlTemper.setBounds(10, 50,150,30);
        jplDaily.add(jlTemper);

        JTextField jtxtTemper=new JTextField();
        jtxtTemper.setBounds(170,50,60,30);
        jtxtTemper.setFont(new Font("微软雅黑", Font.BOLD, 16));
        jtxtTemper.setEditable(false);
        jplDaily.add(jtxtTemper);

        JLabel jllocal=new JLabel("目前所在位置");
        jllocal.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jllocal.setBounds(10,90,150,30);
        jplDaily.add(jllocal);
        String[]localtxt={"在校内","在校外"};
        JComboBox jcomlocal=new JComboBox(localtxt);
        jcomlocal.setBounds(170,90,150,30);
        jplDaily.add(jcomlocal);

        myJLabel2 lblHealth= new myJLabel2();//设置健康标签
        lblHealth.setText("今日体温：37℃");
        lblHealth.setBounds(800,90,280,60);
        lblHealth.setFont(new Font("微软雅黑", Font.BOLD, 23));
        lblHealth.setOpaque(true);
        lblHealth.setBackground(new Color(0xC9B6F3F1, true));
        lblHealth.setForeground(new Color(0xF22D8B4C, true));
        lblHealth.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblHealth);

        myJLabel2 lblAdvice= new myJLabel2();//设置建议标签
        lblAdvice.setText("体温正常");
        lblAdvice.setBounds(800,170,280,60);
        lblAdvice.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblAdvice.setOpaque(true);
        lblAdvice.setBackground(new Color(0x53ADA2));
        lblAdvice.setForeground(new Color(0xF2FFFFFF));
        lblAdvice.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblAdvice);

        myJLabel2 lblAdvice2= new myJLabel2();//设置建议标签
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
                System.out.println("当前值: " + slider.getValue());
                jtxtTemper.setText(String.valueOf(temperature));
                lblHealth.setText("今日体温："+String.valueOf(temperature)+"℃");
                if(temperature<37.3)
                {
                    jtxtTemper.setForeground(new Color(0xF22D8B4C, true));
                    lblHealth.setForeground(new Color(0xF22D8B4C, true));
                    lblAdvice.setText("体温正常");
                    lblAdvice2.setText("开启快乐学习生活(≧∇≦)ﾉ");
                    lblHealth.setBackground(new Color(0xC9B6F3F1, true));
                    lblAdvice.setBackground(new Color(0x53ADA2));
                    lblAdvice2.setBackground(new Color(0x357171));
                } else if(temperature<37.9){
                    jtxtTemper.setForeground(new Color(0xD4733F));
                    lblHealth.setForeground(new Color(0xD4733F));
                    lblAdvice.setText("体温较高");
                    lblAdvice2.setText("需要注意身体QAQ");
                    lblHealth.setBackground(new Color(0xFDECE581, true));
                    lblAdvice.setBackground(new Color(0xE3A75F));
                    lblAdvice2.setBackground(new Color(0xE78C5B));
                } else{
                    jtxtTemper.setForeground(new Color(0xEA0909));
                    lblHealth.setForeground(new Color(0xEA0909));
                    lblAdvice.setText("发烧啦！");
                    lblAdvice2.setText("请快去医院o(╥﹏╥)o");
                    lblHealth.setBackground(new Color(0xC9E78D8A, true));
                    lblAdvice.setBackground(new Color(0xDC6757));
                    lblAdvice2.setBackground(new Color(0xEA3423));
                }
                jtxtTemper.repaint();
                lblHealth.repaint();
                lblAdvice.repaint();
                lblAdvice2.repaint();
            }

        });
        slider.setBounds(720,70,60,600);
        add(slider);



        JLabel jlSchool=new JLabel("目前所在校区");
        jlSchool.setBounds(10,130,150,30);
        jlSchool.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        String[] schooltxt={"九龙湖校区","四牌楼校区","丁家桥校区"};
        JComboBox jcomSchool=new JComboBox(schooltxt);
        jcomSchool.setBounds(170,130,150,30);

        JLabel jlExactlocation=new JLabel("具体所在城市");
        jlExactlocation.setBounds(10,170,150,30);
        jlExactlocation.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        JTextField jtxtExact=new JTextField();
        jtxtExact.setBounds(170,170,150,30);

        jcomlocal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==jcomlocal) {
                    if (jcomlocal.getSelectedItem().toString() == "在校外") {
                        jplDaily.add(jlExactlocation);
                        jplDaily.add(jtxtExact);
                        jplDaily.remove(jcomSchool);
                        jplDaily.remove(jlSchool);
                        jplDaily.repaint();
                    }
                    else if(jcomlocal.getSelectedItem().toString() == "在校内"){
                        jplDaily.add(jcomSchool);
                        jplDaily.add(jlSchool);
                        jplDaily.remove(jlExactlocation);
                        jplDaily.remove(jtxtExact);
                        jplDaily.repaint();
                    }
                }
            }
        });

        JLabel jlifgeli=new JLabel("今天是否还在隔离期");
        jlifgeli.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jlifgeli.setBounds(10,210,150,30);
        jplDaily.add(jlifgeli);
        String[] strYN={"是","否"};
        JComboBox jcomifgeli=new JComboBox(strYN);
        jcomifgeli.setBounds(170,210,150,30);
        jplDaily.add(jcomifgeli);

        JLabel jlifyisi=new JLabel("目前是否为疑似病例");
        jlifyisi.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jlifyisi.setBounds(10,250,150,30);
        jplDaily.add(jlifyisi);
        JComboBox jcomifyisi=new JComboBox(strYN);
        jcomifyisi.setBounds(170,250,150,30);
        jplDaily.add(jcomifyisi);

        JLabel jlifquezhen=new JLabel("目前是否为确诊病例");
        jlifquezhen.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jlifquezhen.setBounds(10,290,150,30);
        jplDaily.add(jlifquezhen);
        JComboBox jcomifquezhen=new JComboBox(strYN);
        jcomifquezhen.setBounds(170,290,150,30);
        jplDaily.add(jcomifquezhen);

        JLabel jliflvju=new JLabel("存在风险区旅居史");
        jliflvju.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jliflvju.setBounds(10,330,150,30);
        jplDaily.add(jliflvju);
        JComboBox jcomiflvju=new JComboBox(strYN);
        jcomiflvju.setBounds(170,330,150,30);
        jplDaily.add(jcomiflvju);


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
                    person.setCardNumber(App.session.getStudent().getCardNumber());//获取一卡通
                    person.setName(App.session.getStudent().getName());
                    person.setSchool(App.session.getStudent().getSchool());
                    person.setCampus(jcomSchool.getSelectedItem().toString());//获取combobox当前值
                    person.setTemperature(36+(double)(slider.getValue())/10);
                     Date date= new Date(System.currentTimeMillis());
                    //SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    person.setDate(date);
                    person.setCity(jtxtExact.getText());
                    person.setIfQarantined(jcomifgeli.getSelectedItem().toString());
                    person.setIfDefinite(jcomifquezhen.getSelectedItem().toString());
                    person.setIfSuspected(jcomiflvju.getSelectedItem().toString());
                    person.setIfHistoryOfRiskyArea(jcomiflvju.getSelectedItem().toString());

                    upload(person);
                    JOptionPane.showMessageDialog(null, "上传成功");
                    btnUpload.setText("已上传");
                    btnUpload.setEnabled(false);//按钮无法再次点击
                    btnUpload.repaint();
                }
            }
        });
        jplDaily.add(btnUpload);


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
