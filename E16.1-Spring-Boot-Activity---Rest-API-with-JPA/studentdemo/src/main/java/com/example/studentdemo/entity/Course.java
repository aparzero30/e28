package com.example.studentdemo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @jakarta.persistence.Id
        private Integer id;
        private String courseName;
        private String description;

    public Long getCourseId() {
        return Long.parseLong(String.valueOf(id));
    }

    public void setCourseId(Integer courseId) {
        this.id = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
