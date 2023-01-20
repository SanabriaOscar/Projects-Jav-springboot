package com.example.challengeJpamysqlspringboot.Service;

import com.example.challengeJpamysqlspringboot.model.Student;
import com.example.challengeJpamysqlspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> ListAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student findStudentByid(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudent(int id) {
studentRepository.deleteById(id);
    }
}
