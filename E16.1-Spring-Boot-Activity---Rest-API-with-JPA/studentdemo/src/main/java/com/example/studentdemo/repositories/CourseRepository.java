package com.example.studentdemo.repositories;

import com.example.studentdemo.entity.Course;
import com.example.studentdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {


/*    void delete(Optional<Course> course);*/

}
