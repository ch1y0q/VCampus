package com.vcampus.dao;

import com.vcampus.entity.PersonWhoReport;
import com.vcampus.entity.Student;

/**
 * 这是一些每日上报的接口
 * @author Dong Ruojing
 * @date 2021/7/28
 */
public interface IPersonWhoReportMapper {
    public Boolean insertPerson(PersonWhoReport personWhoReport);

}
