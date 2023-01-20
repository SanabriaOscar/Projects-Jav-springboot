package com.example.challengespringboottesting.service;

import com.example.challengespringboottesting.model.Bank;
import com.example.challengespringboottesting.repository.BankGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class BanckServiceImpl implements  IBankService{

    @Autowired
    private BankGateway bankRepository;
    @Override
    public Bank save(Bank bank) {
        bankRepository.save(bank);

        return bank;
    }



}
