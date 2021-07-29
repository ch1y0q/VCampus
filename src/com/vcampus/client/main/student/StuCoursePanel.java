package com.vcampus.client.main.student;

import com.vcampus.client.main.App;
import com.vcampus.entity.Course;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * @author Xiao Kaijie
 * @date 2021-07-19
 */
public class StuCoursePanel extends JPanel {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle("com.vcampus.client.ClientResource", locale);
    public JLabel lblCI1;
    public JLabel lblCI2;
    public JLabel lblCI3;
    public JLabel lblCI4;
    public JLabel lblCI5;

    public StuCoursePanel()
    {
        setLayout(null);
        setBorder(new LineBorder(new Color(135, 206, 250), 3, true));

        lblCI1 = new JLabel(res.getString("no_course")); //1-2
        lblCI1.setFont(new Font("宋体", Font.PLAIN, 15));
        lblCI1.setBounds(20, 30, 222, 30);
        add(lblCI1);
        lblCI1.setVisible(false);
        lblCI2 = new JLabel(res.getString("no_course"));//3-4
        lblCI2.setFont(new Font("宋体", Font.PLAIN, 15));
        lblCI2.setBounds(20, 60, 222, 30);
        add(lblCI2);
        lblCI2.setVisible(false);
        lblCI3 = new JLabel(res.getString("no_course"));//6-7
        lblCI3.setFont(new Font("宋体", Font.PLAIN, 15));
        lblCI3.setBounds(20, 90, 222, 30);
        add(lblCI3);
        lblCI3.setVisible(false);
        lblCI4 = new JLabel(res.getString("no_course"));//8-9
        lblCI4.setFont(new Font("宋体", Font.PLAIN, 15));
        lblCI4.setBounds(20, 120, 222, 30);
        add(lblCI4);
        lblCI4.setVisible(false);
        lblCI5 = new JLabel(res.getString("no_course"));//11-12
        lblCI5.setFont(new Font("宋体", Font.PLAIN, 15));
        lblCI5.setBounds(20, 150, 222, 30);
        add(lblCI5);
        lblCI5.setVisible(false);

        JLabel[] lblCourses = new JLabel[]{lblCI1, lblCI2, lblCI3, lblCI4, lblCI5};


//        JLabel lblNewLabel_3 = new JLabel("1~2节");
//        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
//        lblNewLabel_3.setBounds(20, 30, 64, 30);
//        add(lblNewLabel_3);
//
//        JLabel label_6 = new JLabel("3~4节");
//        label_6.setFont(new Font("宋体", Font.PLAIN, 15));
//        label_6.setBounds(20, 60, 64, 30);
//        add(label_6);
//
//        JLabel label_7 = new JLabel("6~7节");
//        label_7.setFont(new Font("宋体", Font.PLAIN, 15));
//        label_7.setBounds(20, 90, 64, 30);
//        add(label_7);
//        JLabel label_8 = new JLabel("8~9节");
//        label_8.setFont(new Font("宋体", Font.PLAIN, 15));
//        label_8.setBounds(20, 120, 64, 30);
//        add(label_8);
//
//        JLabel label_9 = new JLabel();
//        label_9.setText("11-13节");
//        label_9.setFont(new Font("宋体", Font.PLAIN, 15));
//        label_9.setBounds(20, 150, 64, 30);
//        add(label_9);
    }
//    public void init()
//    {
//        lblCI1.setText("校企实训");
//        lblCI2.setText("校企实训");
//        lblCI3.setText("校企实训");
//        lblCI4.setText("校企实训");
//        lblCI5.setText("校企实训");
//    }

    public void init(){
        int labelIndex=0;
        JLabel[] lblCourses = new JLabel[]{lblCI1, lblCI2, lblCI3, lblCI4, lblCI5};
        String semester = "2020-2021-1";
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
                if(course.getSemester().equals(semester)){
                    String time = course.getTime();
                    String[] splitTime = time.split("-");
                    int day = Integer.parseInt(splitTime[0]);
                    if(day == 5){
                        lblCourses[labelIndex].setText(splitTime[1]+"~"+splitTime[2]+"："+course.getClassName()
                                +"，"+course.getClassroom());
                        lblCourses[labelIndex].setVisible(true);
                        labelIndex++;
                    }
                }
            }
        }
        if(labelIndex==0){
            lblCourses[0].setText("今天没有课");
            lblCourses[0].setVisible(true);
        }
    }
}
