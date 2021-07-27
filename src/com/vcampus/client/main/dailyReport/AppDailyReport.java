package com.vcampus.client.main.dailyReport;

import com.vcampus.client.main.App;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class AppDailyReport extends JFrame {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
    public AppDailyReport() {
        setResizable(true);
        setTitle(res.getString("student_main"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton back = new JButton("返回");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==back)
                {
                    AppStudent app=new AppStudent();
                    app.setVisible(true);
                    setVisible(false);
                }
            }
        });
        back.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        back.setBounds(0, 20, 100, 30);
        contentPane.add(back);

        JPanel jplDetail=new JPanel();
        contentPane.add(jplDetail);
        jplDetail.setLayout(null);
        jplDetail.setBounds(d.width/2-150,20,300,120);
        JLabel jlBasicInfo = new JLabel("基本信息");
        jlBasicInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        jlBasicInfo.setBounds(0,0,100,30);
        jplDetail.add(jlBasicInfo);
        JLabel jlCardnumber = new JLabel();
        jlCardnumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        jlCardnumber.setText("一卡通号"+" "+ App.session.getStudent().getCardNumber());
        jlCardnumber.setBounds(0, 30, 180, 30);
        jlCardnumber.setBorder(new EmptyBorder(0,0,0,0));
        jplDetail.add(jlCardnumber);

        JLabel jlName = new JLabel();
        jlName.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        jlName.setText("姓名  "+" "+App.session.getStudent().getName());
        jlName.setBounds(0, 60, 180, 30);
        jlName.setBorder(new EmptyBorder(0,0,0,0));
        jplDetail.add(jlName);

        JLabel jlAcademy = new JLabel();
        jlAcademy.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        jlAcademy.setText("学院  "+" ");
        jlAcademy.setBounds(0, 90, 180, 30);
        jlAcademy.setBorder(new EmptyBorder(0,0,0,0));
        jplDetail.add(jlAcademy);

        JPanel jplDaily=new JPanel();
        jplDaily.setLayout(null);
        contentPane.add(jplDaily);
        jplDaily.setBounds(d.width/2-150,150,320,300);
        JLabel jlDailyInfo = new JLabel("每日情况");
        jlDailyInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        jlDailyInfo.setBounds(0,0,100,30);
        jplDaily.add(jlDailyInfo);

        JLabel jlTemper =new JLabel("当日晨检温度");
        jlTemper.setBounds(0,30,150,30);
        jplDaily.add(jlTemper);
        JTextField jtxtTemper=new JTextField();
        jtxtTemper.setBounds(160,30,150,30);
        jtxtTemper.setEditable(false);
        jplDaily.add(jtxtTemper);
        JLabel jllocal=new JLabel("目前所在位置");
        jllocal.setBounds(0,60,150,30);
        jplDaily.add(jllocal);
        String[]localtxt={"","在校内","在校外"};
        JComboBox jcomlocal=new JComboBox(localtxt);
        jcomlocal.setBounds(160,60,150,30);
        jplDaily.add(jcomlocal);

        JLabel lblHealth= new JLabel();//设置健康标签
        lblHealth.setText("今日体温：37℃");
        lblHealth.setBounds(780,470,300,60);
        lblHealth.setFont(new Font("微软雅黑", Font.BOLD, 25));
        lblHealth.setOpaque(true);
        lblHealth.setBackground(new Color(0xC9B6F3F1, true));
        lblHealth.setForeground(new Color(0xF22D8B4C, true));
        lblHealth.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblHealth);

        JLabel lblAdvice= new JLabel();//设置建议标签
        lblAdvice.setText("体温正常~~开启快乐学习生活");
        lblAdvice.setBounds(780,670,500,60);
        lblAdvice.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblAdvice.setOpaque(true);
        lblAdvice.setBackground(new Color(0xC9248E8B));
        lblAdvice.setForeground(new Color(0xF2FFFFFF));
        lblAdvice.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblAdvice);

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
                  lblAdvice.setText("体温正常~~开启快乐学习生活");
                } else if(temperature<37.9){
                    jtxtTemper.setForeground(new Color(0xD4733F));
                    lblHealth.setForeground(new Color(0xD4733F));
                    lblAdvice.setText("体温较高，需要注意身体");
                } else{
                    jtxtTemper.setForeground(new Color(0xEA0909));
                    lblHealth.setForeground(new Color(0xEA0909));
                    lblAdvice.setText("发烧啦！请快去医院");
                }
                jtxtTemper.repaint();
                lblHealth.repaint();
                lblAdvice.repaint();
                }

        });
        slider.setBounds(160,580,800,60);
        contentPane.add(slider);



        JLabel jlSchool=new JLabel("目前所在校区");
        jlSchool.setBounds(0,90,150,30);
        String[] schooltxt={"","九龙湖校区","四牌楼校区","丁家桥校区"};
        JComboBox jcomSchool=new JComboBox(schooltxt);
        jcomSchool.setBounds(160,90,150,30);

        JLabel jlExactlocation=new JLabel("具体所在城市");
        jlExactlocation.setBounds(0,90,150,30);
        JTextField jtxtExact=new JTextField();
        jtxtExact.setBounds(160,90,150,30);

        jcomlocal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==jcomlocal) {
                    if (jcomlocal.getSelectedItem().toString() == "在校外") {
                        jplDaily.add(jlExactlocation);
                        jplDaily.add(jtxtExact);
                        jplDaily.repaint();
                    }
                    else if(jcomlocal.getSelectedItem().toString() == "在校内"){
                        jplDaily.add(jlSchool);
                        jplDaily.add(jcomSchool);
                        jplDaily.repaint();
                    }
                }
            }
        });

        JLabel jlifgeli=new JLabel("今天是否还在隔离期内");
        jlifgeli.setBounds(0,120,150,30);
        jplDaily.add(jlifgeli);
        String[] strYN={"是","否"};
        JComboBox jcomifgeli=new JComboBox(strYN);
        jcomifgeli.setBounds(160,120,150,30);
        jplDaily.add(jcomifgeli);

        JLabel jlifyisi=new JLabel("目前是否为疑似病例");
        jlifyisi.setBounds(0,150,150,30);
        jplDaily.add(jlifyisi);
        JComboBox jcomifyisi=new JComboBox(strYN);
        jcomifyisi.setBounds(160,150,150,30);
        jplDaily.add(jcomifyisi);

        JLabel jlifquezhen=new JLabel("目前是否为确诊病例");
        jlifquezhen.setBounds(0,180,150,30);
        jplDaily.add(jlifquezhen);
        JComboBox jcomifquezhen=new JComboBox(strYN);
        jcomifyisi.setBounds(160,180,150,30);
        jplDaily.add(jcomifquezhen);

        JLabel jliflvju=new JLabel("存在风险区旅居史");
        jliflvju.setBounds(0,210,150,30);
        jplDaily.add(jliflvju);
        JComboBox jcomiflvju=new JComboBox(strYN);
        jcomiflvju.setBounds(160,210,150,30);
        jplDaily.add(jcomiflvju);

    }
}
