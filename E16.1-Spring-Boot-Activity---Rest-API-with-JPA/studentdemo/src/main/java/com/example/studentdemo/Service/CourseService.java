package com.example.studentdemo.Service;


import com.example.studentdemo.entity.Course;
import com.example.studentdemo.entity.Student;
import com.example.studentdemo.repositories.CourseRepository;
import com.example.studentdemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {


    @Autowired
    private CourseRepository courseRepository;


    public String addCourse(Course course){

        courseRepository.save(course);
        return  "added";

    }

    public List<Course> findAllCourse(){

        return  courseRepository.findAll();
    }

    public Optional<Course> findCourseById(Long id){
        return courseRepository.findById(id);
    }

    public String deleteCourseById(Long id){

        Optional<Course> course= findCourseById(id);
        if(course.isPresent()){
            Course foundCourse = course.get();
            courseRepository.deleteById(foundCourse.getCourseId());
            return "deleted";
        }

        return  "error";
    }

}
