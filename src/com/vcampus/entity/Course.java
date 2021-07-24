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

    public Course() {
    }

    // 历史遗留问题
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getID() {
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

    public Course(String id, String courseName, String time, String teacher, String classroom, String teacherCard) {
        super();
        this.id = id;
        this.courseName = courseName;
        this.time = time;
        this.teacher = teacher;
        this.classroom = classroom;
        this.teacherCard = teacherCard;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", time=" + time + ", teacher=" + teacher
                + ", classroom=" + classroom + ", teacherCard=" + teacherCard + "]";
    }
}
