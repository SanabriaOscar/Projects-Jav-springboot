package com.example.Challenge_Spring._MVC.controller;

import com.example.Challenge_Spring._MVC.model.Location;
import com.example.Challenge_Spring._MVC.model.Weather;
import com.example.Challenge_Spring._MVC.service.LocationServiceImpl;
import com.example.Challenge_Spring._MVC.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class WeatherController {
//    @GetMapping("/")
//    public  String home(){
//        return "index";
//    }
    @Autowired
    private WeatherServiceImpl weatherService;
    @Autowired
    private LocationServiceImpl locationService;
    @GetMapping("/")
    public  String listAllWeathers(Model model){
        List<Weather> listWeathers=weatherService.listAllWeathers();
        model.addAttribute("listWeathers", listWeathers);
        return "index";
    }
    @GetMapping("/weathers/new")
    public String mostrarFormNewCate(Model model){
        List<Location>listLocations=locationService.listAllLocations();
        model.addAttribute("weather", new Weather());
        model.addAttribute("listLocations", listLocations);
        return "newWeather";

    }

    @PostMapping("/weathers/save")
    public String saveWeather( Weather weather){
        weatherService.saveWeather(weather);
        return "redirect:/";
    }

    @GetMapping("/weathers/edit/{id}")
    public String mostrarFormUpdate(@PathVariable("id") Integer id, Model model){
        List<Location>listLocations=locationService.listAllLocations();
        Weather weather=weatherService.FindByIdWeather(id);
        model.addAttribute("weather", weather);
        model.addAttribute("listLocations", listLocations);
        return "newWeather";

    }
    @GetMapping("/weathers/delete/{id}")
    public String deleteWeather(@PathVariable("id") Integer id, Model model){
    weatherService.deleteWeather(id);
        return "redirect:/";

    }

}
