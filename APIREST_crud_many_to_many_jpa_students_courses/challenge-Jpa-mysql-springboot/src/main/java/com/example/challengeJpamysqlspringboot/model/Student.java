package com.example.challengeJpamysqlspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  int id;
    @Column(length = 20, nullable = false)
  private  String name;
  @Column(length = 20, nullable = false)
  private  String lastname;
  @Column(length = 20, nullable = false)
  private  String email;

 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable( name ="studentcourses",
         joinColumns =@JoinColumn(name = "id_student"),
         inverseJoinColumns =@JoinColumn(name = "id_course")
 )
 private Set<Course> courses= new HashSet<>();

}
