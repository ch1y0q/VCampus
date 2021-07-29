package com.vcampus.client.main.courseManage;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import com.vcampus.client.main.App;
import com.vcampus.client.main.student.StuCategory;
import com.vcampus.net.Request;
import com.vcampus.util.*;

import com.vcampus.entity.*;

import java.util.List;
import java.util.ListIterator;

public class AppStuCourse extends JFrame {
    private double credit = 0;
    private int width = 1151;
    private int height = 800;
    private Student student;
    private DefaultTableModel model0; //课表
    private DefaultTableModel model1; //选课
    private DefaultTableModel model2;//已选课
    private DefaultTableModel model3;
    private JComboBox chooseSemester0;
    private JComboBox chooseSemester;
    private JLabel numOfCreditInSemesterLabel;
    private JLabel numOfScoreLabel;
    public AppStuCourse(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setVisible(true);
        setLayout(null);
        setResizable(true);
        setSize(screenSize);

        Container container = getContentPane();
        container.setBackground(new Color(0xD8F6F6));
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(width*2/11,height/50,width*4/5,height*4/5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        /*
        //侧边栏
        JTree jt= new StuCategory().getJTree();
        add(jt);
        jt.setBounds(0,height/50,width*2/11,height);
        */

        //课程表
        JScrollPane sp0 = new JScrollPane();
        sp0.setBounds(width / 50, 30 + height / 20, width * 3 / 5, height * 3 / 5);
        sp0.setBorder(BorderFactory.createLineBorder(new Color(0x0B3F44), 1));
        sp0.setBackground(Color.white);
        jp0.add(sp0);
        String[] columnNames0 = {"", "一", "二", "三", "四", "五", "六", "七"};
        String[][] emptyTable = {};
        String[] emptyData = {};
        model0 = new DefaultTableModel(emptyTable, columnNames0);
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
        chooseSemester0 = new JComboBox();
        String[] semesters = {"All","2020-2021-1", "2020-2021-2", "2020-2021-3", "2020-2021-4"};
        for (String s : semesters) {
            chooseSemester0.addItem(s);
        }
        chooseSemester0.setBounds(width / 50 + 60, height / 40, 120, 30);
        jp0.add(chooseSemester0);
        courseTable.setRowHeight(60);
        sp0.setViewportView(courseTable);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        courseTable.setDefaultRenderer(Object.class, tcr);
        refreshCourseTable();

        //选课
        JScrollPane sp1 = new JScrollPane();
        sp1.setBounds(width/50, height/40, width * 3 / 5, height * 3 / 5);
        sp1.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        sp1.setBackground(Color.white);
        jp1.add(sp1);
        String[] columnName1={"课程编号","课程名称","学期","学分","教师","上课时间","上课地点",
                "所属专业","课容量","已选学生数量",""};
        model1 = new DefaultTableModel(emptyTable,columnName1);
        JTable selectCourseTable = new JTable(model1){
            public boolean isCellEditable(int row, int column){
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp1.setViewportView(selectCourseTable);
        JButton refreshButton = new JButton("刷新");
        refreshButton.setBounds(width*16/25,height/40,60,30);
        jp1.add(refreshButton);
        refreshSelectCourseTable();


        //已选课程
        JScrollPane sp2 = new JScrollPane();
        sp2.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        sp2.setBackground(Color.white);
        jp2.add(sp2);
        String[] columnName2={"课程编号","课程名称","学期","学分","教师","上课时间","上课地点",
                "所属专业","课容量","已选学生数量",""};
        model2 = new DefaultTableModel(emptyTable,columnName2);
        JTable selectedCourseTable = new JTable(model2){
            public boolean isCellEditable(int row, int column){
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp2.getViewport().add(selectedCourseTable);
        JLabel selectedCreditLabel = new JLabel("已选学分");
        selectedCreditLabel.setBorder(BorderFactory.createLineBorder(Color.black,1));
        selectedCreditLabel.setBounds(width/50,height/40,80,30);
        jp2.add(selectedCreditLabel);
        JTextArea numOfCreditText = new JTextArea();
        numOfCreditText.setBounds(width/50+95,height/40,50,30);
        numOfCreditText.setEditable(false);
        jp2.add(numOfCreditText);
        sp2.setBounds(width / 50, 30+height / 20, width * 3 / 5, height * 3 / 5);
        initSelectedCourseTable();
        numOfCreditText.setText(calculateCredit());

        //成绩查询
        JScrollPane sp3 = new JScrollPane();
        sp3.setBounds(width/50, 30+height/20, width * 3 / 5, height * 3 / 5);
        sp3.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        sp3.setBackground(Color.white);
        jp3.add(sp3);
        String[] columnName3={"课程编号","课程名称","学分","学期","成绩",
                "是否首修"};
        model3 = new DefaultTableModel(emptyTable,columnName3);
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
        chooseSemester = new JComboBox();
        for (String s : semesters) {
            chooseSemester.addItem(s);
        }
        chooseSemester.setBounds(width/50+60,height/40,120,30);
        jp3.add(chooseSemester);
        JLabel creditInSemesterLabel = new JLabel("学分",JLabel.CENTER);
        creditInSemesterLabel.setBounds(width/25+240,height/40,40,30);
        jp3.add(creditInSemesterLabel);
        numOfCreditInSemesterLabel = new JLabel();
        numOfCreditInSemesterLabel.setBounds(width/25+295,height/40,40,30);
        jp3.add(numOfCreditInSemesterLabel);
        JLabel scoreLabel = new JLabel("绩点",JLabel.CENTER);
        scoreLabel.setBounds(width*2/25+395,height/40,40,30);
        jp3.add(scoreLabel);
        numOfScoreLabel = new JLabel();
        numOfScoreLabel.setBounds(width*2/25+450,height/40,40,30);
        jp3.add(numOfScoreLabel);
        refreshCheckScoreTable();

        //事件

        //监听窗口大小变化
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int currentWidth = getWidth();
                int currentHeight = getHeight();
                tp.setBounds(currentWidth/50,currentHeight/50,currentWidth*4/5,currentHeight*4/5);
                // jt.setBounds(0,currentHeight/50,currentWidth*2/11,currentHeight);
                //jp0
                {
                    jp0.setSize(currentWidth, currentHeight);
                    //sp0.setBounds(currentWidth / 50, currentHeight / 50, currentWidth * 3 / 5, currentHeight * 3 / 5);
                    sp0.setBounds(currentWidth / 50, 30 + currentHeight / 20, currentWidth * 3 / 5, currentHeight * 3 / 5);
                    semesterLabel0.setBounds(currentWidth / 50, currentHeight / 40, 40, 30);
                    chooseSemester0.setBounds(currentWidth / 50 + 60, currentHeight / 40, 120, 30);
                }
                //jp1
                {
                    jp1.setSize(currentWidth, currentHeight);
                    sp1.setBounds(currentWidth / 50, currentHeight / 50, currentWidth * 3 / 5, currentHeight * 3 / 5);
                    refreshButton.setBounds(currentWidth*16/25,currentHeight/40,60,30);
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
                    numOfCreditInSemesterLabel.setBounds(currentWidth/25+295,currentHeight/40,40,30);
                    scoreLabel.setBounds(currentWidth*2/25+395,currentHeight/40,40,30);
                    numOfScoreLabel.setBounds(currentWidth*2/25+450,currentHeight/40,40,30);
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
                if(column == 10&&model1.getValueAt(row,column)=="选择"){
                    model1.setValueAt("<html><font color='rgb(110,110,110)'>已选</font></html>",row,column);
                    //String courseId = "12345";
                    Object courseIdO = model1.getValueAt(row,0);
                    String courseId = (String)courseIdO;
                    Boolean IsTakeCourse = ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.takeCourse",
                            new Object[] {App.session.getStudent(),courseId}).send()).getReturn(Boolean.class);
                    Course course = ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.getOneCourse",
                            new Object[] {courseId}).send()).getReturn(Course.class);
                    String[] courseInfo = {course.getId(),course.getClassName(),course.getSemester(),course.getCredit()
                            ,course.getTeacher(),course.getTime(),course.getClassroom(),course.getMajor(),course.getCapacity()
                            ,course.getSelectedNumber(),"退课"};
                    model2.addRow(courseInfo);
                    refreshCourseTable();
                    numOfCreditText.setText(calculateCredit());
                }
            }
        });

