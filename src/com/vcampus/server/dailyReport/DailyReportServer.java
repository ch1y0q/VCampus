package com.vcampus.server.dailyReport;

import com.vcampus.dao.IPersonWhoReportMapper;
import com.vcampus.dao.IStudentMapper;
import com.vcampus.entity.PersonWhoReport;
import com.vcampus.entity.Student;
import com.vcampus.server.App;
import org.apache.ibatis.session.SqlSession;

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
}
