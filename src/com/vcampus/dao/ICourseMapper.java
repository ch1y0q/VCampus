package com.vcampus.dao;

import com.vcampus.entity.Course;
import com.vcampus.entity.CourseScore;
import com.vcampus.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author Franklin Yang
 * @date 2021/7/21
 */

public interface ICourseMapper {
    public List<Course> getCourse(String academy);

    public Boolean takeCourse(Student student);

    public String getCourseSelection(Student student);

    public Course getOneCourse(String id);

    public List<Course> getCourseOfOneTeacher(String card);

    public Boolean insertNewCourse(Course course);

    public Boolean deleteCourse(String id);

    public String getStudentOfOneCourse(String id);

    public Boolean updateScoreOfOneCourse(Map map);

    public void setSelectedNumber(Course course);

    public List<Course> getAllCourses();

    public List<Course> fuzzySearchById(String id);

    public List<Course> fuzzySearchByName(String name);

    public List<Course> fuzzySearchByMajor(String major);

    public List<Course> fuzzySearchByTeacher(String teacher);

    public void setCourse(Course course);

    public void addLineInCourseScore(CourseScore courseScore);

    public CourseScore getCourseScore(CourseScore courseScore);

    public void setScore(CourseScore courseScore);

    public void deleteLineFromCourseScore(CourseScore courseScore);


}
