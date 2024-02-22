package com.finnazen.springbootapirestbacked.service;

import com.finnazen.springbootapirestbacked.model.Deposit;

import java.util.List;

public interface IDepositService {

    public List<Deposit> listAllDeposits();
    public Deposit saveDeposit(Deposit deposit);
    public Deposit findByIdDeposit(Long id);
    public Deposit UpdateDepositById(Deposit deposit, Long id);
    public Deposit deleteDepositById(Long id);

    interface IProductService {
    }
}
