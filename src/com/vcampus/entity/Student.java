package com.vcampus.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static com.vcampus.util.CommonUtils.getSchoolByCode;

/**
 * 学生类
 *
 * @author Huang Qiyue
 * @date 2021-07-09
 */

public class Student {
    /* required */
    private String name;
    private String password;
    private String cardNumber;
    private String studentNumber;
    private BigDecimal balance;
    private List<String> courses;
    private String courseList;

    /* optional */
    private String school;
    private String email;
    private String phoneNumber;
    private String gender;
    public String bankAccount;
    private String lossStatus;
    public String dormAddress;

    /* constructor */
    public Student(){
        name = "";
        password = "";
        cardNumber = "";
        studentNumber = "";
        balance = new BigDecimal(0);
        courses = null;
        school=null;
        courseList=null;
        school=null;
        email=null;
        phoneNumber=null;
        gender=null;
        bankAccount=null;
        lossStatus=null;
        dormAddress=null;

    }
    public Student(String _cardNumber, String _password) {
        name = "";
        password = _password;
        cardNumber = _cardNumber;
        studentNumber = "";
        balance = new BigDecimal(0);
        courses = null;
    }
    public Student(String _cardNumber, String _password,String _school) {
        name = "";
        password = _password;
        cardNumber = _cardNumber;
        studentNumber = "";
        balance = new BigDecimal(0);
        courses = null;
        school=_school;
    }

    public Student(String _name, String _password, String _cardNumber, String _studentNumber, BigDecimal _balance, List<String> _courses) {
        name = _name;
        password = _password;
        cardNumber = _cardNumber;
        studentNumber = _studentNumber;
        balance = _balance;
        courses = _courses;
    }

    /* util */
    public String getSchoolByNumber() {
        String school = "";
        try {
            school = getSchoolByCode(studentNumber.substring(0, 2));
        }
        catch (Exception e){
        }
        return school;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school)
    {
        this.school=school;
    }
    /* getters and setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBankAccount(){return bankAccount;}

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getLossStatus(){return lossStatus;}

    public void setLossStatus(String lossStatus) {
        this.lossStatus=lossStatus;
    }

    public String getCourseList() {
        return courseList;
    }

    public void setCourseList(String courseList) {
        this.courseList = courseList;
    }

    public String getDormAddress(){return dormAddress;}

    public void setDormAddress(String dormAddress){this.dormAddress=dormAddress;}

    /* TODO getScore()  返回该学生某门课程的成绩
    *       dropCourse() 学生退课
    *       addCourse() 学生选课，检验冲突 */

}
