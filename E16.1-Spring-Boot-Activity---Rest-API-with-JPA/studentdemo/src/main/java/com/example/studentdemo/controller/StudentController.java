package com.example.studentdemo.controller;


import com.example.studentdemo.Service.StudentService;
import com.example.studentdemo.entity.Course;
import com.example.studentdemo.entity.Student;
import com.example.studentdemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller

@RequestMapping(path="/student")
public class StudentController {
    @Autowired
    StudentService studentService;


    @PostMapping(path="/addStudent")
    public @ResponseBody String addStudent (@RequestBody Student student) {




       return studentService.addStudent(student);



    }


    @GetMapping(path="/getAllStudents")
    public @ResponseBody Iterable<Student> getAllStudents() {
        // This returns a JSON or
        // XML with the Book
        return studentService.findAllStudent();
    }


    @GetMapping("/id")
    public  @ResponseBody Optional<Student> getById(@RequestParam long id){
        return  studentService.findStudentById(id);

        //sample  postman request Http://localhost:8080/student/id?id=2
    }




    @PatchMapping (path="/update")
    public @ResponseBody String updateStudent (@RequestParam long id, @RequestBody Student student) {


        return  studentService.updateStudentById(id, student);
    }

    @PostMapping (path="/enroll")
    public  @ResponseBody String enroll(@RequestBody Course course, @RequestParam long studentID){
       return studentService.enroll(course, studentID);
    }


    @DeleteMapping (path="/delete")
    public  @ResponseBody String deleteStudendByID(@RequestParam long studentID){
        return studentService.deleteStudentById(studentID);
    }


    @DeleteMapping(path="/drop")
    public  @ResponseBody String drop(@RequestBody Course course, @RequestParam long studentID){
        return studentService.drop(course, studentID);
    }



}
