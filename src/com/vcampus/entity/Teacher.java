package com.vcampus.entity;

import java.math.BigDecimal;

import static com.vcampus.util.CommonUtils.getSchoolByCode;

/**
 * @author Huang Qiyue
 * @date 2021-07-12
 */
public class Teacher {
    /* required */
    private String name;
    private String password;
    private String cardNumber;
    private String teacherNumber;
    private BigDecimal balance;

    /* optional */
    private String email;
    private String phoneNumber;
    private String gender;

    /* constructor */
    public Teacher(String _cardNumber, String _password) {
        name = "";
        password = _password;
        cardNumber = _cardNumber;
        teacherNumber="";
        balance = new BigDecimal(0);
    }

    public Teacher(String _name, String _password, String _cardNumber, BigDecimal _balance) {
        name = _name;
        password = _password;
        cardNumber = _cardNumber;
        balance = _balance;
    }

    /* util */
    public String getSchool() {
        String school = "";
        try {
            school = getSchoolByCode(teacherNumber.substring(0, 2));
        } catch (Exception e) {
        }
        return school;
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

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    /* TODO getCourses()  返回该老师所有课程 */
}
