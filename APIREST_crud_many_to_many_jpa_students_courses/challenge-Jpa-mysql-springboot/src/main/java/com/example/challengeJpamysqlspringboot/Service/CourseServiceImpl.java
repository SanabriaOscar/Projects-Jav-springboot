package com.example.challengeJpamysqlspringboot.Service;

import com.example.challengeJpamysqlspringboot.model.Course;
import com.example.challengeJpamysqlspringboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public List<Course> ListCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findCourserByid(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}
