package com.vcampus.entity;

/**
 * 商品类
 * @author Dong Ruojing
 * @date 2021/7/18
 */
public class Goods {
    //private static final long serialVersionUID = -1628627823619818674L;
    private int _ID;//商品编号
    private int _number;//商品剩余数量
    private String _name;//商品名称
    private double _price;//商品价格
    private String _picturePath;//图片
    private String _content;//商品简介
    private boolean _state;//商品状态，上架、下架

    public double getPrice() {
        return _price;
    }
    public void setPrice(double _price) {
        this._price = _price;
    }
    public String getPicturePath() {
        return _picturePath;
    }
    public void setPicturePath(String _picturePath) {
        this._picturePath = _picturePath;
    }
    public String getContent() {
        return _content;
    }
    public void setContent(String _content) {
        this._content = _content;
    }
    public int getID() {
        return _ID;
    }
    public void setID(int _ID) {
        this._ID = _ID;
    }
    public int getNumber() {
        return _number;
    }
    public void setNumber(int _number) {
        this._number = _number;
    }
    public String getName() {
        return _name;
    }
    public void setName(String _name) {
        this._name = _name;
    }
    public boolean getState() {
        return _state;
    }
    public void setState(boolean _state) {
        this._state = _state;
    }
}
