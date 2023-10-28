package com.example.MIcroservicio.consumoAPI;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StarWarsServiceTestAPI {

        @InjectMocks
        private StarWarsService starWarsService;

        @Mock
        private RestTemplate restTemplate;

        @Mock
        private StarWarsRepository starWarsRepository;

        @Before
        public void setUp() {
            MockitoAnnotations.initMocks(this);
        }

    @Test
    public void testGetAllStarWars() {
        JsonNode response = TestUtils.createSampleJsonResponse();
        when(restTemplate.getForObject("https://swapi.dev/api/people/", JsonNode.class)).thenReturn(response);
        Iterable<StarWarsPerson> starWarsPersons = starWarsService.getAllStarWars();
        int size = (int) starWarsPersons.spliterator().getExactSizeIfKnown();
        verify(restTemplate, times(1)).getForObject(any(String.class), eq(JsonNode.class));
        //verify(starWarsRepository, times(size)).save(any(StarWarsPerson.class));
       // verify(starWarsRepository, atLeast(1)).save(any(StarWarsPerson.class));
        assertEquals(3, size);
    }


    @Test
        public void testGetStarWarsById_WhenNotInRepository() {
            StarWarsPerson samplePerson = TestUtils.createSampleStarWarsPerson(1, "Luke", "Male");
            when(restTemplate.getForObject("https://swapi.dev/api/people/1/", StarWarsPerson.class)).thenReturn(samplePerson);
            when(starWarsRepository.findById(1)).thenReturn(Optional.empty());
            when(starWarsRepository.save(samplePerson)).thenReturn(samplePerson);
            StarWarsPerson starWarsPerson = starWarsService.getStartWarsById(1);
            verify(restTemplate, times(1)).getForObject(any(String.class), eq(StarWarsPerson.class));
            verify(starWarsRepository, times(1)).findById(1);
            verify(starWarsRepository, times(1)).save(samplePerson);
            assertEquals(samplePerson, starWarsPerson);
        }

        @Test
        public void testGetStarWarsById_WhenInRepository() {
            StarWarsPerson samplePerson = TestUtils.createSampleStarWarsPerson(1, "Luke", "Male");
            when(starWarsRepository.findById(1)).thenReturn(Optional.of(samplePerson));
            StarWarsPerson starWarsPerson = starWarsService.getStartWarsById(1);
            verify(restTemplate, never()).getForObject(any(String.class), eq(StarWarsPerson.class));
            verify(starWarsRepository, times(1)).findById(1);
            verify(starWarsRepository, never()).save(samplePerson);
            assertEquals(samplePerson, starWarsPerson);
        }
    }

