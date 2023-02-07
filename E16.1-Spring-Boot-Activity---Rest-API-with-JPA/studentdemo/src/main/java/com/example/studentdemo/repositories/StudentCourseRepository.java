package com.example.studentdemo.repositories;

import com.example.studentdemo.entity.Course;
import com.example.studentdemo.entity.Student;
import com.example.studentdemo.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {





}
