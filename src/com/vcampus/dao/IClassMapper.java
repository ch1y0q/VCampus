package com.vcampus.dao;

import com.vcampus.entity.ClassInfo;
import com.vcampus.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author Franklin Yang
 * @date 2021/7/21
 */

public interface IClassMapper {
    public List<ClassInfo> getClassInfo(String academy);

    public Boolean takeClass(Student student);

    public String getClassSelection(Student student);

    public ClassInfo getOneClass(String iD);

    public List<ClassInfo> getClassOfOneTeacher(String card);

    public Boolean insertNewCourse(ClassInfo classInfo);

    public Boolean deleteCourse(String id);

    public String getStudentOfOneClass(String classId);

    public Boolean updateScoreOfOneClass(Map map);
}
