package com.finnazen.springbootapirestbacked.service.impl;

import com.finnazen.springbootapirestbacked.model.PaymentDetails;
import com.finnazen.springbootapirestbacked.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailsService {
    @Autowired
    PaymentDetailsRepository paymentDetailsRepository;

    public PaymentDetails savePaymentDetails(PaymentDetails paymentDetails) {
        return paymentDetailsRepository.save(paymentDetails);
    }

}

