package com.vcampus.entity;

import java.math.BigDecimal;

/**
 * 商品类
 *
 * @author Dong Ruojing
 * @date 2021/7/18
 */
public class Goods {
    //private static final long serialVersionUID = -1628627823619818674L;
    private int id;//商品编号
    private String name;//商品名称
    private String category;//商品分类
    private BigDecimal price;//商品价格
    private String pic;//图片文件名
    private int remaining;//商品剩余数量
    private String description;//商品简介
    private String status;//商品状态，上架、下架

    /* constructors */
    /**
     * 完整的构造函数
     * @param _id 商品编号
     * @param _name 商品名称
     * @param _category 商品类别
     * @param _price 商品单价
     * @param _pic 商品图片文件名
     * @param _remaining 剩余数量
     * @param _description 商品描述
     * @param _status 库存状态
     */
    public Goods(int _id, String _name, String _category,
                 BigDecimal _price, String _pic, int _remaining, String _description, String _status) {
        id = _id;
        remaining = _remaining;
        name = _name;
        category = _category;
        price = _price;
        description = _description;
        pic = _pic;
        status = _status;
    }

    /*
    /**
     * 不含id参数的构造函数
     * @param _name 商品名称
     * @param _remaining 剩余数量
     * @param _category 商品类别
     * @param _price 商品单价
     * @param _description 商品描述
     * @param _pic 商品图片文件名
     * @param _status 库存状态
    */

    public Goods(String _name, String _category,
                 BigDecimal _price, String _pic, int _remaining, String _description, String _status) {
        id = 0;
        remaining = _remaining;
        name = _name;
        category = _category;
        price = _price;
        description = _description;
        pic = _pic;
        status = _status;
    }

    /* getters and setters */
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
