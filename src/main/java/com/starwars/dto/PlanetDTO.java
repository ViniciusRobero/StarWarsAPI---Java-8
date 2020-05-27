package com.starwars.dto;

public class PlanetDTO {
    private String next;
    private String previous;
    private PlanetResultDTO[] result;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public PlanetResultDTO[] getResult() {
        return result;
    }

    public void setResult(PlanetResultDTO[] result) {
        this.result = result;
    }
}