        //退课
        selectedCourseTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int column = selectedCourseTable.getSelectedColumn();
                int row = selectedCourseTable.getSelectedRow();
                if(column == 10){
                    Object courseIdO = model2.getValueAt(row,0);
                    String courseId = (String)courseIdO;
                    String res=ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.dropCourse",
                            new Object[] {App.session.getStudent(),courseId}).send()).getReturn(String.class);
                    System.out.println("result= "+res);
                    model2.removeRow(row);
                    numOfCreditText.setText(calculateCredit());
                    refreshCourseTable();
                    refreshCheckScoreTable();
                    refreshSelectCourseTable();
                }
            }
        });

        //课表：选择学期
        chooseSemester0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshCourseTable();
            }
        }
        );

        chooseSemester.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshCheckScoreTable();
            }
        }
        );

        //刷新选课表
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshSelectCourseTable();
            }
        }
        );
        //成绩查询页面选择学期


    }


    //刷新课表
    private void refreshCourseTable(){
        clearCourseTable();
        String semester = (String)chooseSemester0.getSelectedItem();
        String selectedCourses = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null,
                        "com.vcampus.server.teaching.CourseSelection.getCourseSelection",
                        new Object[] {App.session.getStudent()}).send())
                .getReturn(String.class);
        if(selectedCourses!=""){
            String[] splitSelectedCourses = selectedCourses.split(",");
            for(String s:splitSelectedCourses){
                Course course = ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null,
                                "com.vcampus.server.teaching.CourseSelection.getOneCourse",
                                new Object[] {s}).send())
                        .getReturn(Course.class);
                if(semester.equals("All")||course.getSemester().equals(semester)){
                    String time = course.getTime();
                    String[] splitTime = time.split("-");
                    int start = Integer.parseInt(splitTime[1]);
                    int end = Integer.parseInt(splitTime[2]);
                    int day = Integer.parseInt(splitTime[0]);
                    for(int i = start-1;i<=end-1;i++){
                        String name = course.getClassName();
                        String classroom = course.getClassroom();
                        model0.setValueAt("<html><center>"+name+"<br>"+classroom+"</center></html>",i,day);
                    }
                }

            }
        }
    }

    //刷新选课表
    private void refreshSelectCourseTable(){
        while(model1.getRowCount()>0){
            model1.removeRow(0);
        }
        List<Course> list = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null,
                        "com.vcampus.server.teaching.CourseSelection.getAllCourses",
                        new Object[] {}).send())
                .getListReturn(Course.class);
        ListIterator<Course> iter = list.listIterator();
        String cardNumber = App.session.getStudent().getCardNumber();
        while(iter.hasNext()){
            Course course = iter.next();
            String courseId = course.getId();
            String status = "选择";
            CourseScore courseScore = ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                    null,"com.vcampus.server.teaching.CourseSelection.getCourseScore",
                    new Object[] {cardNumber,courseId}).send()).getReturn(CourseScore.class);
            if(courseScore != null){
                status = "已选";
            }
            String[] courseInfo = {course.getId(),course.getClassName(),course.getSemester(),course.getCredit()
                    ,course.getTeacher(),course.getTime(),course.getClassroom(),course.getMajor(),course.getCapacity()
                    ,course.getSelectedNumber(),status};
            model1.addRow(courseInfo);
        }
    }

    //清空课表
    private void clearCourseTable(){
        for(int i =0;i<13;i++){
            for(int j=0;j<7;j++){
                model0.setValueAt("",i,j);
            }
        }
    }

    //初始化已选课表
    private void initSelectedCourseTable(){
        while(model2.getRowCount()>0){
            model2.removeRow(0);
        }
        String selectedCourses = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null,
                        "com.vcampus.server.teaching.CourseSelection.getCourseSelection",
                        new Object[] {App.session.getStudent()}).send())
                .getReturn(String.class);
        if(selectedCourses!=""){
            String[] splitSelectedCourses = selectedCourses.split(",");
            for(String s:splitSelectedCourses){
                Course course = ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null,
                                "com.vcampus.server.teaching.CourseSelection.getOneCourse",
                                new Object[] {s}).send())
                        .getReturn(Course.class);
                String[] courseInfo = {course.getId(),course.getClassName(),course.getSemester(),course.getCredit()
                        ,course.getTeacher(),course.getTime(),course.getClassroom(),course.getMajor(),course.getCapacity()
                        ,course.getSelectedNumber(),"退课"};
                model2.addRow(courseInfo);
            }
        }
    }

    //关闭窗口
    public void close(){
        setVisible(false);
    }

    //计算学分
    private String calculateCredit(){
        credit = 0;
        for(int i = 0;i<model2.getRowCount();i++){
            String n = (String)model2.getValueAt(i,3);
            if(n!=null){
                Double d = Double.parseDouble(n);
                credit+=d;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        String sCredit = df.format(credit);
        return sCredit;
    }

    public void refreshCheckScoreTable(){
        while(model3.getRowCount()>0){
            model3.removeRow(0);
        }
        String semester = (String)chooseSemester.getSelectedItem();
        String selectedCourses = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null,
                        "com.vcampus.server.teaching.CourseSelection.getCourseSelection",
                        new Object[] {App.session.getStudent()}).send())
                .getReturn(String.class);
        String cardNumber = App.session.getStudent().getCardNumber();
        if(selectedCourses!=""){
            String[] splitSelectedCourses = selectedCourses.split(",");
            for(String s:splitSelectedCourses){
                Course course = ResponseUtils
                        .getResponseByHash(new Request(App.connectionToServer, null,
                                "com.vcampus.server.teaching.CourseSelection.getOneCourse",
                                new Object[] {s}).send())
                        .getReturn(Course.class);
                String courseId = course.getId();
                if(semester.equals("All")||course.getSemester().equals(semester)){
                    CourseScore courseScore = ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.getCourseScore",
                            new Object[] {cardNumber,courseId}).send()).getReturn(CourseScore.class);
                    String[] data = {courseId,course.getClassName(),course.getCredit(),course.getSemester(),courseScore.getScore(),
                            courseScore.getStatus()};
                    model3.addRow(data);
                }
                double credit = 0;
                double zongJiDian = 0;
                for(int i = 0;i<model3.getRowCount();i++){
                    String n = (String)model3.getValueAt(i,2);
                    String score = (String)model3.getValueAt(i,4);
                    if(n!=null){
                        Double d = Double.parseDouble(n);
                        double jiDian = stringToDouble(score);
                        zongJiDian+=d*jiDian;
                        credit+=d;
                    }
                }
                zongJiDian = zongJiDian/credit;
                DecimalFormat df = new DecimalFormat("0.00");
                String sCredit = df.format(credit);
                String sZongJiDian = df.format(zongJiDian);
                numOfCreditInSemesterLabel.setText(sCredit);
                numOfScoreLabel.setText(sZongJiDian);
            }
        }
    }

    private double stringToDouble(String score){
        double res = 0;
        if(!score.equals("")){
            double d = Double.parseDouble(score);
            if(d>=96){
                return 4.8;
            }
            else if(d>=93&&d<96){
                return 4.5;
            }
            else if(d>=90&&d<93){
                return 4.0;
            }
            else if(d>=86&&d<90){
                return 3.8;
            }
            else if(d>=83&&d<86){
                return 3.5;
            }
            else if(d>=80&&d<83){
                return 3.0;
            }
            else if(d>=76&&d<80){
                return 2.8;
            }
            else if(d>=73&&d<76){
                return 2.5;
            }
            else if(d>=70&&d<73){
                return 2.0;
            }
            else if(d>=66&&d<70){
                return 1.8;
            }
            else if(d>=63&&d<66){
                return 1.5;
            }
            else if(d>=60&&d<63){
                return 1.0;
            }
            else if(d<60){
                return 0;
            }
        }
        else{
            return 0;
        }
        return res;
    }

    public void open(){
        setVisible(true);
    }

}

