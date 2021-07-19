package com.vcampus.entity;

import java.util.Date;

/**
 * 商店购物记录
 * @author Dong Ruojing
 * @date 2021/7/18
 */
public class ShopRecord implements java.io.Serializable{

    private static final long serialVersionUID = -509549707109918867L;
    private int _CardNumber;//一卡通号
    private int _GoodsID;//商品编号
    private int _GoodsNumber;//购买数量
    private Date _time;//购买时间

    public int getEcardNumber() {
        return _CardNumber;
    }
    public void setEcardNumber(int _CardNumber) {
        this._CardNumber = _CardNumber;
    }
    public int getGoodsID() {
        return _GoodsID;
    }
    public void setGoodsID(int _GoodsID) {
        this._GoodsID = _GoodsID;
    }
    public int getGoodsNumber() {
        return _GoodsNumber;
    }
    public void setGoodsNumber(int _GoodsNumber) {
        this._GoodsNumber = _GoodsNumber;
    }
    public Date getTime() {
        return _time;
    }
    public void setTime(Date _time) {
        this._time = _time;
    }
}
