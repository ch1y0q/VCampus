package com.vcampus.server;

import com.vcampus.dao.IStudentMapper;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 学生修改个人信息
 * @author Dong Ruojing
 * @date 2021/7/26
 */
public class AppStuInfo {
    //修改地址
        public static Boolean resetPhoneNumber(Map map){
        //Boolean result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            studentMapper.resetPhoneNumber(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    //修改电子邮箱
    public static Boolean resetEmail(Map map){
        //Boolean result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            studentMapper.resetEmail(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
