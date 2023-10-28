package com.example.MIcroservicio.consumoAPI;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService  {
    @Autowired
    private  RestTemplate restTemplate;
    @Autowired
    private  StarWarsRepository starWarsRepository;
    private final String apiUrl = "https://swapi.dev/api/people/";

    public Iterable<StarWarsPerson> getAllStarWars() {
        String apiURL = apiUrl;
        JsonNode response = restTemplate.getForObject(apiURL, JsonNode.class);

        List<StarWarsPerson> starWarsPersons = new ArrayList<>();

        if (response != null && response.has("results")) {
            JsonNode results = response.get("results");
            for (JsonNode result : results) {
                StarWarsPerson person = new StarWarsPerson();
                person.setName(result.get("name").asText());
                person.setGender(result.get("gender").asText());
                starWarsPersons.add(person);
            }
        }

        return starWarsPersons;
    }

    public StarWarsPerson getStartWarsById(Integer id) {
        StarWarsPerson starWarsPerson = starWarsRepository.findById(id).orElse(null);
        if (starWarsPerson == null) {
            String apiURL = apiUrl + id + "/";
            starWarsPerson = restTemplate.getForObject(apiURL, StarWarsPerson.class);
            if (starWarsPerson != null) {
                // se guarda en la base de datos
                starWarsRepository.save(starWarsPerson);
            }
        }
        return starWarsPerson;
    }

}
