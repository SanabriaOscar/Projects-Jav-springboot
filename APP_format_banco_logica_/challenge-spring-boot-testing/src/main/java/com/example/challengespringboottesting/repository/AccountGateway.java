package com.example.challengespringboottesting.repository;

import com.example.challengespringboottesting.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountGateway extends JpaRepository<Account, Long> {

}
