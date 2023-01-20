package com.example.challengespringboottesting.service;

import com.example.challengespringboottesting.model.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account save(Account account);
   // public void sendMoney(Account accountFrom, Account accountTo, double monto);
    public void sendMoney(Long accountFromId, Long accountToId, double monto);
    public boolean higherMonto(Long accountFromId, Long accountToId, double monto);
    public boolean tripleValueMonto(Long accountFromId, Long accountToId, double monto);

}
