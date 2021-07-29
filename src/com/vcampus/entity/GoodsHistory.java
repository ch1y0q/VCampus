package com.vcampus.entity;

import java.math.BigDecimal;

/**
 * @author Franklin Yang
 * @date 2021/7/29
 */
public class GoodsHistory {
    public String id;
    public String dealTime;
    public int quantity;
    public BigDecimal price;

    public GoodsHistory(){}
    public GoodsHistory(String _id,int _quantity,BigDecimal _price){
        this.id=_id;
        this.quantity=_quantity;
        this.price=_price;
    }
}
