package com.vcampus.entity;

import java.util.List;

/**
 * @author Huang Qiyue
 * @date 2021-07-12
 */
public class Course {
    private String id;
    private String courseName;
    private String time;
    private String teacher;
    private String classroom;
    private String teacherCard;
    private String credit;
    private String semester;
    private String capacity;
    private String selectedNumber;
    private String major;
    private String students;

    public Course() {
    }

    // 历史遗留问题


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return courseName;
    }

    public void setClassName(String courseName) {
        this.courseName = courseName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Course(String id) {
        this.id = id;
    }

    public String getTeacherCard() {
        return teacherCard;
    }

    public void setTeacherCard(String teacherCard) {
        this.teacherCard = teacherCard;
    }

    public String getCredit() {return credit;}

    public void setCredit(String credit) {this.credit = credit;}

    public String getSemester() {return semester;}

    public void setSemester(String semester) {this.semester = semester;}

    public String getCapacity() { return capacity;}

    public void setCapacity(String capacity) {this.capacity = capacity;}

    public String getSelectedNumber() {return selectedNumber;}

    public void setSelectedNumber(String selectedNumber) {this.selectedNumber = selectedNumber;}

    public String getMajor() {return major;}

    public void setMajor(String major) {this.major = major;}

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    public Course(String id, String courseName, String time, String teacher, String classroom, String teacherCard
            , String credit, String capacity, String semester, String selectedNumber, String major,String students) {
        super();
        this.id = id;
        this.courseName = courseName;
        this.time = time;
        this.teacher = teacher;
        this.classroom = classroom;
        this.teacherCard = teacherCard;
        this.credit = credit;
        this.capacity = capacity;
        this.semester = semester;
        this.selectedNumber = selectedNumber;
        this.major = major;
        this.students=students;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", time=" + time + ", teacher=" + teacher
                + ", classroom=" + classroom + ", teacherCard=" + teacherCard +", credit=" + credit +", semester="+
                semester+", capacity="+capacity+", selectedNumber="+selectedNumber+", major="+major+", students="+students+"]";
    }
}
