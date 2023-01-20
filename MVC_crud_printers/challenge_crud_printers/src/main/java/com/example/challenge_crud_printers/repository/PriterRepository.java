package com.example.challenge_crud_printers.repository;


import com.example.challenge_crud_printers.model.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriterRepository extends JpaRepository<Printer,Integer> {
}
