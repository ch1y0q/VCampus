package com.vcampus.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报修记录类
 *
 * @author Y
 * @date 2021-07-25
 */

public class RepairHistory {
    public String dormAddress;
    public String reportTime;
    public String reportContent;
    public String repairStatus;

    public RepairHistory(){}

    public RepairHistory(String _dormAddress,String _reportContent,String _repairStatus){
        dormAddress=_dormAddress;
        reportContent=_reportContent;
        repairStatus=_repairStatus;
    }

    public Boolean insertRepairHistory(){return true;}


}
