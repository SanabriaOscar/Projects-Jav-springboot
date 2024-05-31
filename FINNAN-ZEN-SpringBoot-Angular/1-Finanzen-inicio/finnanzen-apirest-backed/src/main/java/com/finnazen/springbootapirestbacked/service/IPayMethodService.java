package com.finnazen.springbootapirestbacked.service;

import com.finnazen.springbootapirestbacked.model.PayMethod;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPayMethodService {
    public List<PayMethod> listAllPayMethods();
    public PayMethod savePayMethod(PayMethod payMethod);
    public PayMethod findByIdPayMethod(Long id);
    public PayMethod UpdatePayMethodById(PayMethod payMethod, Long id);
    public PayMethod deletePayMethodById(Long id);
}
