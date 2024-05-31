package com.example.MIcroservicio.consumoAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    private final StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping("/all")
    public Iterable<StarWarsPerson> getAllStarWarsC() {
        return starWarsService.getAllStarWars();
    }

    @GetMapping
    public StarWarsPerson getStarWarsByIdC(@RequestParam Integer id) {
        return starWarsService.getStartWarsById(id);
    }
}
