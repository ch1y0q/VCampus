package com.vcampus.dao;

import java.util.List;
import java.util.Map;

import com.vcampus.entity.Student;

/**
 * 一系列学生数据库操作的接口，用于mybatis的映射
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */

public interface IStudentMapper {

    public Boolean verifyStudent(Student student);

    public Student getStudentDetailByCardNumber(String cardNumber);

    public String getNameByCardNumber(String cardNumber);

    public String getPasswordByUsername(String cardNumber);

    public Boolean insertStudent(Student student);

    public int deleteStudent(String cardNumber);

    public Integer searchStudentByCardNumber(String cardNumber);

    public Integer searchStudentByStudentNumber(String studentNumber);

    public int switchStudent(Student student);

    public List<Student> tableDisplay(Map map);

    public Boolean chargeCard(Map map);

    public String getBalance(String cardNumber);

    public Boolean resetPassword(Map map);
}
