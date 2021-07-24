package com.vcampus.client.main;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.*;

public class AppAdminCourse {
    private JFrame jf = new JFrame("课程管理");
    private int width = 1151;
    private int height = 800;
    public AppAdminCourse(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setBounds(0, 0, width, height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = jf.getContentPane();
        container.setBackground(new Color(0xD8F6F6));
        JPanel jp = new JPanel();
        container.add(jp);
        jp.setLayout(null);
        jp.setBounds(width*2/11,height/50,width*4/5,height*4/5);
        jp.setBackground(Color.white);


        //侧边栏
        JTree jt=new ManCategory().init();
        jf.add(jt);
        jt.setBackground(Color.white);
        jt.setBounds(0,height/50,width*2/11,height);


        //管理员课程管理
        JLabel CourseInformationManagerLabel = new JLabel("课程信息管理",JLabel.CENTER);
        jp.add(CourseInformationManagerLabel);
        CourseInformationManagerLabel.setBounds(width/50,height/40,90,30);
        JLabel anLabel = new JLabel("按",JLabel.CENTER);
        jp.add(anLabel);
        anLabel.setBounds(width*6/50+90,height/40,20,30);
        JComboBox chooseClass = new JComboBox();
        String[] classes = {"课程编号","课程名称","所属专业","授课教师"};
        for (String s: classes){
            chooseClass.addItem(s);
        }
        jp.add(chooseClass);
        chooseClass.setBounds(width*6/50+110,height/40,80,30);
        JLabel searchLabel = new JLabel("检索",JLabel.CENTER);
        jp.add(searchLabel);
        searchLabel.setBounds(width*6/50+190,height/40,40,30);
        JTextField searchCourseField = new JTextField();
        jp.add(searchCourseField);
        searchCourseField.setBounds(width*11/50+230,height/40,120,30);
        JButton searchButton = new JButton("查询");
        jp.add(searchButton);
        searchButton.setBounds(width*11/50+350,height/40,60,30);
        JButton startEditButton = new JButton("启动编辑");
        jp.add(startEditButton);
        startEditButton.setBounds(width*3/5-160,height/40+50,100,30);
        JButton saveButton = new JButton("保存");
        jp.add(saveButton);
        saveButton.setBounds(width*31/50-60,height/40+50,60,30);
        JScrollPane sp = new JScrollPane();
        jp.add(sp);
        sp.setBounds(width/50,height/20+80,width*3/5,height*3/5);
        String[] columnName = {"序号","课程编号","课程名称","所属专业","教师","上课时间"
                ,"上课地点","课容量","已选学生容量","学分","状态"};
        String[][] emptyTable = {};
        String[] emptyData = {};
        DefaultTableModel model = new DefaultTableModel(emptyTable,columnName);
        JTable courseInformationTable = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp.getViewport().add(courseInformationTable);
        for (int i = 0; i < 25; i++) {
            model.addRow(emptyData);
        }



        jf.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int currentWidth = jf.getWidth();
                int currentHeight = jf.getHeight();
                jt.setBounds(0,currentHeight/50,currentWidth*2/11,currentHeight);
                jp.setBounds(currentWidth*2/11,currentHeight/50,currentWidth*4/5,currentHeight*4/5);
                CourseInformationManagerLabel.setBounds(currentWidth/50,currentHeight/40,90,30);
                anLabel.setBounds(currentWidth*6/50+90,currentHeight/40,20,30);
                chooseClass.setBounds(currentWidth*6/50+110,currentHeight/40,80,30);
                searchLabel.setBounds(currentWidth*6/50+190,currentHeight/40,40,30);
                searchCourseField.setBounds(currentWidth*11/50+230,currentHeight/40,120,30);
                searchButton.setBounds(currentWidth*11/50+350,currentHeight/40,60,30);
                startEditButton.setBounds(currentWidth*3/5-160,currentHeight/40+50,100,30);
                saveButton.setBounds(currentWidth*31/50-60,currentHeight/40+50,60,30);
                sp.setBounds(currentWidth/50,currentHeight/20+80,currentWidth*3/5,currentHeight*3/5);

            }
        });

        //编辑课程


        //保存编辑


    }
    private void refreshCourseTable(){

    }
    private void close(){
        jf.setVisible(false);
    }
}
