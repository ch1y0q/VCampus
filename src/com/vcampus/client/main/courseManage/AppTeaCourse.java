package com.vcampus.client.main.courseManage;

import com.vcampus.client.main.App;
import com.vcampus.client.main.student.AppStudent;
import com.vcampus.client.main.teacher.AppTeacher;
import com.vcampus.client.main.teacher.TeaCategory;
import com.vcampus.entity.Course;
import com.vcampus.entity.CourseScore;
import com.vcampus.entity.Student;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AppTeaCourse extends JFrame {
    private int width = 1151;
    private int height = 800;
    private DefaultTableModel model0;
    private DefaultTableModel model2;
    private DefaultTableModel model1_0;
    private JComboBox chooseSemester0;
    private JComboBox chooseSemester;
    private JComboBox chooseSemester_tab1;
    public AppTeaCourse() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        setVisible(true);
        setLayout(null);
        setResizable(true);
        setBounds(0, 0, width, height);
        Container container = getContentPane();
        container.setBackground(new Color(0xD8F6F6));
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(width /50, height / 50, width * 4 / 5, height * 4 / 5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JButton btnBack = new JButton("返回");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnBack)
                {
                    setVisible(false);
                }
            }
        });
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnBack.setBounds(width-60, 0, 60, 30);
        container.add(btnBack);


