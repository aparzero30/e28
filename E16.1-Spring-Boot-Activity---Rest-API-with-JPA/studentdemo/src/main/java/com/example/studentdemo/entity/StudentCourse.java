package com.example.studentdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student_course")
public class StudentCourse {


    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @jakarta.persistence.Id
    private Integer id;



    private int student_id;


    private int course_id;


    public int getCourse_id() {
        return course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

    }
}
