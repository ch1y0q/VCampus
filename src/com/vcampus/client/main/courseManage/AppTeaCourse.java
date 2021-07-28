package com.vcampus.client.main.courseManage;

import com.vcampus.client.main.teacher.TeaCategory;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class AppTeaCourse {
    private JFrame jf = new JFrame("课程管理");
    private int width = 1151;
    private int height = 800;
    public AppTeaCourse() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setResizable(true);
        jf.setBounds(0, 0, width, height);
        Container container = jf.getContentPane();
        container.setBackground(new Color(0xD8F6F6));
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(width *2/ 11, height / 50, width * 4 / 5, height * 4 / 5);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.add(tp);
        JPanel jp0 = new JPanel();
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        tp.addTab("课程表", jp0);
        tp.addTab("成绩录入", jp1);
        tp.addTab("课程查询", jp2);

        jp0.setLayout(null);
        jp1.setLayout(null);
        jp2.setLayout(null);
        jp0.setBackground(Color.white);
        jp1.setBackground(Color.white);
        jp2.setBackground(Color.white);



        //侧边栏
        JTree jt=new TeaCategory().init();
        jf.add(jt);
        jt.setBounds(0,height/50,width*2/11,height);


        //课程表
        JScrollPane sp0 = new JScrollPane();
        sp0.setBounds(width / 50, 30 + height / 20, width * 3 / 5, height * 3 / 5);
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
        JLabel semesterLabel0 = new JLabel("学期", JLabel.CENTER);
        semesterLabel0.setBounds(width / 50, height / 40, 40, 30);
        jp0.add(semesterLabel0);
        JComboBox chooseSemester0 = new JComboBox();
        String[] semesters = {"2020-2021-1", "2020-2021-2", "2020-2021-3", "2020-2021-4"};
        for (String s : semesters) {
            chooseSemester0.addItem(s);
        }
        chooseSemester0.setBounds(width / 50 + 60, height / 40, 120, 30);
        jp0.add(chooseSemester0);
        courseTable.setRowHeight(30);
        sp0.setViewportView(courseTable);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        courseTable.setDefaultRenderer(Object.class, r);


        //成绩录入
        JScrollPane sp1_0 = new JScrollPane();
        sp1_0.setBounds(width / 50, 60 + height / 20, width * 3 / 5, height / 10);
        sp1_0.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        sp1_0.setBackground(Color.white);
        jp1.add(sp1_0);
        String[] columnName1_0 = {"课程编号", "课程名称", "学分", "上课时间", "上课地点", "所属专业",
                "状态", "课容量", "已选学生数量"};
        DefaultTableModel model1_0 = new DefaultTableModel(emptyTable, columnName1_0);
        JTable courseInformationTable = new JTable(model1_0) {
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp1_0.getViewport().add(courseInformationTable);
        for (int i = 0; i < 3; i++) {
            model1_0.addRow(emptyData);
        }
        JScrollPane sp1_1 = new JScrollPane();
        sp1_1.setBounds(width / 50, 90 + height * 7 / 40, width * 3 / 5, height * 2 / 5);
        sp1_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        sp1_1.setBackground(Color.white);
        jp1.add(sp1_1);
        String[] columnName1_1 = {"学号", "姓名", "状态", "成绩录入"};
        DefaultTableModel model1_1 = new DefaultTableModel(emptyTable, columnName1_1);
        JTable enterScoreTable = new JTable(model1_1) {
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp1_1.getViewport().add(enterScoreTable);
        for (int i = 0; i < 10; i++) {
            model1_1.addRow(emptyData);
        }
        JLabel semesterLabel_tab1 = new JLabel("学期", JLabel.CENTER);
        semesterLabel_tab1.setBounds(width / 50, height / 40, 40, 30);
        jp1.add(semesterLabel_tab1);
        JComboBox chooseSemester_tab1 = new JComboBox();
        for (String s : semesters) {
            chooseSemester_tab1.addItem(s);
        }
        chooseSemester_tab1.setBounds(width / 50 + 60, height / 40, 120, 30);
        jp1.add(chooseSemester_tab1);
        JLabel selectCourseLabel = new JLabel("选择课程");
        selectCourseLabel.setBounds(width / 25 + 240, height / 40, 60, 30);
        jp1.add(selectCourseLabel);
        JComboBox selectCourse = new JComboBox();
        selectCourse.setBounds(width / 25 + 315, height / 40, 120, 30);
        jp1.add(selectCourse);
        JLabel courseInformationLabel = new JLabel("课程信息：", JLabel.CENTER);
        courseInformationLabel.setBounds(width / 50, height / 20 + 30, 65, 30);
        jp1.add(courseInformationLabel);
        JLabel enterScoreLabel = new JLabel("学生成绩录入：");
        enterScoreLabel.setBounds(width / 50, 60 + height * 7 / 40, 90, 30);
        jp1.add(enterScoreLabel);


        //课程查看
        JScrollPane sp2 = new JScrollPane();
        sp2.setBounds(width / 50, 30 + height / 20, width * 3 / 5, height * 3 / 5);
        sp2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        sp2.setBackground(Color.white);
        jp2.add(sp2);
        String[] columnName2 = {"课程编号", "课程名称", "学分", "上课时间", "上课地点", "所属专业",
                "状态", "课容量", "已选学生数量"};
        DefaultTableModel model2 = new DefaultTableModel(emptyTable, columnName2);
        JTable checkScoreTable = new JTable(model2) {
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp2.getViewport().add(checkScoreTable);
        for (int i = 0; i < 5; i++) {
            model2.addRow(emptyData);
        }
        JLabel semesterLabel = new JLabel("学期", JLabel.CENTER);
        semesterLabel.setBounds(width / 50, height / 40, 40, 30);
        jp2.add(semesterLabel);
        JComboBox chooseSemester = new JComboBox();
        for (String s : semesters) {
            chooseSemester.addItem(s);
        }
        chooseSemester.setBounds(width / 50 + 60, height / 40, 120, 30);
        jp2.add(chooseSemester);
        JTextField searchCourse = new JTextField();
        searchCourse.setBounds(width / 25 + 240, height / 40, 120, 30);
        jp2.add(searchCourse);
        JButton searchButton = new JButton("查询");
        searchButton.setBounds(width / 25 + 375, height / 40, 60, 30);
        jp2.add(searchButton);


        //事件

        //监听窗口大小变化
        jf.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int currentWidth = jf.getWidth();
                int currentHeight = jf.getHeight();
                jt.setBounds(0,currentHeight/50,currentWidth*2/11,currentHeight);
                tp.setBounds(currentWidth *2/ 11, currentHeight / 50, currentWidth * 4 / 5, currentHeight * 4 / 5);
                //jp0
                {
                    jp0.setSize(currentWidth, currentHeight);
                    semesterLabel0.setBounds(currentWidth / 50, currentHeight / 40, 40, 30);
                    chooseSemester0.setBounds(currentWidth / 50 + 60, currentHeight / 40, 120, 30);
                    int h = chooseSemester0.getHeight();
                    sp0.setBounds(currentWidth / 50, h + currentHeight / 20, currentWidth * 3 / 5, currentHeight * 3 / 5);

                }
                //jp1
                {
                    jp1.setSize(currentWidth, currentHeight);
                    sp1_0.setBounds(currentWidth / 50, 60 + currentHeight / 20, currentWidth * 3 / 5, currentHeight / 10);
                    sp1_1.setBounds(currentWidth / 50, currentHeight / 50, currentWidth * 3 / 5, currentHeight * 3 / 5);
                    sp1_1.setBounds(currentWidth / 50, 90 + currentHeight * 7 / 40, currentWidth * 3 / 5, currentHeight * 2 / 5);
                    semesterLabel_tab1.setBounds(currentWidth / 50, currentHeight / 40, 40, 30);
                    chooseSemester_tab1.setBounds(currentWidth / 50 + 60, currentHeight / 40, 120, 30);
                    selectCourseLabel.setBounds(currentWidth / 25 + 240, currentHeight / 40, 60, 30);
                    selectCourse.setBounds(currentWidth / 25 + 315, currentHeight / 40, 120, 30);
                    courseInformationLabel.setBounds(currentWidth / 50, currentHeight / 20 + 30, 65, 30);
                    enterScoreLabel.setBounds(currentWidth / 50, 60 + currentHeight * 7 / 40, 90, 30);
                    
                }

                //jp2
                {
                    jp2.setSize(currentWidth, currentHeight);
                    semesterLabel.setBounds(currentWidth / 50, currentHeight / 40, 40, 30);
                    chooseSemester.setBounds(currentWidth / 50 + 60, currentHeight / 40, 120, 30);
                    searchCourse.setBounds(currentWidth / 25 + 240, currentHeight / 40, 120, 30);
                    searchButton.setBounds(currentWidth / 25 + 375, currentHeight / 40, 60, 30);
                    int h = chooseSemester.getHeight();
                    sp2.setBounds(currentWidth / 50, h + currentHeight / 20, currentWidth * 3 / 5, currentHeight * 3 / 5);

                }

            }
        });

        //成绩录入



    }
    private void refreshCourseTable(){

    }
    public void close(){
        jf.setVisible(false);
    }
}

