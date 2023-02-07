package com.example.studentdemo.controller;


import com.example.studentdemo.Service.CourseService;
import com.example.studentdemo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/Course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping(path="/addCourse")
    public @ResponseBody String addCourse (@RequestBody Course course){
        return  courseService.addCourse(course);
    }

    @GetMapping(path="/getAllCourse")
    public @ResponseBody List<Course> getAllCourses() {
        // This returns a JSON or
        // XML with the Book
        return courseService.findAllCourse();
    }

    @GetMapping("/id")
    public  @ResponseBody Optional<Course> getCourseById(@RequestParam long id){
        return  courseService.findCourseById(id);
    }

    @PatchMapping(path="/updateCourse")
    public @ResponseBody String updateCourse (@RequestBody Course course){
        return  courseService.addCourse(course);
    }

    @DeleteMapping (path="/delete")
    public @ResponseBody String deleteCourse (@RequestParam long id){
        return  courseService.deleteCourseById(id);
    }





}
