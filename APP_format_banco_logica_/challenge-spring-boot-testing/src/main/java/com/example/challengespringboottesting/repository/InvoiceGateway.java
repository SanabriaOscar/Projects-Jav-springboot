package com.example.challengespringboottesting.repository;

import com.example.challengespringboottesting.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceGateway extends JpaRepository<Invoice, Long> {
}
