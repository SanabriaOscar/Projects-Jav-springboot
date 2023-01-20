package com.example.Challenge_Spring._MVC.repository;

import com.example.Challenge_Spring._MVC.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
