package com.vcampus.dao;

import com.vcampus.entity.GoodsHistory;

import java.math.BigDecimal;

/**
 * 一系列购物历史相关的接口
 *
 * @author Franklin Yang
 * @date 2021/7/29
 */
public interface IGoodsHistoryMapper {
    public void insertGoodsHistory(GoodsHistory goodsHistory);
    public int getMonthSum(int month);
    public BigDecimal getMonthSaleMoney(int month);
}
