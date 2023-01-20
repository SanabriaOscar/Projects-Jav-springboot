package com.example.challengespringboottesting.service;

import com.example.challengespringboottesting.exceptions.InsufficientFundsException;
import com.example.challengespringboottesting.exceptions.InvalidTargetFundsException;
import com.example.challengespringboottesting.model.Account;
import com.example.challengespringboottesting.model.Bank;
import com.example.challengespringboottesting.repository.AccountGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountServiceImpl implements  IAccountService {
    @Autowired
    private AccountGateway accountGateway;

    public List<Account> findAll() {
        return accountGateway.findAll();
    }

    @Override
    public Account save(Account account) {
        accountGateway.save(account);
        return account;
    }


    @Override
    public void sendMoney(Long accountFromId, Long accountToId, double monto) {
        Account accountFrom = accountGateway.findById(accountFromId).get();
        Account accountTo = accountGateway.findById(accountToId).get();
        accountFrom.setCurrentBalance(accountFrom.getCurrentBalance() - monto);
        accountTo.setCurrentBalance(accountTo.getCurrentBalance() + monto);

        if (accountFrom.getCurrentBalance() >= monto) {
            System.out.println("the transaction can be made");
            Bank bank = new Bank(1L, "test");
            if (bank.getId() != 5) {
                accountFrom.setCurrentBalance(accountFrom.getCurrentBalance() - monto + 3500);
                System.out.println("consignment has been made to another bank and 3500 will be deducted");
            }

        }else {
            //System.out.println("founds insuficients");
        throw new InsufficientFundsException("Founds insufficient");
        }

    }

    @Override
    public boolean higherMonto(Long accountFromId, Long accountToId, double monto) {
        Account accountFrom = accountGateway.findById(accountFromId).get();
        Account accountTo = accountGateway.findById(accountToId).get();
        accountFrom.setCurrentBalance(accountFrom.getCurrentBalance() - monto);
        accountTo.setCurrentBalance(accountTo.getCurrentBalance() + monto);
        if (monto >= 1500000) {
            double montoLess = monto * 3 / 100 ;
            accountTo.setCurrentBalance(montoLess);
            System.out.println("they have consigned you " + monto
                    + "for the discount your consignment balance is " + montoLess);
        }
        return false;
    }

    @Override
    public boolean tripleValueMonto(Long accountFromId, Long accountToId, double monto) {
        Account accountFrom = accountGateway.findById(accountFromId).get();
        Account accountTo = accountGateway.findById(accountToId).get();

        if (accountTo.getKindAccount() == "corriente") {
            System.out.println("This a account corriente");
            if (accountTo.getCurrentBalance() > monto * 3) {
               throw  new InvalidTargetFundsException("this is a error tha amount is higher that current balance");
            } else {
                accountFrom.setCurrentBalance(accountFrom.getCurrentBalance() - monto);
                accountTo.setCurrentBalance(accountTo.getCurrentBalance() + monto);
                System.out.println("you can do the transfer");
            }
        }if(accountTo.getKindAccount() == "savings"){
            accountFrom.setCurrentBalance(accountFrom.getCurrentBalance() - monto);
            accountTo.setCurrentBalance(accountTo.getCurrentBalance() + monto);
            System.out.println("uor account is savings don't have discoint");
        }
        return false;
    }



}