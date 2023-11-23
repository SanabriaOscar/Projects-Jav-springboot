package com.finnazen.springbootapirestbacked.service.impl;

import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.Deposit;
import com.finnazen.springbootapirestbacked.repository.DepositRepository;
import com.finnazen.springbootapirestbacked.service.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositServiceImpl implements IDepositService{
    
    @Autowired
    private DepositRepository depositRepository;

    @Override
    public List<Deposit> listAllDeposits() {
        return depositRepository.findAll();
    }

    @Override
    public Deposit saveDeposit(Deposit deposit) {
        depositRepository.save(deposit);
        return deposit;
    }

    @Override
    public Deposit findByIdDeposit(Long id) {
        Optional<Deposit> deposit = depositRepository.findById(id);
        if (!deposit.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el depósito con el id: " + id);
        }
        return  deposit.get();
     
    }

    @Override
    public Deposit UpdateDepositById(Deposit deposit, Long id) {
        Optional<Deposit> depo= depositRepository.findById(id);
        if (!depo.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el depósito con el id: " + id);
        }
        deposit.setIdDeposit(id);
        return depositRepository.save(deposit);
    }

    @Override
    public Deposit deleteDepositById(Long id) {
        Optional<Deposit> deposit = depositRepository.findById(id);
        if (!deposit.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el depósito con el id: " + id);
        }
        depositRepository.delete(deposit.get());
        return null;
    }
}
