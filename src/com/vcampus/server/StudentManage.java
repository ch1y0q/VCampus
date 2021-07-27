package com.vcampus.server;

import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.vcampus.dao.IStudentMapper;
import com.vcampus.entity.Student;

/**
 * 学生管理类
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class StudentManage {

    //通过一卡通号检索返回姓名
    public static String getNameByCardNumber(String cardNumber) {
        String result = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            result = studentMapper.getNameByCardNumber(cardNumber);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //新建学生
    public static Boolean insertStudent(Student student) {
        Boolean result = false;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            result = studentMapper.insertStudent(student);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

    //删除学生
    public static Boolean deleteStudent(String cardnumber) {
        Boolean result = false;
        SqlSession sqlSession = null;
        int ret = 0;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            ret = studentMapper.deleteStudent(cardnumber);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return (ret == 0 ? false : true);
    }

    //更新学生的学院和学号
    public static String switchStudent(String cardnumber, String academy, String studentnumber) {
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            int one = studentMapper.searchStudentByCardNumber(cardnumber);
            if (one == 0) {
                sqlSession.close();
                return "Nocard";
            }
            int two = studentMapper.searchStudentByStudentNumber(studentnumber);
            if (two == 1) {
                sqlSession.close();
                return "Repeat";
            }
            Student stut = new Student();
            //stut.setAcademy(academy);
            stut.setCardNumber(cardnumber);
            stut.setStudentNumber(studentnumber);
            int rows = studentMapper.switchStudent(stut);
            sqlSession.commit();
            sqlSession.close();
            if (rows == 0) {
                return "Nocard";
            } else {
                return "Ok";
            }
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return "...";
    }

    //显示某学院学生列表
    public static List<Student> tableDisplay(String academy, String grade) {
        List<Student> result = null;
        SqlSession sqlSession = null;
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("academy", academy);
        map.put("grade", grade);
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            result = studentMapper.tableDisplay(map);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //重设密码
    //TODO
    public static Boolean resetPassword(String cardNumber, String newPasswordMD5) {
        Boolean result = null;
        SqlSession sqlSession = null;
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("cardNumber", cardNumber);
        map.put("password", newPasswordMD5);
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            result = studentMapper.resetPassword(map);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Student> ByNameAndCardAndSchoolAndGender(String name, String cardNumber, String school, String gender) {
        List<Student> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            if (cardNumber == null&&school == null&&gender == null) {
                list = studentMapper.fuzzySearchByName(name);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && school == null && gender == null) {
                list = studentMapper.fuzzySearchByCard(cardNumber);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && cardNumber == null && gender == null) {
                list = studentMapper.fuzzySearchBySchool(school);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && cardNumber == null && school == null) {
                list = studentMapper.fuzzySearchByGender(gender);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (school == null && gender == null) {
                Student student = new Student();
                student.setName(name);
                student.setCardNumber(cardNumber);
                list = studentMapper.fuzzySearchByNameAndCard(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (cardNumber == null && gender == null) {
                Student student = new Student();
                student.setName(name);
                student.setSchool(school);
                list = studentMapper.fuzzySearchByNameAndSchool(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (cardNumber == null && school == null) {
                Student student = new Student();
                student.setName(name);
                student.setGender(gender);
                list = studentMapper.fuzzySearchByNameAndGender(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && gender == null) {
                Student student = new Student();
                student.setCardNumber(cardNumber);
                student.setSchool(school);
                list = studentMapper.fuzzySearchByCardAndSchool(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && school == null) {
                Student student = new Student();
                student.setCardNumber(cardNumber);
                student.setGender(gender);
                list = studentMapper.fuzzySearchByCardAndGender(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && cardNumber == null) {
                Student student = new Student();
                student.setSchool(school);
                student.setGender(gender);
                list = studentMapper.fuzzySearchBySchoolAndGender(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (gender==null) {
                Student student = new Student();
                student.setName(name);
                student.setCardNumber(cardNumber);
                student.setSchool(school);
                list = studentMapper.fuzzySearchByNameAndCardAndSchool(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (school==null) {
                Student student = new Student();
                student.setName(name);
                student.setCardNumber(cardNumber);
                student.setGender(gender);
                list = studentMapper.fuzzySearchByNameAndCardAndGender(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name==null) {
                Student student = new Student();
                student.setCardNumber(cardNumber);
                student.setSchool(school);
                student.setGender(gender);
                list = studentMapper.fuzzySearchByCardAndSchoolAndGender(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if(cardNumber==null)
            {
                Student student = new Student();
                student.setName(name);
                student.setSchool(school);
                student.setGender(gender);
                list = studentMapper.fuzzySearchByNameAndSchoolAndGender(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else {
                Student student = new Student();
                student.setName(name);
                student.setCardNumber(cardNumber);
                student.setSchool(school);
                student.setGender(gender);
                list = studentMapper.fuzzySearchByNameAndCardAndSchoolAndGender(student);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return list;
    }
}
