package com.vcampus.entity;

import java.util.ArrayList;

/**
 * Book 类
 * @author Dong Ruojing
 * @date 2021-07-12
 */
public class Book implements java.io.Serializable{

    private String serialVersionUID ;   //ISBN号
    private String _name;                //书名
    private String _introduction;       //书介绍
    private String _number;             //剩余数量
    private String _author;              //作者
    private String _authorCountry;      //作者国籍
    private String _publishingHouse;    //出版社
    private String _tabs;    //分类
    private String _place;              //摆放位置
    private int chargable=1;
    private String borrower;
    private String _borrowTime;
    private String pictureURL;

    public Book() {
        setSerialVersionUID(null);
        setName(null);                    //设置书名
        setIntroduction(null);              //设置介绍
        setNumber(null);                   //设置剩余数量
        setAuthor(null);                    //设置作者
        setAuthorCountry(null);             //设置作者国籍
        setPublishingHouse(null);           //设置出版社
        setTabs(null);      //设置分类
        setPlace(null);                        //设置摆放位置
        setChargable(1);
        setBorrower(null);
        set_borrowTime(null);
        setPictureURL(null);
    }

    /* setters and getters */
    public String getSerialVersionUID(){return serialVersionUID;}
    public void setSerialVersionUID(String serialVersionUID1){this.serialVersionUID=serialVersionUID1;}

    public String getName() {
        return _name;
    }
    public void setName(String _name) {
        this._name = _name;
    }

    public String getIntroduction() {
        return _introduction;
    }
    public void setIntroduction(String _introduction) {
        this._introduction = _introduction;
    }

    public String getNumber() {
        return _number;
    }
    public void setNumber(String _number) {
        this._number = _number;
    }

    public String getAuthor() {
        return _author;
    }
    public void setAuthor(String _author) {
        this._author = _author;
    }

    public String getAuthorCountry() {
        return _authorCountry;
    }
    public void setAuthorCountry(String _authorCountry) {
        this._authorCountry = _authorCountry;
    }

    public String getPublishingHouse() {
        return _publishingHouse;
    }
    public void setPublishingHouse(String _publishingHouse) {
        this._publishingHouse = _publishingHouse;
    }

    public String getTabs() {
        return _tabs;
    }
    public void setTabs(String _tabs) {this._tabs = _tabs;}

    public String getPlace() {
        return _place;
    }
    public void setPlace(String _place) {
        this._place = _place;
    }

    public String getborrower(){return borrower;}
    public String get_borrowTime(){return _borrowTime ;}
    public String getpictureURL(){ return pictureURL;}

    public int getChargable() {
        return chargable;
    }
    public void setChargable(int chargable){this.chargable=chargable;}
    public void setBorrower(String borrower){this.borrower=borrower;}
    public void set_borrowTime(String _borrowTime){this._borrowTime=_borrowTime;}
    public void setPictureURL(String pictureURL){this.pictureURL=pictureURL;}
}
