package com.vcampus.server.teaching;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vcampus.entity.*;
import com.vcampus.dao.ICourseMapper;
import com.vcampus.server.App;

/**
 * @author Franklin Yang
 * @date 2021/7/21
 */

public class CourseSelection {
    public static Boolean takeCourse(Student student, String newClassId) {
        SqlSession sqlSession = App.sqlSessionFactory.openSession();
        Boolean one = null, two = null;
        try {
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            one = courseMapper.takeCourse(student);
            String temp = courseMapper.getStudentOfOneCourse(newClassId);
            temp += student.getCardNumber();
            temp += "xxx,";
            Map<String, String> map = new HashMap<String, String>();
            map.put("classId", newClassId);
            map.put("content", temp);
            two = courseMapper.updateScoreOfOneCourse(map);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return Boolean.logicalAnd(one, two);
    }

    public static String getCourseSelection(Student student) {
        String result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            result = courseMapper.getCourseSelection(student);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Course getOneCourse(String ID) {
        Course result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            result = courseMapper.getOneCourse(ID);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Course> getClassOfOneTeacher(String name) {
        List<Course> result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            result = courseMapper.getCourseOfOneTeacher(name);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
