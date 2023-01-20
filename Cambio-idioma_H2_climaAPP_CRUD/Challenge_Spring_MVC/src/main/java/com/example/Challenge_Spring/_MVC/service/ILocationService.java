package com.example.Challenge_Spring._MVC.service;

import com.example.Challenge_Spring._MVC.model.Location;

import java.util.List;

public interface ILocationService {
    void saveLocation(Location location);
    List<Location>listAllLocations();
    Location FindByIdLocation(Integer id);
    void deleteLocation(Integer id);
}
