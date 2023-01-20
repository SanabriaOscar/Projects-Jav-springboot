package com.example.Challenge_Spring._MVC.repository;

import com.example.Challenge_Spring._MVC.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
