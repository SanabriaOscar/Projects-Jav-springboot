package com.finnazen.springbootapirestbacked.service.impl;

import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.PayMethod;
import com.finnazen.springbootapirestbacked.repository.PayMethodRepository;
import com.finnazen.springbootapirestbacked.service.IPayMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayMethodServiceImpl implements IPayMethodService {

    @Autowired
    private PayMethodRepository payMethodRepository;
    @Override
    public List<PayMethod> listAllPayMethods() {
        return payMethodRepository.findAll();
    }

    @Override
    public PayMethod savePayMethod(PayMethod payMethod) {
        payMethodRepository.save(payMethod);
        return payMethod;
    }

    @Override
    public PayMethod findByIdPayMethod(Long id) {
        Optional<PayMethod> payMethod = payMethodRepository.findById(id);
        if (!payMethod.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el método de pago con el id: " + id);
        }
        return  payMethod.get();
    }

    @Override
    public PayMethod UpdatePayMethodById(PayMethod payMethod, Long id) {
        Optional<PayMethod> payMethodUpdate = payMethodRepository.findById(id);
        if (!payMethodUpdate.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el  método de pago con el id: " + id);
        }
        payMethod.setIdPayMethod(id);
        return payMethod;
    }

    @Override
    public PayMethod deletePayMethodById(Long id) {
        Optional<PayMethod> payMethodUp = payMethodRepository.findById(id);
        if (!payMethodUp.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el  método de pago con el id: " + id);
        }
        payMethodRepository.delete(payMethodUp.get());
        return null;
    }
}
