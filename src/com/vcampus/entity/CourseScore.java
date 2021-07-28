package com.vcampus.entity;

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

    public CourseScore(String studentCardNumber, String courseId, String score, String status){
        this.studentCardNumber=studentCardNumber;
        this.courseId=courseId;
        this.score=score;
        this.status=status;
    }

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


