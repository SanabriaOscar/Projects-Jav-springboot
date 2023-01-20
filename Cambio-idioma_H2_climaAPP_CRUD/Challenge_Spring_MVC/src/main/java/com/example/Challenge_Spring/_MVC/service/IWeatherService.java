package com.example.Challenge_Spring._MVC.service;

import com.example.Challenge_Spring._MVC.model.Weather;

import java.util.List;

public interface IWeatherService {
    void saveWeather(Weather weather);
    List<Weather>listAllWeathers();
    Weather FindByIdWeather(Integer id);
    void deleteWeather(Integer id);
}
