package com.example.domain;

public class CoastalCity extends City {
    private String seaOrOcean;

    public CoastalCity() {}

    public CoastalCity(String name, int population, String seaOrOcean) {
        super(name, population);
        this.seaOrOcean = seaOrOcean;
    }

    public String getSeaOrOcean() {
        return seaOrOcean;
    }

    public void setSeaOrOcean(String seaOrOcean) {
        this.seaOrOcean = seaOrOcean;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", у моря/океана: " + seaOrOcean;
    }
}


