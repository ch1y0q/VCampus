package com.vcampus.server.teaching;

import com.vcampus.dao.IBookMapper;
import com.vcampus.dao.IStudentMapper;
import com.vcampus.net.Request;
import com.vcampus.util.ResponseUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

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
        Boolean one = null;
        try {
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
            String temp = courseMapper.getStudentOfOneCourse(newClassId);
            if(temp.equals("-")){
                temp="";
            }
            temp += student.getCardNumber();
            temp += ",";
            Map<String, String> map = new HashMap<String, String>();
            map.put("classId", newClassId);
            map.put("content", temp);
            one = courseMapper.updateScoreOfOneCourse(map);
            String cardNumber = student.getCardNumber();
            temp = courseMapper.getCourseSelection(student);
            if(temp.equals("-")){
                temp="";
            }
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
            CourseScore courseScore = new CourseScore(cardNumber,newClassId,"","首修");
            courseMapper.addLineInCourseScore(courseScore);
            course.setSelectedNumber(selectedNumber);
            courseMapper.setSelectedNumber(course);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return one;
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

    public static String getStudentOfOneCourse(String ID) {
        String result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            result = courseMapper.getStudentOfOneCourse(ID);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Course> getClassOfOneTeacher(String cardNumber) {
        List<Course> result = null;
        try {
            SqlSession sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            result = courseMapper.getCourseOfOneTeacher(cardNumber);
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

    public static String dropCourse(Student student ,String courseId){
        SqlSession sqlSession = App.sqlSessionFactory.openSession();
        ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
        IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
        String selectedCourses = courseMapper.getCourseSelection(student);
        System.out.println("sC= "+selectedCourses);
        String[] splitSelectedCourses = selectedCourses.split(",");
        String temp="";
        for(String s:splitSelectedCourses){
            if(!s.equals(courseId)){
                System.out.println("s= "+s+", cardNumber="+courseId);
                temp+=s;
                temp+=",";
            }
        }
        System.out.println(temp);
        String cardNumber = student.getCardNumber();
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("cardNumber",cardNumber);
        map2.put("content",temp);
        studentMapper.setSelectedCourses(map2);
        String selectedStudents = courseMapper.getStudentOfOneCourse(courseId);
        System.out.println("sS= "+selectedStudents);
        String[] splitSelectedStudents = selectedStudents.split(",");
        temp="";
        for(String s:splitSelectedStudents){
            if(!s.equals(cardNumber)){
                System.out.println("s= "+s+", cardNumber="+cardNumber);
                temp+=s;
                temp+=",";
            }
        }
        System.out.println(temp);
        Map<String, String> map = new HashMap<String, String>();
        map.put("classId",courseId);
        map.put("content",temp);
        CourseScore courseScore = new CourseScore(cardNumber,courseId,"","");
        courseMapper.deleteLineFromCourseScore(courseScore);
        courseMapper.updateScoreOfOneCourse(map);
        sqlSession.commit();
        sqlSession.close();
        return "ok";
    }

    public static List<Course> fuzzySearchById(String id) {
        List<Course> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            System.out.println("ID= "+id);
            sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
                list = courseMapper.fuzzySearchById(id);
                sqlSession.commit();
                sqlSession.close();
                return list;

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return list;
    }

    public static List<Course> fuzzySearchByName(String name) {
        List<Course> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            list = courseMapper.fuzzySearchByName(name);
            sqlSession.commit();
            sqlSession.close();
            return list;

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return list;
    }

    public static List<Course> fuzzySearchByMajor(String major) {
        List<Course> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            list = courseMapper.fuzzySearchByMajor(major);
            sqlSession.commit();
            sqlSession.close();
            return list;

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return list;
    }

    public static List<Course> fuzzySearchByTeacher(String teacher) {
        List<Course> list = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            list = courseMapper.fuzzySearchByTeacher(teacher);
            sqlSession.commit();
            sqlSession.close();
            return list;

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return list;
    }

    public static void setCourse(Course course){
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            courseMapper.setCourse(course);
            sqlSession.commit();
            sqlSession.close();

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
    }

    public static CourseScore getCourseScore(String studentCardNumber, String courseId){
        SqlSession sqlSession = null;
        CourseScore res = new CourseScore();
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            CourseScore courseScore = new CourseScore(studentCardNumber,courseId,"","");
            res=courseMapper.getCourseScore(courseScore);
            sqlSession.commit();
            sqlSession.close();
            return res;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
        return res;
    }

    public static void setScore(CourseScore courseScore){
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            courseMapper.setScore(courseScore);
            sqlSession.commit();
            sqlSession.close();

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
    }

    public static void addCourse(Course course){
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            courseMapper.insertNewCourse(course);
            String teacherCard = course.getTeacherCard();
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
    }

    public static void deleteCourse(String id){
        SqlSession sqlSession = null;
        try {
            sqlSession = App.sqlSessionFactory.openSession();
            ICourseMapper courseMapper = sqlSession.getMapper(ICourseMapper.class);
            courseMapper.deleteCourse(id);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
    }
}

