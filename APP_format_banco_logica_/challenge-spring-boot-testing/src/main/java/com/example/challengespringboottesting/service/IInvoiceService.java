package com.example.challengespringboottesting.service;

import com.example.challengespringboottesting.model.Invoice;

public interface IInvoiceService {
    Invoice save(Invoice invoice);
   boolean makePayment (Long accountFromId, Long InvoiceToId);
    public boolean seeIdInvoice(Long invoiceToId);

}
