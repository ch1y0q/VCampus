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
    private String isQuarantined;//是否被隔离
    private String isSuspected;//是否疑似病例
    private String isDefinite;//是否确诊
    private String isHistoryOfRiskyArea;//是否到过风险区

    public PersonWhoReport(){
       // idReport=1;
        cardNumber = "";
        personName = "";
        school="计算机科学与工程学院";
        date= new Date();
        temperature=37.0;
        location="在校区";
        city="";
        campus="";
        isQuarantined ="";
        isSuspected ="";
        isDefinite ="";
        isHistoryOfRiskyArea ="";
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
    public String getIsQuarantined() {
        return isQuarantined;
    }
    public void setIsQuarantined(String isQuarantined)
    {
        this.isQuarantined = isQuarantined;
    }
    public String getIsSuspected() {
        return isSuspected;
    }
    public void setIsSuspected(String isSuspected)
    {
        this.isSuspected = isSuspected;
    }
    public String getIsDefinite() {
        return isDefinite;
    }
    public void setIsDefinite(String isDefinite)
    {
        this.isDefinite = isDefinite;
    }
    public String getIsHistoryOfRiskyArea() {
        return isHistoryOfRiskyArea;
    }
    public void setIsHistoryOfRiskyArea(String isHistoryOfRiskyArea)
    {
        this.isHistoryOfRiskyArea = isHistoryOfRiskyArea;
    }
}
