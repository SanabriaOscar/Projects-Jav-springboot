package com.example.challengeJpamysqlspringboot.repository;

import com.example.challengeJpamysqlspringboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
