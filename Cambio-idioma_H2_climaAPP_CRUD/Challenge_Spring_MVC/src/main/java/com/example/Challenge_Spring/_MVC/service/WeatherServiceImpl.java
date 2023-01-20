package com.example.Challenge_Spring._MVC.service;

import com.example.Challenge_Spring._MVC.model.Weather;
import com.example.Challenge_Spring._MVC.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WeatherServiceImpl implements IWeatherService {
    @Autowired
    private WeatherRepository weatherRepository;
    @Override
    public void saveWeather(Weather weather) {
        weatherRepository.save(weather);
    }

    @Override
    public List<Weather> listAllWeathers() {
        return weatherRepository.findAll();
    }

    @Override
    public Weather FindByIdWeather(Integer id) {
        return weatherRepository.findById(id).get();
    }

    @Override
    public void deleteWeather(Integer id) {
        weatherRepository.deleteById(id);
    }
}
