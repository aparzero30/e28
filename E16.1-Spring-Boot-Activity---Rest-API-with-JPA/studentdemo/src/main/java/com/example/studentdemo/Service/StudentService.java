package com.example.studentdemo.Service;


import com.example.studentdemo.entity.Course;
import com.example.studentdemo.entity.Student;
import com.example.studentdemo.entity.StudentCourse;
import com.example.studentdemo.repositories.StudentCourseRepository;
import com.example.studentdemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentCourseRepository studentCourseRepository;


    public String addStudent(Student student){

    studentRepository.save(student);
    return  "added";

    }

    public List<Student> findAllStudent(){

        return  studentRepository.findAll();
    }


    public Optional<Student> findStudentById(Long id){
       return studentRepository.findById(id);
    }


    public String enroll(Course course, Long studentID){



        Optional<Student> student = findStudentById(studentID);

        if( student.isPresent()){
            Student foundStudent = student.get();
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setStudent_id(Math.toIntExact(foundStudent.getId()));
            studentCourse.setCourse_id(Math.toIntExact(course.getCourseId()));

            studentCourseRepository.save(studentCourse);


            return  "enrolled";

        }

        return  "error";

    }



    public String drop(Course course, Long studentID){



        Optional<Student> student = findStudentById(studentID);

        if( student.isPresent()){
            Student foundStudent = student.get();

            List<StudentCourse> studentCourses = studentCourseRepository.findAll();


            for(StudentCourse studentCourse: studentCourses){
                if(studentCourse.getStudent_id()==foundStudent.getId() && studentCourse.getCourse_id() == course.getCourseId()){
                    studentCourseRepository.delete(studentCourse);
                    break;
                }
            }







            return  "dropped";

        }

        return  "error";

    }









    public String deleteStudentById(Long id){

        Optional<Student> student = findStudentById(id);
        if(student.isPresent()){
            Student foundStudent = student.get();
            studentRepository.deleteById(foundStudent.getId());
            return "deleted";
        }

        return  "error";
    }

    public String updateStudentById(Long id, Student student){

        Optional<Student> student1 = findStudentById(id);
        if(student1.isPresent()){
            Student foundStudent = student1.get();
            student.setId(Integer.parseInt(String.valueOf(foundStudent.getId())));
            return addStudent(student);

        }

        return  "error";
    }




}
