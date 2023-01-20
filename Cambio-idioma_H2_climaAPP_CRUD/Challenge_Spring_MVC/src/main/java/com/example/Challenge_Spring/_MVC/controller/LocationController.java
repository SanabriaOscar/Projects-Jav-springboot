package com.example.Challenge_Spring._MVC.controller;

import com.example.Challenge_Spring._MVC.model.Location;
import com.example.Challenge_Spring._MVC.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DecimalFormat;
import java.util.List;


@Controller
public class LocationController {
    @Autowired
    private LocationServiceImpl locationService;

    @GetMapping("/locations")
    public String listAllLocationsC(Model model){
        List<Location> listLocations=locationService.listAllLocations();
        model.addAttribute("listLocations", listLocations);
        return "location";
    }

    @GetMapping("/locations/new")
    public String showFormNewLoca(Model model){
        model.addAttribute("location", new Location());
        return "newLocation";

    }
    @PostMapping("/locations/save")
    public String saveLocation( Location location){

        locationService.saveLocation(location);
        return "redirect:/locations";
    }
    @GetMapping("/locations/edit/{id}")
    public String mostrarFormUpdate(@PathVariable("id") Integer id, Model model){
        Location location=locationService.FindByIdLocation(id);
        model.addAttribute("location", location);
        return "newLocation";

    }
    @GetMapping("/locations/delete/{id}")
    public String eliminarProduct(@PathVariable("id") Integer id, Model model){
        locationService.deleteLocation(id);
        return "redirect:/location";

    }
}
