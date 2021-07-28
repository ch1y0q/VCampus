package com.vcampus.entity;

import java.util.Date;

/**
 * @author Dong Ruojing
 * @date 2021/7/28
 */
public class PersonWhoReport {
    private int idReport;
    private String personName;
    private String cardNumber;
    private String school;
    private double temperature;
    private Date date;//上报日期
    private String location;//是否在校区
    private String city;//不在校区时所在城市
    private String campus;//校区
    private String ifQarantined;//是否被隔离
    private String ifSuspected;//是否疑似病例
    private String ifDefinite;//是否确诊
    private String ifHistoryOfRiskyArea;//是否到过风险区

    public PersonWhoReport(){
        idReport=1;
        cardNumber = "";
        personName = "";
        school="计算机科学与工程学院";
        date= new Date();
        temperature=37.0;
        location="在校区";
        city="";
        campus="";
        ifQarantined="";
        ifSuspected="";
        ifDefinite="";
        ifHistoryOfRiskyArea="";
    }
    public int getIdReport() {
        return idReport;
    }
    public void setIdReport(int idReport)
    {
        this.idReport=idReport;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school)
    {
        this.school=school;
    }
    public String getName() {
        return personName;
    }
    public void setName(String name) {
        this.personName = name;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature)
    {
        this.temperature=temperature;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date)
    {
        this.date=date;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) { this.location=location; }
    public String getCity() {
        return city;
    }
    public void setCity(String city)
    {
        this.city=city;
    }
    public String getCampus() {
        return campus;
    }
    public void setCampus(String campus)
    {
        this.campus=campus;
    }
    public String getIfQarantined() {
        return ifQarantined;
    }
    public void setIfQarantined(String ifQarantined)
    {
        this.ifQarantined=ifQarantined;
    }
    public String getIfSuspected() {
        return ifSuspected;
    }
    public void setIfSuspected(String ifSuspected)
    {
        this.ifSuspected=ifSuspected;
    }
    public String getIfDefinite() {
        return ifDefinite;
    }
    public void setIfDefinite(String ifDefinite)
    {
        this.ifDefinite=ifDefinite;
    }
    public String getIfHistoryOfRiskyArea() {
        return ifHistoryOfRiskyArea;
    }
    public void setIfHistoryOfRiskyArea(String ifHistoryOfRiskyArea)
    {
        this.ifHistoryOfRiskyArea=ifHistoryOfRiskyArea;
    }
}
