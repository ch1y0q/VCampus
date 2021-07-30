package com.vcampus.server;

import com.vcampus.util.JSONUtils;
import com.vcampus.util.StringUtils;
import org.apache.ibatis.session.SqlSession;
import com.vcampus.entity.*;
import com.vcampus.dao.IStudentMapper;
import com.vcampus.dao.ITeacherMapper;
import com.vcampus.dao.IAdminMapper;
import com.vcampus.server.App;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * 身份认证后端
 *
 * @author Huang Qiyue
 * @date 2021-07-09
 */

public class Auth {
    /** 用于学生登录使用的检查方法
     *
     * @param student 仅含userName和password（明文）Student
     * @return 登陆成功后返回从数据库读出的Student对象
     */
    public static Student studentLoginChecker(Student student) {
        Student result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            //boolean verifyResult = studentMapper.verifyStudent(student);

            String cardNumber = student.getCardNumber();
            boolean verifyResult =
                    StringUtils.MD5EncodeSalted(student.getPassword(), studentMapper.getSaltByCardNumber(cardNumber))
                            .equalsIgnoreCase(studentMapper.getPasswordByCardNumber(cardNumber));

            if (!verifyResult) {
                System.out.println("No result");
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

    /** 用于教师登录使用的检查方法
     *
     * @param teacher 仅含userName和password（明文）Teacher
     * @return 登陆成功后返回从数据库读出的Teacher对象
     */
    public static Teacher teacherLoginChecker(Teacher teacher) {
        Teacher result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper = sqlSession.getMapper(ITeacherMapper.class);
            //boolean verifyResult = teacherMapper.verifyTeacher(teacher);

            String cardNumber = teacher.getCardNumber();
            boolean verifyResult =
                    StringUtils.MD5EncodeSalted(teacher.getPassword(), teacherMapper.getSaltByCardNumber(cardNumber))
                            .equalsIgnoreCase(teacherMapper.getPasswordByCardNumber(cardNumber));

            if (!verifyResult) {
                System.out.println("No result");
                return null;
            }
            result = teacherMapper.getTeacherDetailByCardNumber(teacher.getCardNumber());
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /** 用于管理员登录使用的检查方法
     *
     * @param admin 仅含userName和password（明文）的Admin
     * @return 登陆成功后返回从数据库读出的Admin对象
     */
    public static Admin adminLoginChecker(Admin admin) {
        Admin result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            IAdminMapper adminMapper = sqlSession.getMapper(IAdminMapper.class);
            //boolean verifyResult = adminMapper.verifyAdmin(admin);
            String cardNumber = admin.getCardNumber();

            boolean verifyResult =
                    StringUtils.MD5EncodeSalted(admin.getPassword(), adminMapper.getSaltByCardNumber(cardNumber))
                            .equalsIgnoreCase(adminMapper.getPasswordByCardNumber(cardNumber));
            System.out.println(admin.getPassword());
            System.out.println(adminMapper.getSaltByCardNumber(cardNumber));
            System.out.println(adminMapper.getPasswordByCardNumber(cardNumber));

            if (!verifyResult) {
                System.out.println("No result");
                return null;
            }
            result = adminMapper.getAdminDetailByCardNumber(admin.getCardNumber());
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
