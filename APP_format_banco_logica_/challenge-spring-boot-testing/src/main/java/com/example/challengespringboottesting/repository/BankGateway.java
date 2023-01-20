package com.example.challengespringboottesting.repository;

import com.example.challengespringboottesting.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankGateway extends JpaRepository<Bank, Long> {
}
