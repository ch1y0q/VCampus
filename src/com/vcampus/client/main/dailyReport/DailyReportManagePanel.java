package com.vcampus.client.main.dailyReport;

import com.alee.managers.style.StyleId;
import com.vcampus.client.main.App;
import com.vcampus.dao.IStudentMapper;
import com.vcampus.entity.PersonWhoReport;
import com.vcampus.entity.Student;
import com.vcampus.net.Request;
import com.vcampus.net.Response;
import com.vcampus.util.ResponseUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 这是管理员接受每日上报的panel，用于目录的整合
 * @author Dong Ruojing
 * @date 2021/7/27
 */
public class DailyReportManagePanel extends JPanel {
    private int width = 1151;
    private int height = 800;
    private List<PersonWhoReport> list = null;
    private DefaultTableModel model;
    DailyReportManagePanel() {

        String[][] emptyTable = {};
        String[] emptyData = {};
        String[] school = {"","建筑学院", "机械工程学院", "能源与环境学院", "信息科学与工程学院", "土木工程学院", "电子科学与工程学院",
                "数学学院", "自动化学院", "计算机科学与工程学院", "物理学院", "生物科学与医学工程学院", "材料科学与工程学院", "人文学院",
                "经济管理学院", "马克思主义学院", "电气工程学院", "外国语学院", "化学化工学院", "交通学院", "仪器科学与工程学院", "艺术学院",
                "法学院", "医学院1", "公共卫生学院", "医学院2", "网络空间安全学院", "人工智能学院", "吴健雄学院", "软件学院"};
        //设置JPanel
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;

        setBackground(new Color(240, 255, 240));
        setLocation(-871, -176);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JScrollPane sp = new JScrollPane();
        sp.setBounds(width / 50, 30 + height / 20, 1100, height * 3 / 5);
        sp.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        sp.setBackground(Color.white);
        add(sp);
        String[] columnName = { "一卡通号", "姓名", "学院","日期", "当日晨检温度", "目前所在位置","所在城市", "目前所在校区",
                "是否在隔离期", "是否为疑似病例", "是否为确诊病例", "有无风险区旅居史"};
        model = new DefaultTableModel(emptyTable, columnName);
        JTable Table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp.getViewport().add(Table);
        for (int i = 0; i < 5; i++) {
            model.addRow(emptyData);
        }
        JLabel schoolLabel = new JLabel("学院", JLabel.CENTER);
        schoolLabel.setBounds(width / 50, height / 40, 40, 30);
        add(schoolLabel);

        JComboBox chooseSchool = new JComboBox();
        for (String s : school) {
            chooseSchool.addItem(s);
        }
        chooseSchool.setBounds(width / 50 + 60, height / 40, 120, 30);
        add(chooseSchool);

        JLabel numNotReport = new JLabel("上报人数", JLabel.CENTER);
        numNotReport.setBounds(width / 25 + 240, height / 40, 100, 30);
        add(numNotReport);

        JLabel lblNumReport = new JLabel();
        lblNumReport.setBounds(width / 25 + 350, height / 40, 80, 30);
        lblNumReport.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lblNumReport.setOpaque(true);
        lblNumReport.setText("0");
        lblNumReport.setForeground(new Color(33, 117, 206));
        lblNumReport.setBackground(new Color(33, 177, 206, 80));
        lblNumReport.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNumReport);

        JLabel numAbnormal = new JLabel("体温>37.3℃的人数", JLabel.CENTER);
        numAbnormal.setBounds(width * 2 / 25 + 450, height / 40, 150, 30);
        add(numAbnormal);

        JLabel lblNumAbnormal = new JLabel();
        lblNumAbnormal.setBounds(width * 2 / 25 + 610, height / 40, 80, 30);
        lblNumAbnormal.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lblNumAbnormal.setOpaque(true);
        lblNumAbnormal.setForeground(new Color(33, 117, 206));
        lblNumAbnormal.setBackground(new Color(33, 177, 206, 80));
        lblNumAbnormal.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumAbnormal.setText("0");
        add(lblNumAbnormal);


        //刷新接受信息
        final JButton btnRenew = new JButton("刷新");
        btnRenew.putClientProperty(StyleId.STYLE_PROPERTY, StyleId.buttonHover);
        btnRenew.setBounds(width * 2 / 25 + 800, height / 40, 80, 30);
        btnRenew.setOpaque(true);
        btnRenew.setFont(new Font("微软雅黑", Font.BOLD, 18));
        btnRenew.setForeground(new Color(0xD5B8B8));
        btnRenew.setBackground(new Color(0xDA61A4B8, true));
        btnRenew.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
                new Color(255, 255, 255, 255)));
        btnRenew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int countAbnormal=0;//统计体温>37.3的人数
                while(model.getRowCount()>0){
                    model.removeRow(model.getRowCount()-1);//清空表格
                } Table.setModel(model);
                if (e.getSource() == btnRenew) {
                    String[][] listData;
                    //是否选择学院
                    if(chooseSchool.getSelectedItem().toString()!="") {//筛选
                        System.out.println(chooseSchool.getSelectedItem().toString());

                        renewBySchool(chooseSchool.getSelectedItem().toString());
                        listData = new String[list.size()][12];

                    }
                    else {//显示全部
                        renew();listData = new String[list.size()][12];
                        System.out.println("筛选all");
                    }

                    if (list == null || list.size() == 0) {
                        System.out.println("error");
                        model.setRowCount(0);
                        Table.setModel(model);
                    } else {
                        model.setRowCount(0);
                        int len = list.size();

                        for (int i = 0; i < len; i++) {
                            listData[i][0]=list.get(i).getCardNumber();
                            listData[i][1]=list.get(i).getName();
                            listData[i][2]=list.get(i).getSchool();
                            listData[i][3]=list.get(i).getDate().toString();
                            String temp=String.valueOf(list.get(i).getTemperature());
                            if(list.get(i).getTemperature()>37.3){
                                countAbnormal++;
                            }
                            listData[i][4]=temp;
                            listData[i][5]=list.get(i).getLocation();
                            listData[i][6]=list.get(i).getCity();
                            listData[i][7]=list.get(i).getCampus();
                            listData[i][8]=list.get(i).getIfQarantined();
                            listData[i][9]=list.get(i).getIfSuspected();
                            listData[i][10]=list.get(i).getIfDefinite();
                            listData[i][11]=list.get(i).getIfHistoryOfRiskyArea();

                        }
                        model = new DefaultTableModel(listData, columnName){
                            public boolean isCellEditable(int a, int b) {
                                return false;
                            }
                        };
                        Table.setModel(model);
                    }
                    lblNumReport.setText(String.valueOf(model.getRowCount()));
                    lblNumReport.repaint();
                    lblNumAbnormal.setText(String.valueOf(countAbnormal));
                    lblNumAbnormal.repaint();

                    JOptionPane.showMessageDialog(null, "刷新成功");

                }
            }
        });
        add(btnRenew);
    }

    public void renewBySchool(String chooseSchool) {
        list = ResponseUtils.getResponseByHash(new Request(App.connectionToServer, null,
                "com.vcampus.server.dailyReport.DailyReportServer.tableDisplayBySchool",
                new Object[]{chooseSchool}).send()).getListReturn(PersonWhoReport.class);

    }
    public void renew(){
        list = ResponseUtils.getResponseByHash(new Request(App.connectionToServer, null,
                "com.vcampus.server.dailyReport.DailyReportServer.tableDisplay",
                new Object[] {}).send()).getListReturn(PersonWhoReport.class);
        if (list == null || list.size() == 0) {
            System.out.println("error");
        }
    }





}








