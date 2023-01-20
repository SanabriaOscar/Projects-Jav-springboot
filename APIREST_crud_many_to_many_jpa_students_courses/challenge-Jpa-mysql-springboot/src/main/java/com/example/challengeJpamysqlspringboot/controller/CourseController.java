package com.example.challengeJpamysqlspringboot.controller;

import com.example.challengeJpamysqlspringboot.Service.ICourseService;
import com.example.challengeJpamysqlspringboot.Service.IStudentService;
import com.example.challengeJpamysqlspringboot.model.Course;
import com.example.challengeJpamysqlspringboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private ICourseService courseService;
    @Autowired
    private IStudentService studentService;

    @GetMapping("/courses")
    public List<Course> listAllCourses(){
        return courseService.ListCourses();
    }

    @PostMapping("/courses/new")
    public void SaveStudent(@RequestBody Course course){
        courseService.saveCourse(course);

    }
    @GetMapping("/courses/{id}")
    public Course listByIDCourses( @PathVariable Integer id){
       return courseService.findCourserByid(id);
    }

 @PutMapping("/courses/{id}")
    public Course updateCourse(@RequestBody Course course, @PathVariable Integer id){
        Course course1=courseService.findCourserByid(id);
        course1.setName(course.getName());
        courseService.saveCourse(course1);
        return course1;
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Integer id){
         courseService.deleteCourse(id);
    }
}
