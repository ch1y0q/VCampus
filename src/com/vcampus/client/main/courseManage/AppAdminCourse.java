package com.vcampus.client.main.courseManage;

import com.vcampus.client.main.App;
import com.vcampus.client.main.manager.AppAdmin;
import com.vcampus.client.main.manager.ManCategory;
import com.vcampus.client.main.teacher.AppTeacher;
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
/**
 * 管理员课程界面
 * @author ryp
 *
 */

public class AppAdminCourse  extends JFrame{
    /**
     * AppAdminCourse类是管理员进行课程管理的界面，
     * 在这个界面中可以实现添加课程，删除课程，
     * 修改课程信息等操作。
     * 为了方便使用，设置了各种类型的查找功能，
     * 方便管理员快速找到需要修改的找到的课程
     *
     */
    
    private int width = 1151;
    private int height = 800;
    private DefaultTableModel model;
    public AppAdminCourse(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        setLayout(null);
        setResizable(true);
        setBounds(0, 0, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setBackground(new Color(0xD8F6F6));
        JPanel jp = new JPanel();
        container.add(jp);
        jp.setLayout(null);
        jp.setBounds(width*2/11,height/50,width*4/5,height*4/5);
        jp.setBackground(Color.white);
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
        btnBack.setBounds(width*41/50, height, 60, 30);
        container.add(btnBack);


        /**
         * 界面布局
         */
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

        /**
         * 界面上的组件触发的事件
         */
        //界面事件


        /**
         * 监听窗口大小变化的事件，
         * 大小变化时，窗口内组件大小，位置相应变化
         */
        //监听窗口大小变化
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int currentWidth = getWidth();
                int currentHeight = getHeight();
                jp.setBounds(currentWidth/50,currentHeight/50,currentWidth*4/5,currentHeight*4/5);
                btnBack.setBounds(currentWidth-60, 0, 60, 30);
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


        /**
         * 点击“启动编辑”按钮，表格变为可编辑状态，课程编号列由于是课程类中的关键字不可编辑
         * 双击需要编辑的单元格即可对其中内容进行编辑
         */
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


        /**
         * 点击“删除”，将该行课程删除
         */
        //删除课程
        courseInformationTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = courseInformationTable.getSelectedColumn();
                int row = courseInformationTable.getSelectedRow();
                if(column == 10&&!((String)model.getValueAt(row,8)).equals("0")){
                    String courseId = (String)model.getValueAt(row,1);
                    ResponseUtils.getResponseByHash(new Request(App.connectionToServer,
                            null,"com.vcampus.server.teaching.CourseSelection.deleteCourse",
                            new Object[] {courseId}).send());
                    model.removeRow(row);
                }
            }
        });

        /**
         * 点击按钮“添加”开始添加课程，点击后该按钮变成确认按钮，
         * 课程编号由系统自动生成并且不可修改，此时该按钮变成确认按钮
         * 已选课程人数设置为0，请根据提示在教师一栏中填入教师一卡通号而不是教师姓名
         * 点击确认按钮，完成课程添加，此时点击保存将不会将新加入的课程加入数据库中
         */
        //添加课程
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


        /*
         * 点击“保存”按钮，保存对课程所作的编辑，表格变回不可编辑状态
         */
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

        /**
         * 点击查询按钮，对于文本框中内容按照左边下拉列表选中的类别检索课程，
         * 将符合的课程展示在表格中
         */
        //查询
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchClass = (String)chooseClass.getSelectedItem();
                List<Course> list = new ArrayList<>();
                ListIterator<Course> iter = list.listIterator();
                //按课程编号查找
                if(searchClass.equals("课程编号")){
                    String courseId = searchCourseField.getText();
                    System.out.println("id= "+courseId);
                    if(!courseId.equals("")){
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
                //按课程名称查找
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
                //按专业查找
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
                //按教师查找
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

    /**
     * 刷新表格，重新从数据库中提取数据填充表格
     */
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

    /**
     * 关闭页面
     */
    private void close(){
        setVisible(false);
    }

    /**
     * 打开页面
     */
    private void open(){
        setVisible(true);
    }
}
