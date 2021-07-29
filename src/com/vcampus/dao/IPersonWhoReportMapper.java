package com.vcampus.dao;

import com.vcampus.entity.PersonWhoReport;
import com.vcampus.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * 这是一些每日上报的接口
 * @author Dong Ruojing
 * @date 2021/7/28
 */
public interface IPersonWhoReportMapper {
    public Boolean insertPerson(PersonWhoReport personWhoReport);
    public List<PersonWhoReport> tableDisplayBySchool(String school);//按照学院显示
    public List<PersonWhoReport> tableDisplay();//全部显示
}
