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
public class Invoice {
    @Id
    @GeneratedValue
    private Long Id;
    private  Company company;
    private String name;
    private String dueDate;
    private double totalPay;


}
