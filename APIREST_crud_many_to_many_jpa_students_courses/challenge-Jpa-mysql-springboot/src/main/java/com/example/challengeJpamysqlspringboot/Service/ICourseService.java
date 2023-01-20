package com.example.challengeJpamysqlspringboot.Service;

import com.example.challengeJpamysqlspringboot.model.Course;

import java.util.List;

public interface ICourseService {
    public List<Course> ListCourses();
    public  Course saveCourse(Course course);
    public  Course findCourserByid(int id);
    public  void deleteCourse(int id);

}
