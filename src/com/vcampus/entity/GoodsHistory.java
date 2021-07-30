package com.vcampus.entity;

import java.math.BigDecimal;

/**
 * 商品历史类
 * @author Franklin Yang
 * @date 2021/7/29
 */
public class GoodsHistory {
    public String id;
    public String dealTime;
    public int quantity;
    public BigDecimal price;

    public GoodsHistory(){}

    /**
     *
     * @param _id 购买的商品ID
     * @param _quantity 购买的商品数量
     * @param _price 购买的总价
     */
    public GoodsHistory(String _id,int _quantity,BigDecimal _price){
        this.id=_id;
        this.quantity=_quantity;
        this.price=_price;
    }
}
