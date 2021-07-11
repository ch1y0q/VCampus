package com.vcampus.entity;

import java.util.List;

import static com.vcampus.util.commonUtils.getSchoolByCode;

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
    private float balance;
    private List<String> courses;

    /* optional */
    private String email;
    private String phoneNumber;
    private String gender;

    /* constructor */
    public Student(String _name, String _password, String _cardNumber, String _studentNumber, float _balance, List<String> _courses) {
        name = _name;
        password = _password;
        cardNumber = _cardNumber;
        studentNumber = _studentNumber;
        balance = _balance;
        courses = _courses;
    }

    /* util */
    public String getSchool() {
        return getSchoolByCode(studentNumber.substring(0, 2));
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

    public void setPassword(String Password) {
        this.password = password;
    }

    public String setCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String setStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public float setBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> setCourses() {
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

    public String setPhoneNumber() {
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
}
