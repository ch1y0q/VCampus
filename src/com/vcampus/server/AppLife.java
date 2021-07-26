package com.vcampus.server;

import com.vcampus.dao.IDealHistoryMapper;
import com.vcampus.dao.IStudentMapper;
import com.vcampus.entity.DealHistory;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppLife {
    public static BigDecimal chargeCard(HashMap map) {
        BigDecimal result = new BigDecimal(0);
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

            studentMapper.chargeCard(map);

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
            System.out.println(10);
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

    public static Boolean insertDealHistory(DealHistory dealHistory) {

        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IDealHistoryMapper dealHistoryMapper =sqlSession.getMapper(IDealHistoryMapper.class);

            dealHistoryMapper.insertDealHistory(dealHistory);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static List<DealHistory> getDealHistory(String cardNumber){
        List<DealHistory> list =new ArrayList<>();
        SqlSession sqlSession=null;
        try{
            sqlSession = App.sqlSessionFactory.openSession();
            IDealHistoryMapper dealHistoryMapper =sqlSession.getMapper(IDealHistoryMapper.class);

            //DealHistory dealHistory=new DealHistory();
            //dealHistory.cardNumber=cardNumber;

            list=dealHistoryMapper.getDealHistory(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }



}
