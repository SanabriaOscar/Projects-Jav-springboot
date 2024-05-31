package com.finnazen.springbootapirestbacked.repository;

import com.finnazen.springbootapirestbacked.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {
}
