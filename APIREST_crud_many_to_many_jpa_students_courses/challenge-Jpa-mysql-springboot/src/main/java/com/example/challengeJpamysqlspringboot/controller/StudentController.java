package com.example.challengeJpamysqlspringboot.controller;

import com.example.challengeJpamysqlspringboot.Service.ICourseService;
import com.example.challengeJpamysqlspringboot.Service.IStudentService;
import com.example.challengeJpamysqlspringboot.model.Course;
import com.example.challengeJpamysqlspringboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICourseService courseService;

    @GetMapping("/students")
    public List<Student>listAllStudents(){
        return  studentService.ListAllStudents();
    }
    @PostMapping("/students/new")
    public void SaveStudent(@RequestBody Student student){
        studentService.saveStudent(student);

    }
    @GetMapping("/students/{id}")
    public Student listByIdStudent(@PathVariable Integer id){
        return studentService.findStudentByid(id);
    }


    @PutMapping("/{coursetId}/students/{studentId}")
    Student addStudentToCourse(
            @PathVariable Integer coursetId,
            @PathVariable Integer studentId
    ) {
        Student student = studentService.findStudentByid(studentId);
        Course course = courseService.findCourserByid(coursetId);

        student.getCourses().add(course);
        return studentService.saveStudent(student);

    }
    @DeleteMapping("/students/{id}")
    public void deleteCourse(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

}
