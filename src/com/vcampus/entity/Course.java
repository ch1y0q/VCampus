package com.vcampus.entity;

import java.util.List;

/**
 * @author Huang Qiyue
 * @date 2021-07-12
 */
public class Course {
    /* required */
    private String name;
    private List<String> semesters;
    private int capacity;
    private float credit;


    /* optional */
    private List<Student> students;
    private Teacher teacher;
    private List<String> routineTime;
    private String category;

    /* constructor */
    public Course(String _name, List<String> _semesters, int _capacity, float _credit) {
        name = _name;
        semesters = _semesters;
        capacity = _capacity;
        credit = _credit;
    }

    /* TODO getters and setters */
}
