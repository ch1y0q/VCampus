package com.vcampus.entity;

import java.math.BigDecimal;

/**
 * 商品类
 * @author Dong Ruojing
 * @date 2021/7/18
 */
public class Goods {
    //private static final long serialVersionUID = -1628627823619818674L;
    private int id;//商品编号
    private int remaining;//商品剩余数量
    private String name;//商品名称
    private BigDecimal price;//商品价格
    private String pic;//图片文件名
    private String description;//商品简介
    private String status;//商品状态，上架、下架

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getRemaining() {
        return remaining;
    }
    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
