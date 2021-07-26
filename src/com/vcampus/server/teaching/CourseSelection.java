package com.vcampus.server.teaching;

import com.vcampus.dao.IBookMapper;
import com.vcampus.dao.IStudentMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
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
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            one = courseMapper.takeCourse(student);
            String temp = courseMapper.getStudentOfOneCourse(newClassId);
            temp += student.getCardNumber();
            temp += "xxx,";
            Map<String, String> map = new HashMap<String, String>();
            map.put("classId", newClassId);
            map.put("content", temp);
            two = courseMapper.updateScoreOfOneCourse(map);
            String cardNumber = student.getCardNumber();
            temp = courseMapper.getCourseSelection(student);
            System.out.println(temp);
            temp+=newClassId;
            temp+=",";
            Map<String, String> map2 = new HashMap<String, String>();
            map2.put("cardNumber",cardNumber);
            map2.put("content",temp);
            studentMapper.setSelectedCourses(map2);
            Course course = courseMapper.getOneCourse(newClassId);
            String selectedNumber = course.getSelectedNumber();
            int sn = Integer.parseInt(selectedNumber);
            sn+=1;
            selectedNumber = Integer.toString(sn);
            course.setSelectedNumber(selectedNumber);
            courseMapper.setSelectedNumber(course);
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

    public static List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            list = courseMapper.getAllCourses();
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
