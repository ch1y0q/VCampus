package com.vcampus.entity;

/**
 * Book 类
 * @author Dong Ruojing
 * @date 2021-07-12
 */
public class Book implements java.io.Serializable{

    private String ISBN;   //ISBN号
    private String _name;                //书名
    private String _introduction;       //书介绍
    private int _number;             //剩余数量
    private String _author;              //作者
    private String _authorCountry;      //作者国籍
    private String _publishingHouse;    //出版社
    private String _tabs;    //分类
    private String _place;              //摆放位置
    private int chargable=1;            //是否可借
    private String borrower;//借阅者
    private String borrowtime;//借阅时间
    private String pictureURL;//图片地址
    private String srTime;//应还时间

    public Book() {
        setISBN(null);
        setName(null);                    //设置书名
        setIntroduction(null);              //设置介绍
        setNumber(0);                   //设置剩余数量
        setAuthor(null);                    //设置作者
        setAuthorCountry(null);             //设置作者国籍
        setPublishingHouse(null);           //设置出版社
        setTabs(null);      //设置分类
        setPlace(null);                        //设置摆放位置
        setChargable(1);//设置可借
        setBorrower(null);//设置借阅者
        setBorrowtime(null);//设置借阅时间
        setPictureURL(null);//设置图片地址
        setsrTime(null);//设置应还时间
    }

    public Book(String ISBN, String _name, String _introduction, int _number, String _author, String _authorCountry, String _publishingHouse, String _tabs, String _place, int chargable, String borrower, String borrowtime, String pictureURL, String srTime)
    {
        super();
        this.ISBN = ISBN;
        this._name=_name;
        this._introduction=_introduction;
        this._number=_number;
        this._author=_author;
        this._authorCountry=_authorCountry;
        this._publishingHouse=_publishingHouse;
        this._tabs=_tabs;
        this._place=_place;
        this.chargable=chargable;
        this.borrower=borrower;
        this.borrowtime = borrowtime;
        this.pictureURL=pictureURL;
        this.srTime=srTime;
    }

    /* setters and getters */
    public String getISBN(){return ISBN;}
    public void setISBN(String ISBN){this.ISBN = ISBN;}


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

    public int getNumber() {
        return _number;
    }
    public void setNumber(int _number) {
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
    public String getBorrowtime(){return borrowtime;}
    public String getpictureURL(){ return pictureURL;}
    public String getSrTime(){return srTime;}
    public void setsrTime(String srTime){this.srTime=srTime;}

    public int getChargable() {
        return chargable;
    }
    public void setChargable(int chargable){this.chargable=chargable;}
    public void setBorrower(String borrower){this.borrower=borrower;}
    public void setBorrowtime(String borrowtime){this.borrowtime = borrowtime;}
    public void setPictureURL(String pictureURL){this.pictureURL=pictureURL;}

}
