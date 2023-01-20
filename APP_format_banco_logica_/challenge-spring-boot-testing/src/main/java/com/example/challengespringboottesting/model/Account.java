package com.example.challengespringboottesting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private  String name;
    private  String lastName;
    private  String accountNumber;
    private  String kindAccount;
    private String identification;
    private double currentBalance;
    private  Bank bank;

}
