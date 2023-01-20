package com.example.ServicioRESTTesisAutV2.repository;

import com.example.ServicioRESTTesisAutV2.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Integer> {
}
