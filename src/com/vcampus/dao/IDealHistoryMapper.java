package com.vcampus.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.vcampus.entity.DealHistory;

public interface IDealHistoryMapper {

    public void insertDealHistory(DealHistory dealHistory);

    public DealHistory getDealHistory(DealHistory dealHistory);
}
