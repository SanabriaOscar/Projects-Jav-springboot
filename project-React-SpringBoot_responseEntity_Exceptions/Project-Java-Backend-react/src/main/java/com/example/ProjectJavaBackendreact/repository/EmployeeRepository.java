package com.example.ProjectJavaBackendreact.repository;

import com.example.ProjectJavaBackendreact.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
