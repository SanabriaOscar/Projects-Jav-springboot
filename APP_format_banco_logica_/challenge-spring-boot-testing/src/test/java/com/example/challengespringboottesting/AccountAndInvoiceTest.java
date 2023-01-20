package com.example.challengespringboottesting;

import com.example.challengespringboottesting.exceptions.InvalidBillIdException;
import com.example.challengespringboottesting.model.Account;
import com.example.challengespringboottesting.model.Bank;
import com.example.challengespringboottesting.model.Company;
import com.example.challengespringboottesting.model.Invoice;
import com.example.challengespringboottesting.repository.AccountGateway;
import com.example.challengespringboottesting.repository.InvoiceGateway;
import com.example.challengespringboottesting.service.AccountServiceImpl;
import com.example.challengespringboottesting.service.InvoiceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


public class AccountAndInvoiceTest {
    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountGateway accountGateway;
    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @Mock
    private InvoiceGateway invoiceGateway;

    @BeforeEach
    public  void setup(){
        MockitoAnnotations.openMocks( this);
    }
    List<Account> MockList = new ArrayList<>();
    Account accountFrom= new Account(1L,"juan", "perez",
            "125555","corriente", "123545",
            60000, new Bank(1L, "other"));
    Account accountTo= new Account(5L,"pedro", "sanchez",
            "125555","corriente", "123545",
            4000, new Bank(5L, "globant"));


//MockList.add(accountFrom);
//MockList.add(accountTo);

    @Test
    public void testSendMOney() {

       when(accountGateway.findById(accountFrom.getId())).thenReturn(Optional.of(accountFrom));
       when(accountGateway.findById(accountTo.getId())).thenReturn(Optional.of(accountTo));
       accountService.sendMoney(1L,5L,20000) ;
    }
    @Test
    public void testMayorMonto() {

        when(accountGateway.findById(accountFrom.getId())).thenReturn(Optional.of(accountFrom));
        when(accountGateway.findById(accountTo.getId())).thenReturn(Optional.of(accountTo));
        accountService.higherMonto(1L,5L,20000000);
    }
    @Test
    public void testTripleValueMonto() {

        when(accountGateway.findById(accountFrom.getId())).thenReturn(Optional.of(accountFrom));
        when(accountGateway.findById(accountTo.getId())).thenReturn(Optional.of(accountTo));

        accountService.tripleValueMonto(1L,5L,12000);
    }
    Account accountFrom2= new Account(1L,"juan", "perez",
            "125555","corriente", "123545",
            60000, new Bank(1L, "other"));
    Invoice invoicePay= new Invoice( 1L, new Company(1L, "company globant"),
            "invoice#1","03/09/2022",4000);

    @Test
    public void testPaymentInvoice() {
        when(invoiceGateway.findById(invoicePay.getId())).thenReturn(Optional.of(invoicePay));
        when(accountGateway.findById(accountFrom2.getId())).thenReturn(Optional.of(accountFrom2));
        invoiceService.makePayment(1L,1L);
    }

    Invoice invoicePay2= new Invoice( 1L, new Company(1L, "company globant"),
            "invoice#1","03/09/2022",4000);
    @Test
    public void testValidateIdInvoice() {

        when(invoiceGateway.findById(invoicePay2.getId())).thenReturn(Optional.of(invoicePay2));
        InvalidBillIdException ex = assertThrows(InvalidBillIdException.class,
                () -> invoiceService.seeIdInvoice(000001L));
        assertEquals("The format is not coorrect", ex.getMessage());
    }
}
