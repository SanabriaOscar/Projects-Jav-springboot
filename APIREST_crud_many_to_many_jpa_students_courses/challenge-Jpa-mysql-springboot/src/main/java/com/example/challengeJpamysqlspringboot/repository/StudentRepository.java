package com.example.challengeJpamysqlspringboot.repository;

import com.example.challengeJpamysqlspringboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
