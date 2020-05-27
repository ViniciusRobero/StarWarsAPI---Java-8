package com.starwars.repository;

import com.starwars.documents.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {
    @Query(value = "{}", fields = "{name : 0}")
    List<Planet> findByName(String name);
}

