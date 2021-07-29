package com.vcampus.client.main.courseManage;

import com.vcampus.client.main.App;
import com.vcampus.client.main.manager.ManCategory;
import com.vcampus.entity.Course;
import com.vcampus.entity.Teacher;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class AppAdminCourse {
    private JFrame jf = new JFrame("课程管理");
    private int width = 1151;
    private int height = 800;
    private DefaultTableModel model;
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


//        //侧边栏
//        JTree jt= new StuCategory().getJTree();
//        add(jt);
//        jt.setBounds(0,height/50,width*2/11,height);


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
        JButton addCourseButton = new JButton("添加");
        jp.add(addCourseButton);
        addCourseButton.setBounds(width*29/50-220,height/40+50,60,30);
        JButton startEditButton = new JButton("启动编辑");
        jp.add(startEditButton);
        startEditButton.setBounds(width*3/5-160,height/40+50,100,30);
        JButton saveButton = new JButton("保存");
        jp.add(saveButton);
        saveButton.setBounds(width*31/50-60,height/40+50,60,30);
        JScrollPane sp = new JScrollPane();
        jp.add(sp);
        sp.setBounds(width/50,height/20+80,width*3/5,height*3/5);
        String[] columnName = {"学期","课程编号","课程名称","所属专业","教师","上课时间"
                ,"上课地点","课容量","已选学生容量","学分","操作"};
        String[][] emptyTable = {};
        String[] emptyData = {};
        model = new DefaultTableModel(emptyTable,columnName);
        JTable courseInformationTable = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                this.setRowSelectionAllowed(false);
                this.setColumnSelectionAllowed(false);
                if(column==1&&column==10){
                    return false;
                }else{
                    return true;
                }
            }
        };
        sp.getViewport().add(courseInformationTable);
        refreshCourseTable();
        courseInformationTable.setEnabled(false);

        jf.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int currentWidth = jf.getWidth();
                int currentHeight = jf.getHeight();
                jp.setBounds(currentWidth/50,currentHeight/50,currentWidth*4/5,currentHeight*4/5);
                CourseInformationManagerLabel.setBounds(currentWidth/50,currentHeight/40,90,30);
                anLabel.setBounds(currentWidth*6/50+90,currentHeight/40,20,30);
                chooseClass.setBounds(currentWidth*6/50+110,currentHeight/40,80,30);
                searchLabel.setBounds(currentWidth*6/50+190,currentHeight/40,40,30);
                searchCourseField.setBounds(currentWidth*11/50+230,currentHeight/40,120,30);
                searchButton.setBounds(currentWidth*11/50+350,currentHeight/40,60,30);
                startEditButton.setBounds(currentWidth*3/5-160,currentHeight/40+50,100,30);
                saveButton.setBounds(currentWidth*31/50-60,currentHeight/40+50,60,30);
                addCourseButton.setBounds(currentWidth*29/50-220,currentHeight/40+50,60,30);
                sp.setBounds(currentWidth/50,currentHeight/20+80,currentWidth*3/5,currentHeight*3/5);

            }
        });

        //编辑课程
        startEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i< model.getRowCount();i++){
                    model.setValueAt("<html><font color='red'>删除</font></html>",i,10);
                }
                courseInformationTable.setEnabled(true);
                }
            }
        );


        courseInformationTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = courseInformationTable.getSelectedColumn();
                int row = courseInformationTable.getSelectedRow();
                if(column == 10){
                    String courseId = (String)model.getValueAt(row,1);
                    ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.deleteCourse",
                            new Object[] {courseId}).send());
                    model.removeRow(row);
                }
            }
        });


        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addCourseButton.getText().equals("添加")){
                    addCourseButton.setText("确认");
                    courseInformationTable.setEnabled(true);
                    model.addRow(emptyData);
                    Random r = new Random();
                    int id = r.nextInt(45000)+5000;
                    id = id*2;
                    String courseId = Integer.toString(id);
                    model.setValueAt("请输入教师编号", model.getRowCount()-1,4);
                    model.setValueAt(courseId, model.getRowCount()-1,1);
                }else if(addCourseButton.getText().equals("确认")){
                    addCourseButton.setText("添加");
                    courseInformationTable.setEnabled(true);
                    int i = model.getRowCount()-1;
                    Course course = new Course();
                    course.setSemester((String)model.getValueAt(i,0));
                    course.setId((String)model.getValueAt(i,1));
                    course.setClassName((String)model.getValueAt(i,2));
                    course.setMajor((String)model.getValueAt(i,3));
                    String teacherNumber = (String)model.getValueAt(i,4);
                    if(teacherNumber.equals("请输入教师编号")){
                        course.setTeacher("");
                        course.setTeacherCard("");
                    }else{
                        course.setTeacherCard(teacherNumber);
                        Teacher teacher = ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                                null,"com.vcampus.server.TeacherManage.getTeacherDetailByCardNumber",
                                new Object[] {teacherNumber}).send()).getReturn(Teacher.class);
                        course.setTeacher(teacher.getName());
                        model.setValueAt(teacher.getName(),i,4);
                    }
                    course.setTime((String)model.getValueAt(i,5));
                    course.setClassroom((String)model.getValueAt(i,6));
                    course.setCapacity((String)model.getValueAt(i,7));
                    course.setSelectedNumber("0");
                    model.setValueAt("0",i,8);
                    course.setCredit((String)model.getValueAt(i,9));
                    ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.addCourse",
                            new Object[] {course}).send());
                }

            }
        }
        );

        //保存编辑
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                courseInformationTable.setEnabled(false);
                for(int i=0;i<courseInformationTable.getRowCount();i++){
                    model.setValueAt("",i,10);
                    String courseId = (String)model.getValueAt(i,1);
                    Course course = ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.getOneCourse",
                            new Object[] {courseId}).send()).getReturn(Course.class);
                    course.setSemester((String)model.getValueAt(i,0));
                    course.setClassName((String)model.getValueAt(i,2));
                    course.setMajor((String)model.getValueAt(i,3));
                    course.setTeacher((String)model.getValueAt(i,4));
                    course.setTime((String)model.getValueAt(i,5));
                    course.setClassroom((String)model.getValueAt(i,6));
                    course.setCapacity((String)model.getValueAt(i,7));
                    course.setSelectedNumber((String)model.getValueAt(i,8));
                    course.setCredit((String)model.getValueAt(i,9));
                    ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.setCourse",
                            new Object[] {course}).send());
                }
                refreshCourseTable();
            }

        }
        );

        //查询
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchClass = (String)chooseClass.getSelectedItem();
                List<Course> list = new ArrayList<>();
                ListIterator<Course> iter = list.listIterator();
                if(searchClass.equals("课程编号")){
                    String courseId = searchCourseField.getText();
                    System.out.println("id= "+courseId);
                    if(!courseId.equals("")){
                        System.out.println("id= "+courseId);
                        list = ResponseUtils
                                .getResponseByHash(new Request(App.connectionToServer, null,
                                        "com.vcampus.server.teaching.CourseSelection.fuzzySearchById",
                                        new Object[] {courseId}).send())
                                .getListReturn(Course.class);
                    }
                    while(model.getRowCount()>0){
                        model.removeRow(0);
                    }
                    for (Course course : list) {
                        String[] courseInfo = {course.getSemester(), course.getId(), course.getClassName(), course.getMajor(), course.getTeacher(), course.getTime()
                                , course.getClassroom(), course.getCapacity(), course.getSelectedNumber(), course.getCredit()};
                        model.addRow(courseInfo);
                    }

                }
                else if(searchClass.equals("课程名称")){
                    String courseName = searchCourseField.getText();
                    if(!courseName.equals("")){
                        list = ResponseUtils
                                .getResponseByHash(new Request(App.connectionToServer, null,
                                        "com.vcampus.server.teaching.CourseSelection.fuzzySearchByName",
                                        new Object[] {courseName}).send())
                                .getListReturn(Course.class);
                    }
                    while(model.getRowCount()>0){
                        model.removeRow(0);
                    }
                    for (Course course : list) {
                        String[] courseInfo = {course.getSemester(), course.getId(), course.getClassName(), course.getMajor(), course.getTeacher(), course.getTime()
                                , course.getClassroom(), course.getCapacity(), course.getSelectedNumber(), course.getCredit()};
                        model.addRow(courseInfo);
                    }
                }
                else if(searchClass.equals("所属专业")){
                    String courseMajor = searchCourseField.getText();
                    if(!courseMajor.equals("")){
                        list = ResponseUtils
                                .getResponseByHash(new Request(App.connectionToServer, null,
                                        "com.vcampus.server.teaching.CourseSelection.fuzzySearchByMajor",
                                        new Object[] {courseMajor}).send())
                                .getListReturn(Course.class);
                    }
                    while(model.getRowCount()>0){
                        model.removeRow(0);
                    }
                    for (Course course : list) {
                        String[] courseInfo = {course.getSemester(), course.getId(), course.getClassName(), course.getMajor(), course.getTeacher(), course.getTime()
                                , course.getClassroom(), course.getCapacity(), course.getSelectedNumber(), course.getCredit()};
                        model.addRow(courseInfo);
                    }
                }
                else if(searchClass.equals("授课教师")){
                    String courseTeacher = searchCourseField.getText();
                    if(!courseTeacher.equals("")){
                        list = ResponseUtils
                                .getResponseByHash(new Request(App.connectionToServer, null,
                                        "com.vcampus.server.teaching.CourseSelection.fuzzySearchByTeacher",
                                        new Object[] {courseTeacher}).send())
                                .getListReturn(Course.class);
                    }
                    while(model.getRowCount()>0){
                        model.removeRow(0);
                    }
                    for (Course course : list) {
                        String[] courseInfo = {course.getSemester(), course.getId(), course.getClassName(), course.getMajor(), course.getTeacher(), course.getTime()
                                , course.getClassroom(), course.getCapacity(), course.getSelectedNumber(), course.getCredit()};
                        model.addRow(courseInfo);
                    }
                }
            }
        }
        );


    }
    private void refreshCourseTable(){
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
        List<Course> list = ResponseUtils
                .getResponseByHash(new Request(App.connectionToServer, null,
                        "com.vcampus.server.teaching.CourseSelection.getAllCourses",
                        new Object[] {}).send())
                .getListReturn(Course.class);
        for (Course course : list) {
            String[] courseInfo = {course.getSemester(), course.getId(), course.getClassName(), course.getMajor(), course.getTeacher(), course.getTime()
                    , course.getClassroom(), course.getCapacity(), course.getSelectedNumber(), course.getCredit()};
            model.addRow(courseInfo);
        }

    }
    private void close(){
        jf.setVisible(false);
    }
    public void open(){
        jf.setVisible(true);
    }
}
