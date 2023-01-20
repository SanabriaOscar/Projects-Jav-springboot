package com.example.challengeJpamysqlspringboot.Service;

import com.example.challengeJpamysqlspringboot.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> ListAllStudents();
    public  Student saveStudent(Student student);
    public  Student findStudentByid(int id);
    public  void deleteStudent(int id);
}
