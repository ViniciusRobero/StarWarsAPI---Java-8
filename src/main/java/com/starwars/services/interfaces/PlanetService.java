package com.starwars.services.interfaces;

import com.starwars.documents.Planet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanetService {
    Planet AddPlanet(Planet model);

    List<Planet> ListPlanets();

    List<Planet> FindPlanetByName(String name);

    Planet FindPlanetById(String id);

    boolean DeletePlanet(String id);
}
