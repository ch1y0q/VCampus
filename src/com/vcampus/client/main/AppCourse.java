package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class AppCourse {
    private JFrame jf = new JFrame("课程管理");
    private double credit = 0;
    private int width = 1151;
    private int height = 800;
    public AppCourse(){
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setResizable(true);
        jf.setBounds(0,0,width,height);
        Container container = jf.getContentPane();
        container.setBackground(new Color(0xD8F6F6));
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(width/50,height/50,width*4/5,height*4/5);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.add(tp);
        JPanel jp0 = new JPanel();
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        tp.addTab("课程表",jp0);
        tp.addTab("选课系统",jp1);
        tp.addTab("已选课程",jp2);
        tp.addTab("成绩查询",jp3);

        jp0.setLayout(null);
        jp1.setLayout(null);
        jp2.setLayout(null);
        jp3.setLayout(null);
        jp0.setBackground(Color.white);
        jp1.setBackground(Color.white);
        jp2.setBackground(Color.white);
        jp3.setBackground(Color.white);

        //课程表
        JScrollPane sp0 = new JScrollPane();
        sp0.setBounds(width/50, height/40, width * 3 / 5, height * 3 / 5);
        sp0.setBorder(BorderFactory.createLineBorder(new Color(0x0B3F44), 1));
        sp0.setBackground(Color.white);
        jp0.add(sp0);
        String[] columnNames0 = {"", "一", "二", "三", "四", "五", "六", "七"};
        String[][] emptyTable = {};
        String[] emptyData = {};
        DefaultTableModel model0 = new DefaultTableModel(emptyTable, columnNames0);
        for (int i = 0; i < 13; i++) {
            model0.addRow(emptyData);
        }
        for (int i = 0; i < 13; i++) {
            model0.setValueAt(Integer.toString(i + 1), i, 0);
        }
        JTable courseTable = new JTable(model0) {
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        courseTable.setRowHeight(30);
        sp0.setViewportView(courseTable);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        courseTable.setDefaultRenderer(Object.class, r);


        //选课
        JScrollPane sp1 = new JScrollPane();
        sp1.setBounds(width/50, height/40, width * 3 / 5, height * 3 / 5);
        sp1.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        sp1.setBackground(Color.white);
        jp1.add(sp1);
        String[] columnName1={"课程编号","课程名称","学分","教师","上课时间","上课地点",
                "所属专业","课容量","已选学生数量",""};
        DefaultTableModel model1 = new DefaultTableModel(emptyTable,columnName1);
        JTable selectCourseTable = new JTable(model1){
            public boolean isCellEditable(int row, int column){
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp1.setViewportView(selectCourseTable);
        for (int i = 0; i < 5; i++) {
            model1.addRow(emptyData);
        }
        for (int i = 0; i < 5; i++) {
            model1.setValueAt("选择", i, 9);
        }



        //已选课程
        JScrollPane sp2 = new JScrollPane();
        sp2.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        sp2.setBackground(Color.white);
        jp2.add(sp2);
        String[] columnName2={"课程编号","课程名称","学分","教师","上课时间","上课地点",
                "所属专业","课容量","已选学生数量",""};
        DefaultTableModel model2 = new DefaultTableModel(emptyTable,columnName2);
        JTable selectedCourseTable = new JTable(model2){
            public boolean isCellEditable(int row, int column){
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp2.getViewport().add(selectedCourseTable);
        for (int i = 0; i < 5; i++) {
            model2.addRow(emptyData);
        }
        for (int i = 0; i < 5; i++) {
            model2.setValueAt("退选", i, 9);
        }
        JLabel selectedCreditLabel = new JLabel("已选学分");
        selectedCreditLabel.setBorder(BorderFactory.createLineBorder(Color.black,1));
        selectedCreditLabel.setBounds(width/50,height/40,80,30);
        jp2.add(selectedCreditLabel);
        JTextArea numOfCreditText = new JTextArea();
        numOfCreditText.setBounds(width/50+95,height/40,50,30);
        numOfCreditText.setEditable(false);
        jp2.add(numOfCreditText);
        sp2.setBounds(width / 50, 30+height / 20, width * 3 / 5, height * 3 / 5);
        for(int i = 0;i<selectedCourseTable.getRowCount();i++){
            Object n = model2.getValueAt(i,2);
            if(n!=null){
                Double d = Double.parseDouble((String)n);
                credit+=d;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        String sCredit = df.format(credit);
        numOfCreditText.setText(sCredit);



        //成绩查询
        JScrollPane sp3 = new JScrollPane();
        sp3.setBounds(width/50, 30+height/20, width * 3 / 5, height * 3 / 5);
        sp3.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        sp3.setBackground(Color.white);
        jp3.add(sp3);
        String[] columnName3={"课程编号","课程名称","学分","学期","成绩","课程性质",
                "是否首修"};
        DefaultTableModel model3 = new DefaultTableModel(emptyTable,columnName3);
        JTable checkScoreTable = new JTable(model3){
            public boolean isCellEditable(int row, int column){
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp3.getViewport().add(checkScoreTable);
        for (int i = 0; i < 5; i++) {
            model3.addRow(emptyData);
        }
        JLabel semesterLabel = new JLabel("学期",JLabel.CENTER);
        semesterLabel.setBounds(width/50,height/40,40,30);
        jp3.add(semesterLabel);

        JComboBox chooseSemester = new JComboBox();
        String[] semesters = {"2020-2021-1","2020-2021-2","2020-2021-3","2020-2021-4"};
        for (String s : semesters) {
            chooseSemester.addItem(s);
        }
        chooseSemester.setBounds(width/50+60,height/40,120,30);
        jp3.add(chooseSemester);
        JLabel creditInSemesterLabel = new JLabel("学分",JLabel.CENTER);
        creditInSemesterLabel.setBounds(width/25+240,height/40,40,30);
        jp3.add(creditInSemesterLabel);
        JTextArea numOfCreditInSemesterText = new JTextArea();
        numOfCreditInSemesterText.setBounds(width/25+295,height/40,40,30);
        jp3.add(numOfCreditInSemesterText);
        JLabel scoreLabel = new JLabel("绩点",JLabel.CENTER);
        scoreLabel.setBounds(width*2/25+395,height/40,40,30);
        jp3.add(scoreLabel);
        JTextArea numOfScoreText = new JTextArea();
        numOfScoreText.setBounds(width*2/25+450,height/40,40,30);
        jp3.add(numOfScoreText);


        //事件

        //监听窗口大小变化
        jf.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int currentWidth = jf.getWidth();
                int currentHeight = jf.getHeight();
                tp.setBounds(currentWidth/50,currentHeight/50,currentWidth*4/5,currentHeight*4/5);
                //jp0
                {
                    jp0.setSize(currentWidth, currentHeight);
                    sp0.setBounds(currentWidth / 50, currentHeight / 50, currentWidth * 3 / 5, currentHeight * 3 / 5);
                }
                //jp1
                {
                    jp1.setSize(currentWidth, currentHeight);
                    sp1.setBounds(currentWidth / 50, currentHeight / 50, currentWidth * 3 / 5, currentHeight * 3 / 5);
                }
                //jp2
                {
                    jp2.setSize(currentWidth, currentHeight);
                    selectedCreditLabel.setBounds(currentWidth/50,currentHeight/40,80,30);
                    numOfCreditText.setBounds(currentWidth/50+95,currentHeight/40,50,30);
                    int h = selectedCreditLabel.getHeight();
                    sp2.setBounds(currentWidth / 50, h+currentHeight / 20, currentWidth * 3 / 5, currentHeight * 3 / 5);
                }
                //jp3
                {
                    jp3.setSize(currentWidth, currentHeight);
                    semesterLabel.setBounds(currentWidth/50,currentHeight/40,40,30);
                    chooseSemester.setBounds(currentWidth/50+60,currentHeight/40,120,30);
                    creditInSemesterLabel.setBounds(currentWidth/25+240,currentHeight/40,40,30);
                    numOfCreditInSemesterText.setBounds(currentWidth/25+295,currentHeight/40,40,30);
                    scoreLabel.setBounds(currentWidth*2/25+395,currentHeight/40,40,30);
                    numOfScoreText.setBounds(currentWidth*2/25+450,currentHeight/40,40,30);
                    int h = chooseSemester.getHeight();
                    sp3.setBounds(currentWidth / 50, h+currentHeight / 20, currentWidth * 3 / 5, currentHeight * 3 / 5);

                }
            }
        });


        //选课
        selectCourseTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int column = selectCourseTable.getSelectedColumn();
                int row = selectCourseTable.getSelectedRow();
                if(column == 9&&model1.getValueAt(row,column)=="选择"){
                    model1.setValueAt("<html><font color='rgb(110,110,110)'>已选</font></html>",row,column);
                    model2.addRow(emptyData);
                    for(int i = 0;i<selectedCourseTable.getRowCount();i++){
                        Object n = model2.getValueAt(i,2);
                        if(n!=null){
                            double d = Double.parseDouble((String)n);
                            credit+=d;
                        }
                    }
                    String sCredit = df.format(credit);
                    numOfCreditText.setText(sCredit);
                }
            }
        });


        //退课
        selectedCourseTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int column = selectedCourseTable.getSelectedColumn();
                int row = selectedCourseTable.getSelectedRow();
                if(column == 9){
                    model2.removeRow(row);
                    for(int i = 0;i<selectedCourseTable.getRowCount();i++){
                        Object n = model2.getValueAt(i,2);
                        if(n!=null){
                            double d = Double.parseDouble((String)n);
                            credit+=d;
                        }
                    }
                    String sCredit = df.format(credit);
                    numOfCreditText.setText(sCredit);
                }
            }
        });
    }
    public static void main(String args[]){
        AppCourse course = new AppCourse();
    }
}
