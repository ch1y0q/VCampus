package com.vcampus.server;

import com.vcampus.dao.*;
import com.vcampus.entity.DealHistory;
import com.vcampus.entity.RepairHistory;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppLifeTeacherServer {

    public static String getCardStatus(String cardNumber) {
        String cardStatus="ERROR";
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper=sqlSession.getMapper(ITeacherMapper.class);

            cardStatus=teacherMapper.getCardStatus(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cardStatus;
    }

    public static String getBankAccountPassword(String cardNumber) {
        String bankAccountPassword="!ERROR!";
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper=sqlSession.getMapper(ITeacherMapper.class);

            bankAccountPassword=teacherMapper.getBankAccountPassword(cardNumber);

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
            ITeacherMapper teacherMapper=sqlSession.getMapper(ITeacherMapper.class);

            bankAccountPasswordSalt=teacherMapper.getBankAccountPasswordSalt(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bankAccountPasswordSalt;
    }

    public static BigDecimal getCardBalance(String cardNumber) {
        BigDecimal balance= BigDecimal.valueOf(0);
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper=sqlSession.getMapper(ITeacherMapper.class);

            balance=teacherMapper.getCardBalance(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    public static Boolean setCardBalance(HashMap map) {
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper=sqlSession.getMapper(ITeacherMapper.class);

            teacherMapper.setCardBalance(map);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public static Boolean setLossStatusLost(String cardNumber) {
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper=sqlSession.getMapper(ITeacherMapper.class);

            teacherMapper.setLossStatusLost(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Boolean setLossStatusNormal(String cardNumber) {
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper=sqlSession.getMapper(ITeacherMapper.class);

            teacherMapper.setLossStatusNormal(cardNumber);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
