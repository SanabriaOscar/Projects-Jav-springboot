package com.example.challengespringboottesting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bank   {
    @Id
    @GeneratedValue
    private Long Id;
    String name;
}
