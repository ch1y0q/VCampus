package com.vcampus.server;
import org.apache.ibatis.session.SqlSession;
import com.vcampus.entity.*;
import com.vcampus.dao.IStudentMapper;


/**
 * 身份认证后端
 *
 * @author Huang Qiyue
 * @date 2021-07-09
 */

public class Auth {
    public static Student studentLoginChecker(Student student) {
        Student result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            Boolean verifyResult = studentMapper.verifyStudent(student);
            if (!verifyResult) {
                return null;
            }
            result = studentMapper.getStudentDetailByCardNumber(student.getCardNumber());
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    //TODO

}
