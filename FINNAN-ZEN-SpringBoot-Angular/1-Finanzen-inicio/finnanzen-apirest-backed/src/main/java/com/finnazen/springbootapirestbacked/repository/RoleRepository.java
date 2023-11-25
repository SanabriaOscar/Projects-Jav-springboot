package com.finnazen.springbootapirestbacked.repository;

import com.finnazen.springbootapirestbacked.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}