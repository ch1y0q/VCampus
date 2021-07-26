package com.vcampus.entity;

/**
 * Book 类
 * @author Dong Ruojing
 * @date 2021-07-12
 */
public class Book implements java.io.Serializable{

    private String serialVersionUID ;   //ISBN号
    private String name;                //书名
    private String introduction;       //书介绍
    private int number;             //剩余数量
    private String author;              //作者
    private String authorCountry;      //作者国籍
    private String publishingHouse;    //出版社
    private String tabs;    //分类
    private String place;              //摆放位置
    private int chargable=1;
    private String borrower;
    private String borrowTime;
    private String pictureURL;
    private String srTime;

    public Book() {
        setSerialVersionUID(null);
        setName(null);                    //设置书名
        setIntroduction(null);              //设置介绍
        setNumber(0);                   //设置剩余数量
        setAuthor(null);                    //设置作者
        setAuthorCountry(null);             //设置作者国籍
        setPublishingHouse(null);           //设置出版社
        setTabs(null);      //设置分类
        setPlace(null);                        //设置摆放位置
        setChargable(1);
        setBorrower(null);
        setBorrowTime(null);
        setPictureURL(null);
        setsrTime(null);
    }

    /* setters and getters */
    public String getSerialVersionUID(){return serialVersionUID;}
    public void setSerialVersionUID(String serialVersionUID){this.serialVersionUID=serialVersionUID;}

    public String getName() {
        return name;
    }
    public void setName(String _name) {
        this.name = _name;
    }

    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String _introduction) {
        this.introduction = _introduction;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int _number) {
        this.number = _number;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String _author) {
        this.author = _author;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }
    public void setAuthorCountry(String _authorCountry) {
        this.authorCountry = _authorCountry;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }
    public void setPublishingHouse(String _publishingHouse) {
        this.publishingHouse = _publishingHouse;
    }

    public String getTabs() {
        return tabs;
    }
    public void setTabs(String _tabs) {this.tabs = _tabs;}

    public String getPlace() {
        return place;
    }
    public void setPlace(String _place) {
        this.place = _place;
    }

    public String getborrower(){return borrower;}
    public String getBorrowTime(){return borrowTime;}
    public String getpictureURL(){ return pictureURL;}
    public String getSrTime(){return srTime;}
    public void setsrTime(String srTime){this.srTime=srTime;}

    public int getChargable() {
        return chargable;
    }
    public void setChargable(int chargable){this.chargable=chargable;}
    public void setBorrower(String borrower){this.borrower=borrower;}
    public void setBorrowTime(String borrowTime){this.borrowTime = borrowTime;}
    public void setPictureURL(String pictureURL){this.pictureURL=pictureURL;}

}
