package com.vcampus.dao;

import com.vcampus.entity.Teacher;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一系列教师数据库操作的接口，用于mybatis的映射
 * @author Franklin Yang
 * @date 2021/7/14
 */
public interface ITeacherMapper {
    @Deprecated
    /**
     * 仅在密码明文存储可用。
     */
    public Boolean verifyTeacher(Teacher teacher);

    public Teacher getTeacherDetailByCardNumber(String cardNumber);

    public String getNameByCardNumber(String cardNumber);

    public String getPasswordByCardNumber(String cardNumber);

    public String getSaltByCardNumber(String cardNumber);

    public Boolean insertTeacher(Teacher teacher);

    public int deleteTeacher(String cardNumber);

    public Integer searchTeacherByCardNumber(String cardNumber);

    public Integer searchTeacherByTeacherNumber(String teacherNumber);

    //public int switchTeacher(Teacher teacher);

    //public List<Teacher> tableDisplay(Map map);

    public Boolean chargeCard(Map map);

    public BigDecimal getBalance(String cardNumber);

    public Boolean resetPassword(Map map);

    public BigDecimal setBalance(Map map);
}
