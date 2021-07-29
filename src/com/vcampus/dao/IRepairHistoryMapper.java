package com.vcampus.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.vcampus.entity.RepairHistory;

/**
 * 参见IStudentMapper
 *
 * @author Y
 * @date 2021/7/22
 */

public interface IRepairHistoryMapper {

    public void insertRepairHistory(RepairHistory repairHistory);

    public List<RepairHistory> getRepairHistory(String dormAddress);

    public void setRepairHistoryStatus(Map map);
}
