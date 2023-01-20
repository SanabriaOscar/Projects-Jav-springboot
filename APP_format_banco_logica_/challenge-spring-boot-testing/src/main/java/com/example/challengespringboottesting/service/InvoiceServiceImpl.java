package com.example.challengespringboottesting.service;

import com.example.challengespringboottesting.exceptions.InsufficientFundsException;
import com.example.challengespringboottesting.exceptions.InvalidBillIdException;
import com.example.challengespringboottesting.model.Account;
import com.example.challengespringboottesting.model.Invoice;
import com.example.challengespringboottesting.repository.AccountGateway;
import com.example.challengespringboottesting.repository.InvoiceGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;


public class InvoiceServiceImpl implements IInvoiceService{
@Autowired
private InvoiceGateway invoiceGateway;

@Autowired
private AccountGateway accountGateway;
    @Override
    public Invoice save(Invoice invoice) {
        return invoiceGateway.save(invoice);
    }



    @Override
    public boolean makePayment(Long accountFromId,  Long invoiceToId) {

    Invoice  invoice = invoiceGateway.findById(invoiceToId).get();
        Account account=accountGateway.findById(accountFromId).get();


if (account.getCurrentBalance() >=invoice.getTotalPay() &&
        account.getCurrentBalance() >= invoice.getTotalPay() +invoice.getTotalPay()*20/100){

    System.out.println("you can do the payment");
    if (account.getKindAccount()=="corriente"){
        double discont=invoice.getTotalPay()-(invoice.getTotalPay()*10)/100;
        account.setCurrentBalance(account.getCurrentBalance()-discont);
        System.out.println("Your payment have the 10 % discount"+ discont);
    }else{
        account.setCurrentBalance(account.getCurrentBalance()-invoice.getTotalPay());
    }

}else{
    System.out.println("founs insuficient");
    throw  new InsufficientFundsException("founs insuficient for do the payment");
}
        return false;
    }
    @Override
    public boolean seeIdInvoice(Long invoiceToId) {
        Invoice  invoice = invoiceGateway.findById(invoiceToId).get();
        if(invoice.getId()==invoiceToId){
            System.out.println("this es perfect");

        }
     DecimalFormat df = new DecimalFormat("000000");

        if (df.format(invoice.getId()).equals(invoiceToId)){
            System.out.println("the format is rigth");
        } else {
            throw new InvalidBillIdException("The format is not coorrect");
        }
       return false;
    }

}
