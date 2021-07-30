package com.vcampus.dao;

import com.vcampus.entity.GoodsHistory;

import java.math.BigDecimal;

/**
 * @author Franklin Yang
 * @date 2021/7/29
 */
public interface IGoodsHistoryMapper {
    public void insertGoodsHistory(GoodsHistory goodsHistory);
    public int getMonthSum(int month);
    public BigDecimal getMonthSaleMoney(int month);
}
