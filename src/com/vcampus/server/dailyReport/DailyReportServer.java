package com.vcampus.server.dailyReport;

import com.vcampus.dao.IPersonWhoReportMapper;
import com.vcampus.dao.IStudentMapper;
import com.vcampus.entity.PersonWhoReport;
import com.vcampus.entity.Student;
import com.vcampus.server.App;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Dong Ruojing
 * @date 2021/7/28
 */
public class DailyReportServer {

    //上传上报信息
    public static Boolean insertPerson(PersonWhoReport personWhoReport) {
        Boolean result = false;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IPersonWhoReportMapper personWhoReportMapper = sqlSession.getMapper(IPersonWhoReportMapper.class);
            result = personWhoReportMapper.insertPerson(personWhoReport);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }


    //根据学院显示表格
    public static java.util.List<PersonWhoReport> tableDisplayBySchool(String school) {
        List<PersonWhoReport> result = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IPersonWhoReportMapper personWhoReportMapper = sqlSession.getMapper(IPersonWhoReportMapper.class);
            result = personWhoReportMapper.tableDisplayBySchool(school);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }
    //显示表格
    public static List<PersonWhoReport> tableDisplay() {
        List<PersonWhoReport> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IPersonWhoReportMapper personWhoReportMapper = sqlSession.getMapper(IPersonWhoReportMapper.class);
            list = personWhoReportMapper.tableDisplay();
            sqlSession.commit();
            sqlSession.close();
            return list;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return list;
    }
}
