package com.vcampus.server;

import com.vcampus.dao.IDealHistoryMapper;
import com.vcampus.dao.IDormLifeMapper;
import com.vcampus.dao.IRepairHistoryMapper;
import com.vcampus.dao.IStudentMapper;
import com.vcampus.entity.DealHistory;
import com.vcampus.entity.RepairHistory;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Y
 * @date 2021/7/21
 * 学生生活服务的服务器端，通过调用接口实现修改数据库或获取数据库数据。各函数大同小异
 */

public class AppLife {
    @Deprecated
    // moved to BankServer
    public static BigDecimal chargeCard(HashMap map) {
        BigDecimal result = new BigDecimal(0);
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession(); //MyBatis提供的方法函数用于通信
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);//对应接口的实体

            studentMapper.chargeCard(map);//接口中的函数

            result = studentMapper.getBalance((String) map.get("cardNumber"));//返回值

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Deprecated
    // moved to BankServer
    public static BigDecimal setBalance(HashMap map) {
        BigDecimal result = new BigDecimal(0);
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

            studentMapper.setBalance(map);

            result = studentMapper.getBalance((String) map.get("cardNumber"));

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String lossJudge(String cardNumber){
        String curLossStatus="挂失";
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

            studentMapper.setLossStatusByCardNumber(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curLossStatus;
    }

    public static String foundJudge(String cardNumber){
        String curFoundStatus="正常";
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

            studentMapper.setFoundStatusByCardNumber(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curFoundStatus;
    }

    public static String getDormAddress(String cardNumber) {
        String dormAddress="ERROR";
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

            dormAddress=studentMapper.getDormAddress(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dormAddress;
    }

    public static Integer getDormHygieneMark(HashMap map){
        int hygienemark = 1000;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IDormLifeMapper dormLifeMapper=sqlSession.getMapper(IDormLifeMapper.class);

            hygienemark=dormLifeMapper.getHygieneMark(map);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hygienemark;
    }

    public static float getDormWaterRate(HashMap map) {
        float waterRate = 1000;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IDormLifeMapper dormLifeMapper = sqlSession.getMapper(IDormLifeMapper.class);

            waterRate = dormLifeMapper.getWaterRate(map);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return waterRate;
    }
        public static float getDormElectricityRate(HashMap map){
            float electricityRate = 1000;
            try {
                SqlSession sqlSession = App.sqlSessionFactory.openSession();
                IDormLifeMapper dormLifeMapper=sqlSession.getMapper(IDormLifeMapper.class);

                electricityRate=dormLifeMapper.getElectricityRate(map);

                sqlSession.commit();
                sqlSession.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return electricityRate;
    }

    public static Boolean insertRepairHistory(RepairHistory repairHistory) {

        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IRepairHistoryMapper repairHistoryMapper=sqlSession.getMapper(IRepairHistoryMapper.class);

            repairHistoryMapper.insertRepairHistory(repairHistory);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static List<RepairHistory> getRepairHistory(String dormAddress){
        List<RepairHistory> list =new ArrayList<>();
        SqlSession sqlSession=null;
        try{
            sqlSession = App.sqlSessionFactory.openSession();
            IRepairHistoryMapper repairHistoryMapper=sqlSession.getMapper(IRepairHistoryMapper.class);

            list=repairHistoryMapper.getRepairHistory(dormAddress);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static Boolean setDormHygieneMark(HashMap map) {
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IDormLifeMapper dormLifeMapper=sqlSession.getMapper(IDormLifeMapper.class);

            dormLifeMapper.setDormHygieneMark(map);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Boolean setDormWaterRate(HashMap map) {
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IDormLifeMapper dormLifeMapper=sqlSession.getMapper(IDormLifeMapper.class);

            dormLifeMapper.setDormWaterRate(map);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Boolean setDormElectricityRate(HashMap map) {
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IDormLifeMapper dormLifeMapper=sqlSession.getMapper(IDormLifeMapper.class);

            dormLifeMapper.setDormElectricityRate(map);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Boolean setRepairHistoryStatus(HashMap map) {
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IRepairHistoryMapper repairHistoryMapper=sqlSession.getMapper(IRepairHistoryMapper.class);

            repairHistoryMapper.setRepairHistoryStatus(map);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static String getBankAccountPassword(String cardNumber) {
        String bankAccountPassword="!ERROR!";
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

            bankAccountPassword=studentMapper.getBankAccountPassword(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bankAccountPassword;
    }

    public static String getBankAccountPasswordSalt(String cardNumber) {
        String bankAccountPasswordSalt="!ERROR!";
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

            bankAccountPasswordSalt=studentMapper.getBankAccountPasswordSalt(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bankAccountPasswordSalt;
    }


}
