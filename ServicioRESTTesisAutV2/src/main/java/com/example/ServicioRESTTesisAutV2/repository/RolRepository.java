package com.example.ServicioRESTTesisAutV2.repository;

import com.example.ServicioRESTTesisAutV2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository <Role, Integer>{

    Role findByName(String user);
}
