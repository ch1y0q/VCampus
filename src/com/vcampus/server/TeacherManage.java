package com.vcampus.server;

import com.vcampus.dao.ITeacherMapper;
import com.vcampus.entity.Teacher;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 教师管理后端API
 * @author Xiao Kaijie
 * @date 2021-07-19
 */
public class TeacherManage {
    public static Teacher getTeacherDetailByCardNumber(String cardNumber) {
        Teacher result = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper = sqlSession.getMapper(ITeacherMapper.class);
            result = teacherMapper.getTeacherDetailByCardNumber(cardNumber);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean insertTeacher(Teacher teacher) {
        Boolean result = false;
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper = sqlSession.getMapper(ITeacherMapper.class);
            result = teacherMapper.insertTeacher(teacher);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean deleteTeacher(String cardnumber) {
        Boolean result = false;
        SqlSession sqlSession = null;
        int ret = 0;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper = sqlSession.getMapper(ITeacherMapper.class);
            ret = teacherMapper.deleteTeacher(cardnumber);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return (ret == 0 ? false : true);
    }

    public static Boolean resetTeacherNumberByCard(Map map){
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper = sqlSession.getMapper(ITeacherMapper.class);
            teacherMapper.resetTeacherNumberByCard(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Boolean resetSchoolByCard(Map map){
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper = sqlSession.getMapper(ITeacherMapper.class);
            teacherMapper.resetSchoolByCard(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public static Boolean resetTeacherRankByCard(Map map){
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper = sqlSession.getMapper(ITeacherMapper.class);
            teacherMapper.resetTeacherRankByCard(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public static List<Teacher> ByNameAndCardAndSchoolAndGender(String name, String cardNumber, String school, String gender) {
        List<Teacher> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ITeacherMapper teacherMapper = sqlSession.getMapper(ITeacherMapper.class);
            if (cardNumber == null&&school == null&&gender == null) {
                list = teacherMapper.fuzzySearchByName(name);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && school == null && gender == null) {
                list = teacherMapper.fuzzySearchByCard(cardNumber);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && cardNumber == null && gender == null) {
                list =teacherMapper.fuzzySearchBySchool(school);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && cardNumber == null && school == null) {
                list = teacherMapper.fuzzySearchByGender(gender);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (school == null && gender == null) {
                Teacher teacher = new Teacher();
                teacher.setName(name);
                teacher.setCardNumber(cardNumber);
                list = teacherMapper.fuzzySearchByNameAndCard(teacher);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (cardNumber == null && gender == null) {
                Teacher teacher = new Teacher();
                teacher.setName(name);
                teacher.setSchool(school);
                list = teacherMapper.fuzzySearchByNameAndSchool(teacher);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (cardNumber == null && school == null) {
                Teacher teacher = new Teacher();
                teacher.setName(name);
                teacher.setGender(gender);
                list = teacherMapper.fuzzySearchByNameAndGender(teacher);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && gender == null) {
                Teacher teacher = new Teacher();
                teacher.setCardNumber(cardNumber);
                teacher.setSchool(school);
                list = teacherMapper.fuzzySearchByCardAndSchool(teacher);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && school == null) {
                Teacher teacher = new Teacher();
                teacher.setCardNumber(cardNumber);
                teacher.setGender(gender);
                list = teacherMapper.fuzzySearchByCardAndGender(teacher);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name == null && cardNumber == null) {
                Teacher teacher = new Teacher();
                teacher.setSchool(school);
                teacher.setGender(gender);
                list = teacherMapper.fuzzySearchBySchoolAndGender(teacher);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (gender==null) {
                Teacher teacher = new Teacher();
                teacher.setName(name);
                teacher.setCardNumber(cardNumber);
                teacher.setSchool(school);
                list = teacherMapper.fuzzySearchByNameAndCardAndSchool(teacher);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (school==null) {
                Teacher teacher = new Teacher();
                teacher.setName(name);
                teacher.setCardNumber(cardNumber);
                teacher.setGender(gender);
                list = teacherMapper.fuzzySearchByNameAndCardAndGender(teacher);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if (name==null) {
                Teacher teacher = new Teacher();
                teacher.setCardNumber(cardNumber);
                teacher.setSchool(school);
                teacher.setGender(gender);
                list = teacherMapper.fuzzySearchByCardAndSchoolAndGender(teacher);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else if(cardNumber==null)
            {
                Teacher teacher = new Teacher();
                teacher.setName(name);
                teacher.setSchool(school);
                teacher.setGender(gender);
                list = teacherMapper.fuzzySearchByNameAndSchoolAndGender(teacher);
                sqlSession.commit();
                sqlSession.close();
                return list;
            }
            else {
                Teacher teacher = new Teacher();
                teacher.setName(name);
                teacher.setCardNumber(cardNumber);
                teacher.setSchool(school);
                teacher.setGender(gender);
                list = teacherMapper.fuzzySearchByNameAndCardAndSchoolAndGender(teacher);
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
