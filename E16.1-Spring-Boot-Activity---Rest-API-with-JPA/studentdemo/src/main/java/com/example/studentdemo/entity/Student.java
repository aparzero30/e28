package com.example.studentdemo.entity;

//import jakarta.persistence.*;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;


@Entity
@Table(name="student")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @jakarta.persistence.Id
    private Integer id;



    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Course> courses;


//    private String course;

    private String first_name;
    private String last_name;
    private String email;


    private int level;

    private String birthday;




    public Long getId() {
        return Long.parseLong(String.valueOf(id));
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }*/

    public List<Course> getCourses() {
        return courses;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthDay() {
        return birthday;
    }


}
