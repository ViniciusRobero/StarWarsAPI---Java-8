package com.starwars.documents;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Document
public class Planet {

    @Id
    private String id;
    private String nome;
    private String terreno;
    private String clima;
    private Integer numberOfAppearances;

    public Planet() {
    }

    public Integer getNumberOfAppearances() {
        return numberOfAppearances;
    }

    public void setNumberOfAppearances(Integer numberOfAppearances) {
        this.numberOfAppearances = numberOfAppearances;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 1, message = "Name cannot be empty.")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotNull
    @Size(min = 1, message = "Terreno cannot be empty.")
    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    @NotNull
    @Size(min = 1, message = "Clima cannot be empty.")
    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

}