//        //侧边栏
//        JTree jt=new TeaCategory().getJTree();
//        add(jt);
//        jt.setBounds(0,height/50,width*2/11,height);


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
        String[] semesters = {"全部","2020-2021-1", "2020-2021-2", "2020-2021-3", "2020-2021-4"};
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
        refreshCourseTable();



        //成绩录入
        JScrollPane sp1_0 = new JScrollPane();
        sp1_0.setBounds(width / 50, 60 + height / 20, width * 3 / 5, height / 10);
        sp1_0.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        sp1_0.setBackground(Color.white);
        jp1.add(sp1_0);
        String[] columnName1_0 = {"课程编号", "课程名称", "学分", "上课时间", "上课地点", "所属专业",
                 "课容量", "已选学生数量"};
        model1_0 = new DefaultTableModel(emptyTable, columnName1_0);
        JTable courseInformationTable = new JTable(model1_0) {
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp1_0.getViewport().add(courseInformationTable);
        JScrollPane sp1_1 = new JScrollPane();
        sp1_1.setBounds(width / 50, 90 + height * 7 / 40, width * 3 / 5, height * 2 / 5);
        sp1_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        sp1_1.setBackground(Color.white);
        jp1.add(sp1_1);
        String[] columnName1_1 = {"课程编号","学号", "姓名", "状态", "成绩录入"};
        DefaultTableModel model1_1 = new DefaultTableModel(emptyTable, columnName1_1);
        JTable enterScoreTable = new JTable(model1_1) {
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                if(column==4){
                    return true;
                }else{
                    return false;
                }
            }
        };
        sp1_1.getViewport().add(enterScoreTable);
        for (int i = 0; i < 10; i++) {
            model1_1.addRow(emptyData);
        }
        JLabel semesterLabel_tab1 = new JLabel("学期", JLabel.CENTER);
        semesterLabel_tab1.setBounds(width / 50, height / 40, 40, 30);
        jp1.add(semesterLabel_tab1);
        chooseSemester_tab1 = new JComboBox();
        for (String s : semesters) {
            chooseSemester_tab1.addItem(s);
        }
        chooseSemester_tab1.setBounds(width / 50 + 60, height / 40, 120, 30);
        jp1.add(chooseSemester_tab1);
        JLabel courseInformationLabel = new JLabel("课程信息：", JLabel.CENTER);
        courseInformationLabel.setBounds(width / 50, height / 20 + 30, 65, 30);
        jp1.add(courseInformationLabel);
        JLabel enterScoreLabel = new JLabel("学生成绩录入：");
        enterScoreLabel.setBounds(width / 50, 60 + height * 7 / 40, 90, 30);
        jp1.add(enterScoreLabel);
        JButton saveButton = new JButton("保存");
        jp1.add(saveButton);
        saveButton.setBounds(width*31/50-60,60 + height * 7 / 40,60,30);
        refreshCourseInfoTable();


        //课程查看
        JScrollPane sp2 = new JScrollPane();
        sp2.setBounds(width / 50, 30 + height / 20, width * 3 / 5, height * 3 / 5);
        sp2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        sp2.setBackground(Color.white);
        jp2.add(sp2);
        String[] columnName2 = {"课程编号","学期", "课程名称", "学分", "上课时间", "上课地点", "所属专业",
                 "课容量", "已选学生数量"};
        model2 = new DefaultTableModel(emptyTable, columnName2);
        JTable checkScoreTable = new JTable(model2) {
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                return false;
            }
        };
        sp2.getViewport().add(checkScoreTable);
        JLabel semesterLabel = new JLabel("学期", JLabel.CENTER);
        semesterLabel.setBounds(width / 50, height / 40, 40, 30);
        jp2.add(semesterLabel);
        chooseSemester = new JComboBox();
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
        refreshAllCourseTable();


        //事件

        //监听窗口大小变化
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int currentWidth = getWidth();
                int currentHeight = getHeight();
                //jt.setBounds(0,currentHeight/50,currentWidth*2/11,currentHeight);
                tp.setBounds(currentWidth /50, currentHeight / 50, currentWidth * 4 / 5, currentHeight * 4 / 5);
                btnBack.setBounds(currentWidth-60, 0, 60, 30);
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
                    courseInformationLabel.setBounds(currentWidth / 50, currentHeight / 20 + 30, 65, 30);
                    enterScoreLabel.setBounds(currentWidth / 50, 60 + currentHeight * 7 / 40, 90, 30);
                    saveButton.setBounds(currentWidth*31/50-60,60 + currentHeight * 7 / 40,60,30);
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
        //课程查询选择学期
        chooseSemester.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshAllCourseTable();
            }
        }
        );

        //教师课程信息选择学期
        chooseSemester_tab1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshCourseInfoTable();
            }
        }
        );

        courseInformationTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = courseInformationTable.getSelectedRow();
                String courseId = (String)model1_0.getValueAt(row,0);
                while(model1_1.getRowCount()>0){
                    model1_1.removeRow(0);
                }
                String res=ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                        null,"com.vcampus.server.teaching.CourseSelection.getStudentOfOneCourse",
                        new Object[] {courseId}).send()).getReturn(String.class);
                String[] studentList = res.split(",");
                for(String cardNumber:studentList){
                    String name = ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.StudentManage.getNameByCardNumber",
                            new Object[] {cardNumber}).send()).getReturn(String.class);
                    CourseScore courseScore = ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.getCourseScore",
                            new Object[] {cardNumber,courseId}).send()).getReturn(CourseScore.class);
                    if(courseScore!=null){
                        String status = courseScore.getStatus();
                        String score = courseScore.getScore();
                        String[] csInfo = {courseId,cardNumber,name,status,score};
                        model1_1.addRow(csInfo);
                    }

                }

            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Course> list = new ArrayList<>();
                ListIterator<Course> iter = list.listIterator();
                String courseName = searchCourse.getText();
                String semester = (String)chooseSemester.getSelectedItem();
                if(!courseName.equals("")){
                    list = ResponseUtils
                            .getResponseByHash(new Request(App.connectionToServer, null,
                                    "com.vcampus.server.teaching.CourseSelection.fuzzySearchByName",
                                    new Object[] {courseName}).send())
                            .getListReturn(Course.class);
                }
                while(model2.getRowCount()>0){
                    model2.removeRow(0);
                }
                for (Course course : list) {
                    if (semester.equals("全部") || course.getSemester().equals(semester)) {
                        String[] courseInfo = {course.getId(), course.getSemester(), course.getClassName(), course.getCredit(), course.getTime()
                                , course.getClassroom(), course.getMajor(), course.getCapacity(), course.getSelectedNumber()};
                        model2.addRow(courseInfo);
                    }
                }
            }
        }
        );

        //课表：选择学期
        chooseSemester0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshCourseTable();
            }
        }
        );

        //成绩录入
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<model1_1.getRowCount();i++){
                    String score = (String)model1_1.getValueAt(i,4);
                    String studentCardNumber=(String)model1_1.getValueAt(i,1);
                    String courseId=(String)model1_1.getValueAt(i,0);
                    CourseScore courseScore = new CourseScore(studentCardNumber,courseId,score,"");
                    ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.setScore",
                            new Object[] {courseScore}).send());
                }
                refreshCourseTable();
            }
        }
        );


    }
    private void refreshCourseTable(){
        clearCourseTable();
        String semester = (String)chooseSemester0.getSelectedItem();
        List<Course> list = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null,
                        "com.vcampus.server.teaching.CourseSelection.getClassOfOneTeacher",
                        new Object[] {App.session.getTeacher().getCardNumber()}).send())
                .getListReturn(Course.class);

            for(Course course:list){
                if(semester.equals("全部")||course.getSemester().equals(semester)){
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

    private void refreshAllCourseTable(){
        while(model2.getRowCount()>0){
            model2.removeRow(0);
        }
        String semester = (String)chooseSemester.getSelectedItem();
        List<Course> list = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null,
                        "com.vcampus.server.teaching.CourseSelection.getAllCourses",
                        new Object[] {}).send())
                .getListReturn(Course.class);
        for (Course course : list) {
            if (semester.equals("全部") || course.getSemester().equals(semester)) {
                String[] courseInfo = {course.getId(), course.getSemester(), course.getClassName(), course.getCredit(), course.getTime()
                        , course.getClassroom(), course.getMajor(), course.getCapacity(), course.getSelectedNumber()};
                model2.addRow(courseInfo);
            }
        }
    }

    private void refreshCourseInfoTable(){
        while(model1_0.getRowCount()>0){
            model1_0.removeRow(0);
        }
        String semester = (String)chooseSemester_tab1.getSelectedItem();
        List<Course> list = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null,
                        "com.vcampus.server.teaching.CourseSelection.getClassOfOneTeacher",
                        new Object[] {App.session.getTeacher().getCardNumber()}).send())
                .getListReturn(Course.class);
        for (Course course : list) {
            if (semester.equals("全部") || course.getSemester().equals(semester)) {
                String[] courseInfo = {course.getId(), course.getClassName(), course.getCredit(), course.getTime(), course.getClassroom()
                        , course.getMajor(), course.getCapacity(), course.getSelectedNumber()};
                model1_0.addRow(courseInfo);
            }
        }
    }

    private void clearCourseTable(){
        for(int i =0;i<13;i++){
            for(int j=0;j<7;j++){
                model0.setValueAt("",i,j);
            }
        }
    }
    public void close(){
        setVisible(false);
    }
    public void open(){setVisible(true);}
}

