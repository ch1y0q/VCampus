package com.vcampus.net;

import com.vcampus.entity.*;

/**
 * 会话控制信息
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */

public class Session {
    private Student student = null;
    private Teacher teacher = null;
    private Admin admin = null;
    private UserType userType = null;

    public Student getStudent() {
        return student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Admin getAdmin() {
        return admin;
    }

    public UserType getUserType() {
        return userType;
    }

    public Session() {}

    public Session(Student student) {
        this.student = student;
        this.userType = UserType.STUDENT;
    }

    public Session(Teacher teacher) {
        this.teacher = teacher;
        this.userType = UserType.TEACHER;
    }

    public Session(Admin admin) {
        this.admin = admin;
        this.userType = UserType.ADMIN;
    }

    @Override
    public String toString() {
        return "Session [student=" + student + ", teacher=" + teacher + ", admin=" + admin + ", userType=" + userType
                + "]";
    }

}
