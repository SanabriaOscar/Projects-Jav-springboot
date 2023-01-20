package com.example.challengeJpamysqlspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(length = 20, nullable = false)
    private  String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

}
