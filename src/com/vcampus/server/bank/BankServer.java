package com.vcampus.server.bank;

import com.vcampus.dao.IStudentMapper;
import com.vcampus.dao.ITeacherMapper;
import com.vcampus.server.App;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;

/**
 * 用于银行相关的服务器类。
 *
 * @author Huang Qiyue
 * @date 2021-07-26
 */
public class BankServer {
    /**
     * 按学生一卡通号查询余额
     *
     * @param cardNumber 学生的一卡通号
     * @return 学生的余额
     */
    public static BigDecimal getStudentBalance(String cardNumber) {
        BigDecimal result = new BigDecimal(0);
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

            result = studentMapper.getBalance(cardNumber);;

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 按教师一卡通号查询余额
     *
     * @param cardNumber 教师的一卡通号
     * @return 教师的余额
     */
    public static BigDecimal getTeacherBalance(String cardNumber) {
        BigDecimal result = new BigDecimal(0);
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper = sqlSession.getMapper(ITeacherMapper.class);

            result = teacherMapper.getBalance(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
