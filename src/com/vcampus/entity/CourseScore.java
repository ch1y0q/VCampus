package com.vcampus.entity;

/**
 * 课程成绩实体类
 */
public class CourseScore {
    private String studentCardNumber;
    private String courseId;
    private String score;
    private String status;
    public CourseScore(){
        studentCardNumber="";
        courseId="";
        score="";
        status="";
    }

    /**
     * 构造函数
     * @param studentCardNumber 学生一卡通号
     * @param courseId 课程ID
     * @param score 分数
     * @param status 状态
     */
    public CourseScore(String studentCardNumber, String courseId, String score, String status){
        this.studentCardNumber=studentCardNumber;
        this.courseId=courseId;
        this.score=score;
        this.status=status;
    }

    /* getters and setters */
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentCardNumber() {
        return studentCardNumber;
    }

    public void setStudentCardNumber(String studentCardNumber) {
        this.studentCardNumber = studentCardNumber;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


