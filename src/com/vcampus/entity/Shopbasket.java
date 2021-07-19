package com.vcampus.entity;

/**
 * 购物车类
 * @author Dong Ruojing
 * @date 2021/7/18
 */
public class Shopbasket implements java.io.Serializable{

    private static final long serialVersionUID = -3592076712701704097L;
    private int _goodID;//商品编号
    private int _goodNumber;//选择购买数量
    public int getGoodID() {
        return _goodID;
    }
    public void setGoodID(int _goodID) {
        this._goodID = _goodID;
    }
    public int getGoodNumber() {
        return _goodNumber;
    }
    public void setGoodNumber(int _goodNumber) {
        this._goodNumber = _goodNumber;
    }
}