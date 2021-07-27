package com.vcampus.client.main.dailyReport;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * 这是管理员接受每日上报的panel，用于目录的整合
 * @author Dong Ruojing
 * @date 2021/7/27
 */
public class DailyReportManagePanel extends JPanel {
    private int width = 1151;
    private int height = 800;
    DailyReportManagePanel(){

        String[][] emptyTable = {};
        String[] emptyData = {};
        String[] school = {"建筑学院", "机械工程学院", "能源与环境学院", "信息科学与工程学院", "土木工程学院", "电子科学与工程学院",
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
        sp.setBounds(width/50, 30+height/20, 1100, height * 3 / 5);
        sp.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        sp.setBackground(Color.white);
        add(sp);
        String[] columnName={"一卡通号","姓名","学院","当日晨检温度","目前所在位置","目前所在校区",
                "是否在隔离期","是否为疑似病例","是否为确诊病例","有无风险区旅居史"};
        DefaultTableModel model = new DefaultTableModel(emptyTable,columnName);
        JTable Table = new JTable(model){
            public boolean isCellEditable(int row, int column){
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp.getViewport().add(Table);
        for (int i = 0; i < 5; i++) {
            model.addRow(emptyData);
        }
        JLabel schoolLabel = new JLabel("学院",JLabel.CENTER);
        schoolLabel.setBounds(width/50,height/40,40,30);
        add(schoolLabel);

        JComboBox chooseSchool = new JComboBox();
        for (String s : school) {
            chooseSchool.addItem(s);
        }
        chooseSchool.setBounds(width/50+60,height/40,120,30);
        add(chooseSchool);

        JLabel numNotReport = new JLabel("未上报人数",JLabel.CENTER);
        numNotReport.setBounds(width/25+240,height/40,100,30);
        add(numNotReport);

        JLabel lblNumNotReport = new JLabel();
        lblNumNotReport.setBounds(width/25+350,height/40,80,30);
        lblNumNotReport.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lblNumNotReport.setOpaque(true);
        lblNumNotReport.setForeground(new Color(33, 117, 206));
        lblNumNotReport.setBackground(new Color(33,177,206,80));
        lblNumNotReport.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNumNotReport);

        JLabel numAbnormal = new JLabel("体温>37.3℃的人数",JLabel.CENTER);
        numAbnormal.setBounds(width*2/25+450,height/40,150,30);
        add(numAbnormal);

        JLabel lblNumAbnormal = new JLabel();
        lblNumAbnormal.setBounds(width*2/25+610,height/40,80,30);
        lblNumAbnormal.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lblNumAbnormal.setOpaque(true);
        lblNumAbnormal.setForeground(new Color(33, 117, 206));
        lblNumAbnormal.setBackground(new Color(33,177,206,80));
        lblNumAbnormal.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumAbnormal.setText("24");
        add(lblNumAbnormal);
    }


}
