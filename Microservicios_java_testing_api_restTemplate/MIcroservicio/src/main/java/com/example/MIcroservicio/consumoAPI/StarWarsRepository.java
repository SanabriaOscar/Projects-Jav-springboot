package com.example.MIcroservicio.consumoAPI;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StarWarsRepository extends CrudRepository<StarWarsPerson, Integer> {

}

