package com.starwars.services.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.documents.Planet;
import com.starwars.dto.PlanetDTO;
import com.starwars.dto.PlanetResultDTO;
import com.starwars.repository.PlanetRepository;
import com.starwars.services.interfaces.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PlanetServiceImp implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public Planet AddPlanet(Planet model) {
        model.setNumberOfAppearances(CalculateNumberOfAppearances(
                model.getNome(), "https://swapi.dev/api/planets/?format=json"));
        return this.planetRepository.save(model);
    }

    @Override
    public List<Planet> ListPlanets() {
        return this.planetRepository.findAll();
    }

    @Override
    public List<Planet> FindPlanetByName(String name) {
        return this.planetRepository.findByName(name);
    }

    @Override
    public Planet FindPlanetById(String id) {
        return this.planetRepository.findById(id).get();
    }

    @Override
    public boolean DeletePlanet(String id) {
        this.planetRepository.deleteById(id);
        return true;
    }

    public int CalculateNumberOfAppearances(String planetName, String url)  {
        HttpRequest request = new HttpRequest(url);
        PlanetDTO planetInfo = null;
        try {
            planetInfo = new ObjectMapper().readValue(request.get(), PlanetDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (PlanetResultDTO result : planetInfo.getResult()) {
            if (result.getName().equals(planetName))
                return result.getFilms().length;
        }

        if (planetInfo.getNext() == "" || planetInfo.getNext() == null)
            return 0;

        return CalculateNumberOfAppearances(planetName, planetInfo.getNext());
    }
}
