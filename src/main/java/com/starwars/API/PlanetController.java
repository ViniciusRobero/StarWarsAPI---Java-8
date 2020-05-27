package com.starwars.API;


import com.starwars.documents.Planet;
import com.starwars.responses.Response;
import com.starwars.services.interfaces.PlanetService;
import com.sun.org.apache.xpath.internal.objects.XString;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/planets")
public class PlanetController {

    @Autowired
    private PlanetService _planetService;

    @GetMapping
    public ResponseEntity<Response<List<Planet>>> ListAllPlanets() {
        return ResponseEntity
                .ok(new Response<List<Planet>>(this._planetService.ListPlanets()));
    }

    @PostMapping
    public ResponseEntity<Response<Planet>> Add(@Valid @RequestBody Planet model, BindingResult result) {
        if (result.hasErrors()) {
            List<String> erros = new ArrayList<String>();
            result.getAllErrors()
                    .forEach(erro ->
                            erros.add((erro.getDefaultMessage())));
            return ResponseEntity.badRequest().body(new Response<Planet>(erros));

        }

        return ResponseEntity
                .ok(new Response<Planet>(this._planetService.AddPlanet(model)));
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Response<List<Planet>>> FindByName(@PathVariable(name = "name") String name) {
        return ResponseEntity
                .ok(new Response<List<Planet>>(this._planetService.FindPlanetByName(name)));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response<Planet>> FindPlanetById(@PathVariable(name = "id") String id) {
        return ResponseEntity
                .ok(new Response<Planet>(this._planetService.FindPlanetById(id)));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response<Boolean>> Delete(@PathVariable(name = "id") String id) {
        return ResponseEntity
                .ok(new Response<Boolean>(this._planetService.DeletePlanet(id)));
    }
}

