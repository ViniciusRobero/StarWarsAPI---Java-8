package com.starwars.dto;

import java.util.List;

public class PlanetResultDTO {
    private String name;
    private String[] films;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getFilms() {
        return films;
    }

    public void setFilms(String[] films) {
        this.films = films;
    }
}
