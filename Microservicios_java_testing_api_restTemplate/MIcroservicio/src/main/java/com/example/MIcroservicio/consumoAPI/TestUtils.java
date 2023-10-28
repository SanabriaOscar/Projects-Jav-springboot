package com.example.MIcroservicio.consumoAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestUtils {
    public static JsonNode createSampleJsonResponse() {
        // Crea y devuelve un objeto JsonNode simulado para las pruebas
        // Puedes configurar los datos según tus necesidades
        // Ejemplo:
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.putArray("results")
                .add(createSampleStarWarsPersonJson("Luke", "Male"))
                .add(createSampleStarWarsPersonJson("Leia", "Female"))
                .add(createSampleStarWarsPersonJson("Han", "Male"));
        return rootNode;
    }

    public static ObjectNode createSampleStarWarsPersonJson(String name, String gender) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode personNode = objectMapper.createObjectNode();
        personNode.put("name", name);
        personNode.put("gender", gender);
        return personNode;
    }

    public static StarWarsPerson createSampleStarWarsPerson(int id, String name, String gender) {
        // Crea y devuelve un objeto StarWarsPerson simulado para las pruebas
        StarWarsPerson starWarsPerson = new StarWarsPerson();
        starWarsPerson.setId(id);
        starWarsPerson.setName(name);
        starWarsPerson.setGender(gender);
        return starWarsPerson;
    }
}
