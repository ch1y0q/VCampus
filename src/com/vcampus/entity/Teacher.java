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
    private String bankAccount;
    private BigDecimal balance;

    /* optional */
    private String email;
    private String school;
    private String teacherRank;
    private String homepage;
    private String phoneNumber;
    private String lossStatus;
    private String gender;

    /* constructor */

    public Teacher(){
        name = "";
        password = "";
        cardNumber = "";
        teacherNumber = "";
        bankAccount="";
        balance = new BigDecimal(0);
        lossStatus=null;
        school=null;
        teacherRank=null;
        gender=null;
        email=null;
        homepage=null;
        phoneNumber=null;
        bankAccount=null;
    }
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
    public String getSchoolByteacherNumber() {
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

    public String getBankAccount(){return bankAccount;}
    public void setBankAccount(String bankAccount){this.bankAccount=bankAccount;}

    public String getSchool(){return school;}
    public void setSchool(String school){this.school=school;}

    public String getTeacherRank(){return teacherRank;}
    public void setTeacherRank(String teacherRank){this.teacherRank=teacherRank;}

    public String getHomepage(){return homepage;}
    public void setHomepage(String homepage){this.homepage=homepage;}


    /* TODO getCourses()  返回该老师所有课程 */
}
