package com.finnazen.springbootapirestbacked.repository;

import com.finnazen.springbootapirestbacked.model.PayMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayMethodRepository extends JpaRepository<PayMethod, Long> {

}
