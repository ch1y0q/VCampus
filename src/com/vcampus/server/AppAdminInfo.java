package com.vcampus.server;

import com.vcampus.dao.IAdminMapper;
import com.vcampus.dao.IStudentMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

/**
 * 管理员修改个人信息
 * @author Dong Ruojing
 * @date 2021/7/29
 */
public class AppAdminInfo {
    //修改地址
    public static Boolean resetPhoneNumber(Map map){
        //Boolean result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IAdminMapper adminMapper = sqlSession.getMapper(IAdminMapper.class);
            adminMapper.resetPhoneNumber(map);
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
            IAdminMapper adminMapper = sqlSession.getMapper(IAdminMapper.class);
            adminMapper.resetEmail(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    //重设密码
    public static Boolean resetPassword(Map map) {

        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IAdminMapper adminMapper = sqlSession.getMapper(IAdminMapper.class);
            adminMapper.resetPassword(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
