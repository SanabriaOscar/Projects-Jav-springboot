package com.example.Challenge_Spring._MVC.service;

import com.example.Challenge_Spring._MVC.model.Location;
import com.example.Challenge_Spring._MVC.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.StringJoiner;

@Service
public class LocationServiceImpl implements ILocationService{
    @Autowired
    private LocationRepository  locationRepository;
    @Override
    public void saveLocation(Location location) {
        var df2= new DecimalFormat("0000.0000");
        var df= new DecimalFormat("0.0");
        location.setTemperature(Double.parseDouble(df.format(location.getTemperature())));
        location.setLon((float) Double.parseDouble(df2.format(location.getLon())));
        location.setLat((float) Double.parseDouble(df2.format(location.getLat())));
        locationRepository.save(location);
    }

    @Override
    public List<Location> listAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location FindByIdLocation(Integer id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public void deleteLocation(Integer id) {
    locationRepository.deleteById(id);
    }
}
